/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ResponseHandle.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.pay;

import org.hiylo.components.wechat.config.WechatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 微信支付订单号工具类
 *
 * @author hiylo
 * @date 2018年4月3日 16:14:09
 */
public final class ResponseHandle {
    @Autowired
    private WechatConfig wechatConfig;
    private WechatPayRequest wechatPayRequest;
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private ResponseHandle() {

    }

    public ResponseHandle(WechatConfig wechatConfig) {
        wechatPayRequest = new WechatPayRequest(wechatConfig);
    }

    @PostConstruct
    public void init() {

    }

    /**
     * 不需要证书的请求
     *
     * @param urlSuffix        String
     * @param reqData          向wxpay post的请求数据
     * @param connectTimeoutMs 超时时间，单位是毫秒
     * @param readTimeoutMs    超时时间，单位是毫秒
     * @return API返回数据
     * @throws Exception
     */
    public String requestWithoutCert(String urlSuffix, Map<String, String> reqData,
                                     int connectTimeoutMs, int readTimeoutMs) throws Exception {
        String msgUUID = reqData.get("nonce_str");
        String reqBody = WechatPayUtil.mapToXml(reqData);

        String resp = this.wechatPayRequest.requestWithoutCert(urlSuffix, msgUUID, reqBody, connectTimeoutMs, readTimeoutMs, false);
        return resp;
    }


    /**
     * 需要证书的请求
     *
     * @param urlSuffix        String
     * @param reqData          向wxpay post的请求数据  Map
     * @param connectTimeoutMs 超时时间，单位是毫秒
     * @param readTimeoutMs    超时时间，单位是毫秒
     * @return API返回数据
     * @throws Exception
     */
    public String requestWithCert(String urlSuffix, Map<String, String> reqData,
                                  int connectTimeoutMs, int readTimeoutMs) {
        String msgUUID = reqData.get("nonce_str");
        String reqBody = null;
        try {
            reqBody = WechatPayUtil.mapToXml(reqData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String resp = this.wechatPayRequest.requestWithCert(urlSuffix, msgUUID, reqBody, connectTimeoutMs, readTimeoutMs, false);
        return resp;
    }
}
