/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : HttpClient.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * HTTP请求发送接口
 *
 * @author Johnny
 * @since 2016-12-02
 */
@Slf4j
public class HttpClient {
    public static final String CHARSET = "utf-8";
    private Gson gson = new Gson();

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url     提交的URL
     * @param jsonStr 提交字符串形式的Json
     * @return 提交响应
     */
    public static String post(String url, String jsonStr) {
        log.debug(jsonStr);
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (jsonStr != null && !"".equals(jsonStr)) {
                // 将JSON进行UTF-8编码,以便传输中文
//                String encoderJson = URLEncoder.encode(jsonStr, encoding);
                method.addHeader(HTTP.CONTENT_TYPE, "application/json");
                StringEntity strEntity = new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
                strEntity.setContentType("application/json");
                strEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                method.setEntity(strEntity);
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, CHARSET);
            }

        } catch (IOException e) {
            log.debug("请求出错", e);
        } finally {
            try {
                client.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.debug("请求出错", e);
            }
        }
        log.debug(responseText);
        return responseText;
    }

    /**
     * 基于HttpClient 4.3的通用get方法
     *
     * @param url      提交的URL
     * @param params   提交<参数，值>Map
     * @param encoding 编码格式
     * @return 提交响应
     */
    public static String get(String url, Map<String, String> params, String encoding) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            StringBuilder param = new StringBuilder("?");
            if (params != null) {
                for (Map.Entry<String, String> p : params.entrySet()) {
                    param.append(p.getKey()).append("=").append(p.getValue()).append("&");
                }
            }
            HttpGet method = new HttpGet(url + param);
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, encoding);
            }
        } catch (IOException e) {
            log.debug("请求出错", e);
        } finally {
            try {
                client.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.debug("请求出错", e);
            }
        }
        return responseText;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) throws UnsupportedEncodingException {
        return sendPost(url, param, null);
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, String contentType) throws UnsupportedEncodingException {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection urlConnection = realUrl.openConnection();
            HttpURLConnection conn = (HttpURLConnection) urlConnection;
            // 设置通用的请求属性
            Optional.ofNullable(contentType).ifPresent(s -> conn.setRequestProperty("Content-Type", s));
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            log.debug("请求出错", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                log.debug("请求出错", ex);
            }
        }
        return new String(result.toString().getBytes(), "UTF-8");
    }

    public static String get(String url, Map<String, Object> params, Map<String, Object> headers) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            String param = "?";
            if (params != null) {
                for (Map.Entry<String, Object> p : params.entrySet()) {
                    param += (p.getKey() + "=" + p.getValue() + "&");
                }
            }
            HttpGet method = new HttpGet(url + param);
            if (headers != null) {
                for (Map.Entry<String, Object> p : headers.entrySet()) {
                    method.setHeader(p.getKey(), String.valueOf(p.getValue()));
                }
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url      提交的URL
     * @param params   提交<参数，值>Map
     * @param encoding 编码格式
     * @return 提交响应
     */
    public String post(String url, Map<String, String> params, String encoding) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>(10);
                for (Map.Entry<String, String> param : params.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, encoding));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url      提交的URL
     * @param params   提交<参数，值>Map
     * @param encoding 编码格式
     * @return 提交响应
     */
    public String post(String url, Map<String, String> params, Map<String, String> headers, String encoding) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<>(params.size());
                for (Map.Entry<String, String> param : params.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, encoding));
            }
            if (headers != null) {
                for (Map.Entry<String, String> param : headers.entrySet()) {
                    method.addHeader(param.getKey(), param.getValue());
                }
            }
            response = client.execute(method);
            log.debug(new Gson().toJson(response.getAllHeaders()));
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url      提交的URL
     * @param params   提交<参数，值>Map
     * @param encoding 编码格式
     * @return 提交响应
     */
    public String postGetHeader(String url, Map<String, String> params, Map<String, String> headers, String encoding, String headerName) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseHeader = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<>(params.size());
                for (Map.Entry<String, String> param : params.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, encoding));
            }
            if (headers != null) {
                for (Map.Entry<String, String> param : headers.entrySet()) {
                    method.addHeader(param.getKey(), param.getValue());
                }
            }
            response = client.execute(method);
            System.out.println(new Gson().toJson(response.getAllHeaders()));
            for (Header header : response.getAllHeaders()) {
                if (header.getName().equals(headerName)) {
                    responseHeader = header.getValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseHeader;
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url    提交的URL
     * @param params 提交<参数，值>Map
     * @return 提交响应
     */
    public String postJson(String url, Map<String, Object> params, Map<String, String> headers) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (params != null) {
                BasicHttpEntity entity = new BasicHttpEntity();
                entity.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                entity.setContent(new ByteArrayInputStream(gson.toJson(params).getBytes("UTF-8")));
                method.setEntity(entity);
            }
            if (headers != null) {
                for (Map.Entry<String, String> param : headers.entrySet()) {
                    method.addHeader(param.getKey(), param.getValue());
                }
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url      提交的URL
     * @param encoding 编码格式
     * @return 提交响应
     */
    public String postHttpsWithPkcs(String url, String method, String outputStr, InputStream pkcs, String password,
                                    String encoding) {
        // KeyStore trustStore =
        // KeyStore.getInstance(KeyStore.getDefaultType());
        //
        // SSLContext sslcontext = null;
        // CloseableHttpClient client = null;
        // try {
        // sslcontext =
        // SSLContexts.custom().loadTrustMaterial(trustStore).build();
        // SSLConnectionSocketFactory sslsf = new
        // SSLConnectionSocketFactory(sslcontext,
        // SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        // client = HttpClients.custom()
        // .setSSLSocketFactory(sslsf)
        // .build();
        // } catch (NoSuchAlgorithmException e) {
        // e.printStackTrace();
        // } catch (KeyManagementException e) {
        // e.printStackTrace();
        // }


        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost post = new HttpPost(url);
            StringEntity strEntity = new StringEntity(outputStr);
            post.setEntity(strEntity);
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    public String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        String result = null;
        try {
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());

            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setRequestMethod(requestMethod);

            if (outputStr != null) {
                OutputStream outputStream = conn.getOutputStream();

                outputStream.write(outputStr.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }

            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * http get , 执行失败返回null
     *
     * @param url
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public final String get(String url) throws ParseException, IOException {
        // 这里发送get请求
        HttpGet request = new HttpGet(url);
        // 获取当前客户端对象
        org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
        // 通过请求对象获取响应对象
        org.apache.http.HttpResponse response = httpClient.execute(request);

        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toString(response.getEntity(), "utf-8");
        }
        return null;
    }

    /**
     * http get , 执行失败返回null
     *
     * @param url
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public String get(String url, Map<String, String> params, Map<String, String> headers, String charset) throws ParseException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            StringBuilder param = new StringBuilder("?");
            if (params != null) {
                for (Map.Entry<String, String> p : params.entrySet()) {
                    param.append(p.getKey()).append("=").append(p.getValue()).append("&");
                }
            }
            HttpGet method = new HttpGet(url + param);

            if (headers != null) {
                for (Map.Entry<String, String> p : headers.entrySet()) {
                    method.addHeader(p.getKey(), p.getValue());
                }
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }


    public String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getFileExt(String contentType) {
        String fileExt = "";
        if (CommonUtils.getFileTypeMap().get("image/jpeg") != null
                && CommonUtils.getFileTypeMap().get("image/jpeg").equals(contentType)) {
            fileExt = ".jpg";
        } else if (CommonUtils.getFileTypeMap().get("audio/mpeg") != null
                && CommonUtils.getFileTypeMap().get("audio/mpeg").equals(contentType)) {
            fileExt = ".mp3";
        } else if (CommonUtils.getFileTypeMap().get("audio/amr") != null
                && CommonUtils.getFileTypeMap().get("audio/amr").equals(contentType)) {
            fileExt = ".amr";
        } else if (CommonUtils.getFileTypeMap().get("video/mp4") != null
                && CommonUtils.getFileTypeMap().get("video/mp4").equals(contentType)) {
            fileExt = ".mp4";
        } else if (CommonUtils.getFileTypeMap().get("video/mpeg4") != null
                && CommonUtils.getFileTypeMap().get("video/mpeg4").equals(contentType)) {
            fileExt = ".mp4";
        }
        return fileExt;
    }
}
