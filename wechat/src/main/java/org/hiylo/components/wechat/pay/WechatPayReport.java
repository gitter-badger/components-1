/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatPayReport.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.pay;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.hiylo.components.wechat.config.WechatConfig;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * 交易保障
 */
public class WechatPayReport {

    private static final String REPORT_URL = "http://report.mch.weixin.qq.com/wxpay/report/default";
    private static final int DEFAULT_CONNECT_TIMEOUT_MS = 6 * 1000;
    private static final int DEFAULT_READ_TIMEOUT_MS = 8 * 1000;
    private volatile static WechatPayReport INSTANCE;
    private LinkedBlockingQueue<String> reportMsgQueue = null;
    private WechatConfig config;
    private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("wxPayReport").build();
    private ExecutorService pool = new ThreadPoolExecutor(5, 50,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    private WechatPayReport(final WechatConfig config) {
        this.config = config;
        reportMsgQueue = new LinkedBlockingQueue<String>(config.getReportQueueMaxSize());
        if (config.shouldAutoReport()) {
            WechatPayUtil.getLogger().info("report worker num: {}", config.getReportWorkerNum());
            for (int i = 0; i < config.getReportWorkerNum(); ++i) {
                pool.execute(() -> {
                    while (true) {
                        // 先用 take 获取数据
                        try {
                            StringBuilder sb = new StringBuilder();
                            String firstMsg = reportMsgQueue.take();
                            WechatPayUtil.getLogger().info("get first report msg: {}", firstMsg);
                            String msg = null;
                            sb.append(firstMsg);
                            int remainNum = config.getReportBatchSize() - 1;
                            for (int j = 0; j < remainNum; ++j) {
                                WechatPayUtil.getLogger().info("try get remain report msg");
                                // msg = reportMsgQueue.poll();  // 不阻塞了
                                msg = reportMsgQueue.take();
                                WechatPayUtil.getLogger().info("get remain report msg: {}", msg);
                                sb.append("\n");
                                sb.append(msg);
                            }
                            WechatPayReport.httpRequest(sb.toString(), DEFAULT_CONNECT_TIMEOUT_MS);
                        } catch (Exception ex) {
                            WechatPayUtil.getLogger().warn("report fail. reason: {}", ex.getMessage());
                        }
                    }
                });
            }
        }

    }

    /**
     * 单例，双重校验，请在 JDK 1.5及更高版本中使用
     *
     * @param config
     * @return
     */
    static WechatPayReport getInstance(WechatConfig config) {
        if (INSTANCE == null) {
            synchronized (WechatPayReport.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WechatPayReport(config);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * http 请求
     *
     * @param data
     * @param connectTimeoutMs
     * @return
     * @throws Exception
     */
    private static String httpRequest(String data, int connectTimeoutMs) throws IOException {
        BasicHttpClientConnectionManager connManager;
        connManager = new BasicHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
                        .build(),
                null,
                null,
                null
        );
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();

        HttpPost httpPost = new HttpPost(REPORT_URL);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(WechatPayReport.DEFAULT_READ_TIMEOUT_MS).setConnectTimeout(connectTimeoutMs).build();
        httpPost.setConfig(requestConfig);

        StringEntity postEntity = new StringEntity(data, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        // TODO: 很重要，用来检测 sdk 的使用情况，要不要加上商户信息？
        httpPost.addHeader("User-Agent", "wxpay sdk java v1.0 ");
        httpPost.setEntity(postEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");
    }

    void report(String uuid, long elapsedTimeMillis,
                String firstDomain, boolean primaryDomain, int firstConnectTimeoutMillis, int firstReadTimeoutMillis,
                boolean firstHasDnsError, boolean firstHasConnectTimeout, boolean firstHasReadTimeout) {
        long currentTimestamp = WechatPayUtil.getCurrentTimestamp();
        ReportInfo reportInfo = new ReportInfo(uuid, currentTimestamp, elapsedTimeMillis,
                firstDomain, primaryDomain, firstConnectTimeoutMillis, firstReadTimeoutMillis,
                firstHasDnsError, firstHasConnectTimeout, firstHasReadTimeout);
        String data = reportInfo.toLineString(config.getKey());
        WechatPayUtil.getLogger().info("report {}", data);
        if (Objects.nonNull(data)) {
            reportMsgQueue.offer(data);
        }
    }


    @Deprecated
    private void reportSync(final String data) throws Exception {
        httpRequest(data, DEFAULT_CONNECT_TIMEOUT_MS);
    }

    @Deprecated
    private void reportAsync(final String data) {
        pool.execute(() -> {
            try {
                httpRequest(data, DEFAULT_CONNECT_TIMEOUT_MS);
            } catch (Exception ex) {
                WechatPayUtil.getLogger().warn("report fail. reason: {}", ex.getMessage());
            }
        });
    }

    public static class ReportInfo {

        /**
         * 布尔变量使用int。0为false， 1为true。
         */

        // 基本信息
        private String version = "v0";
        private String sdk = "wxpay java sdk v1.0";
        private String uuid;  // 交易的标识
        private long timestamp;   // 上报时的时间戳，单位秒
        private long elapsedTimeMillis; // 耗时，单位 毫秒

        // 针对主域名
        private String firstDomain;  // 第1次请求的域名
        private boolean primaryDomain; //是否主域名
        private int firstConnectTimeoutMillis;  // 第1次请求设置的连接超时时间，单位 毫秒
        private int firstReadTimeoutMillis;  // 第1次请求设置的读写超时时间，单位 毫秒
        private int firstHasDnsError;  // 第1次请求是否出现dns问题
        private int firstHasConnectTimeout; // 第1次请求是否出现连接超时
        private int firstHasReadTimeout; // 第1次请求是否出现连接超时

        ReportInfo(String uuid, long timestamp, long elapsedTimeMillis, String firstDomain, boolean primaryDomain, int firstConnectTimeoutMillis, int firstReadTimeoutMillis, boolean firstHasDnsError, boolean firstHasConnectTimeout, boolean firstHasReadTimeout) {
            this.uuid = uuid;
            this.timestamp = timestamp;
            this.elapsedTimeMillis = elapsedTimeMillis;
            this.firstDomain = firstDomain;
            this.primaryDomain = primaryDomain;
            this.firstConnectTimeoutMillis = firstConnectTimeoutMillis;
            this.firstReadTimeoutMillis = firstReadTimeoutMillis;
            this.firstHasDnsError = firstHasDnsError ? 1 : 0;
            this.firstHasConnectTimeout = firstHasConnectTimeout ? 1 : 0;
            this.firstHasReadTimeout = firstHasReadTimeout ? 1 : 0;
        }

        @Override
        public String toString() {
            return "ReportInfo{" +
                    "version='" + version + '\'' +
                    ", sdk='" + sdk + '\'' +
                    ", uuid='" + uuid + '\'' +
                    ", timestamp=" + timestamp +
                    ", elapsedTimeMillis=" + elapsedTimeMillis +
                    ", firstDomain='" + firstDomain + '\'' +
                    ", primaryDomain=" + primaryDomain +
                    ", firstConnectTimeoutMillis=" + firstConnectTimeoutMillis +
                    ", firstReadTimeoutMillis=" + firstReadTimeoutMillis +
                    ", firstHasDnsError=" + firstHasDnsError +
                    ", firstHasConnectTimeout=" + firstHasConnectTimeout +
                    ", firstHasReadTimeout=" + firstHasReadTimeout +
                    '}';
        }

        /**
         * 转换成 csv 格式
         *
         * @return
         */
        String toLineString(String key) {
            String separator = ",";
            Object[] objects = new Object[]{
                    version, sdk, uuid, timestamp, elapsedTimeMillis,
                    firstDomain, primaryDomain, firstConnectTimeoutMillis, firstReadTimeoutMillis,
                    firstHasDnsError, firstHasConnectTimeout, firstHasReadTimeout
            };
            StringBuilder sb = new StringBuilder();
            for (Object obj : objects) {
                sb.append(obj).append(separator);
            }
            try {
                String sign = WechatPayUtil.HMACSHA256(sb.toString(), key);
                sb.append(sign);
                return sb.toString();
            } catch (Exception ex) {
                return null;
            }

        }

    }

}
