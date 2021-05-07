/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatConfig.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.config;

import org.hiylo.components.commons.utils.StringUtils;
import org.hiylo.components.exceptions.CommonsException;
import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;
import org.hiylo.components.wechat.pay.IWechatPayDomain;
import org.hiylo.components.wechat.pay.WechatPayDomainSimpleImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

/**
 * 微信配置信息类
 *
 * @author hiylo
 * @date 2021年5月7日 18:43:13
 */
@ConfigurationProperties(prefix = "wechat", ignoreInvalidFields = false)
public class WechatConfig implements Serializable, com.github.wxpay.sdk.WXPayConfig {
    public static final String EXCEPTION_CODE_PAYMENT_TOTAL_FEE_CANT_BE_ZERO = "0x10700001";
    public static final String EXCEPTION_CODE_PAYMENT_REQUEST_THIRD_PART_FAIL = "0x10700002";
    private static final Integer DEFAULT_REPORT_WORKER_NUM = 6;
    private static final Integer DEFAULT_REPORT_BATCH_SIZE = 10;
    private static final Integer DEFAULT_REPORT_QUEUE_MAX_SIZE = 10000;
    private static final long serialVersionUID = -1;
    private String certPath;
    private byte[] certData;
    private String appID;
    private String appsecret;
    private String partner;
    private String partnerkey;
    private Map<String, String> properties = new HashMap<>();

    public WechatConfig() {
    }

    /**
     * 非Spring模式使用
     *
     * @param configFile properties文件位置
     * @throws IOException      文件异常
     * @throws CommonsException 配置丢失会抛出此异常
     */
    public WechatConfig(String configFile) throws IOException, CommonsException {
        Properties properties = new Properties();
        InputStream inputStream = WechatConfig.class.getClassLoader().getResourceAsStream(configFile);
        try {
            if (Objects.nonNull(inputStream) && inputStream.available() != -1) {
                properties.load(inputStream);
                this.appID = properties.getProperty("wechat.appID");
                this.appsecret = properties.getProperty("wechat.appsecret");
                this.partner = properties.getProperty("wechat.partner");
                this.partnerkey = properties.getProperty("wechat.partnerkey");
                if (StringUtils.isEmpty(appID, appsecret, partner, partnerkey)) {
                    throw CommonsException.<CommonsException>buildException(Constants.EXCEPTION_CODE_CONFIG_PROPERTY_MISSING);
                }
                this.init();
            } else {
                throw new IOException("Config file is not available! Please provider a available config file!");
            }
        } finally {
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        }
    }

    public WechatConfig(String appID, String appsecret, String partner, String partnerkey) {
        this.appID = appID;
        this.appsecret = appsecret;
        this.partner = partner;
        this.partnerkey = partnerkey;
        this.init();
    }

    public WechatConfig(String appID, String appsecret, String partner, String partnerkey, byte[] certData) {
        this.appID = appID;
        this.appsecret = appsecret;
        this.partner = partner;
        this.partnerkey = partnerkey;
        this.certData = certData;
        this.init();
    }

    public static void main(String[] args) {
    }

    @PostConstruct
    public void init() {

    }

    public void setCertPath(String certPath) throws IOException {
        this.certPath = certPath;
        InputStream certStream = null;
        try {
            try {
                File file = new File(ResourceUtils.getURL(certPath).getFile());
                certStream = ResourceUtils.getURL(certPath).openStream();
                this.certData = new byte[(int) file.length()];
                int length = certStream.read(this.certData);
                if (length != file.length()) {
                    throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_UNKNOWN_ERROR);
                }
            } finally {
                Optional.ofNullable(certStream).ifPresent(inputStream -> {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAppID() {
        return appID;
    }

    @Override
    public String getMchID() {
        return partner;
    }

    @Override
    public String getKey() {
        return partnerkey;
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 10000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWechatPayDomain getWechatPayDomain() {
        return new WechatPayDomainSimpleImpl();
    }

    @Override
    public String toString() {
        return "WechatAppPayConfig{" +
                "certPath='" + certPath + '\'' +
                ", certData=" + Arrays.toString(certData) +
                ", appID='" + appID + '\'' +
                ", appsecret='" + appsecret + '\'' +
                ", partner='" + partner + '\'' +
                ", partnerkey='" + partnerkey + '\'' +
                ", properties=" + properties +
                '}';
    }

    public String getCertPath() {
        return certPath;
    }

    public byte[] getCertData() {
        return certData;
    }

    public void setCertData(byte[] certData) {
        this.certData = certData;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getPartnerkey() {
        return partnerkey;
    }

    public void setPartnerkey(String partnerkey) {
        this.partnerkey = partnerkey;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    /**
     * 是否自动上报。
     * 若要关闭自动上报，子类中实现该函数返回 false 即可。
     *
     * @return boolean
     */
    public boolean shouldAutoReport() {
        return true;
    }

    /**
     * 进行健康上报的线程的数量
     *
     * @return int
     */
    public int getReportWorkerNum() {
        return DEFAULT_REPORT_WORKER_NUM;
    }


    /**
     * 健康上报缓存消息的最大数量。会有线程去独立上报
     * 粗略计算：加入一条消息200B，10000消息占用空间 2000 KB，约为2MB，可以接受
     *
     * @return int
     */
    public int getReportQueueMaxSize() {
        return DEFAULT_REPORT_QUEUE_MAX_SIZE;
    }

    /**
     * 批量上报，一次最多上报多个数据
     *
     * @return int
     */
    public int getReportBatchSize() {
        return DEFAULT_REPORT_BATCH_SIZE;
    }
}
