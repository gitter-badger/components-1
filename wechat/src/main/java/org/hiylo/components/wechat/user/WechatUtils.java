/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.user;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.commons.utils.HttpClient;
import org.hiylo.components.fentity.vo.WechatServiceToken;
import org.hiylo.components.fentity.vo.WechatUserInfo;
import org.hiylo.components.fentity.vo.WechatUserOpenIdInfo;
import org.hiylo.components.fentity.vo.WechatUserToken;
import org.hiylo.components.wechat.WechatPublicAccountConstants;
import org.hiylo.components.wechat.pay.WechatPayConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 微信用户相关工具类
 *
 * @author hiylo
 * @date 2018年4月3日 16:15:48
 */
@Slf4j
public class WechatUtils {
    private HttpClient httpClient = new HttpClient();
    private Gson gson = new Gson();
    private WechatPublicAccountConstants wechatPublicAccountConstants;

    @Autowired
    public WechatUtils(WechatPublicAccountConstants wechatPublicAccountConstants) {
        this.wechatPublicAccountConstants = wechatPublicAccountConstants;
    }

    /**
     * 使用微信code获取用户token
     *
     * @param code 从微信端获取到的code
     * @return 用户的访问token信息
     */
    public WechatUserToken getUserToken(String code) {
        try {
            String result = httpClient
                    .get(wechatPublicAccountConstants.getUserAuthorizationTokenUrl(code));
            log.info(result);
            return gson.fromJson(result, TypeToken.get(WechatUserToken.class).getType());
        } catch (IOException | JsonSyntaxException e) {
            log.error("getUserToken", e);
        }
        return null;
    }

    /**
     * 获取服务端Token, 用来操作比如微信菜单
     *
     * @return 微信服务端token信息
     */
    public WechatServiceToken getServiceToken() {
        try {
            log.info("getServiceToken {}", wechatPublicAccountConstants.getGrantClientCredentialTokenUrl());
            String result = httpClient.get(wechatPublicAccountConstants.getGrantClientCredentialTokenUrl());
            log.info("getServiceToken {}", result);
            return gson.fromJson(result, TypeToken.get(WechatServiceToken.class).getType());
        } catch (IOException | JsonSyntaxException e) {
            log.error("getServiceToken", e);
        }
        return null;
    }

    /**
     * 获取微信jsToken信息, 用来前端获取微信授权
     *
     * @param accessToken 微信服务端访问token
     * @return 微信jsToken信息
     */
    public WechatServiceToken getJsTicket(String accessToken) {
        try {
            String result = httpClient.get(wechatPublicAccountConstants.getJsTicketUrl(accessToken));
            return gson.fromJson(result, TypeToken.get(WechatServiceToken.class).getType());
        } catch (IOException | JsonSyntaxException e) {
            log.error("getJsTicket", e);
        }
        return null;
    }
    /**
     * 使用微信code获取用户openId等信息
     *
     * @param code 从微信端获取到的code
     * @return 用户openId等信息
     */
    public WechatUserOpenIdInfo getOpenId(String code) {
        String result = httpClient.httpsRequest(
                wechatPublicAccountConstants.getUserAuthorizationTokenUrl(code), "GET", null);
        log.info(result);
        if (Objects.nonNull(result)) {
            return gson.fromJson(result, WechatUserOpenIdInfo.class);
        }
        return null;
    }

    /**
     * 获取微信用户信息
     * @param accessToken 用户token
     * @param openId 用户openId
     * @return
     */
    public WechatUserInfo getUserInfo(String accessToken, String openId) {
        String result = httpClient.httpsRequest(wechatPublicAccountConstants.getUserInfoUrl(accessToken, openId), "GET", null);
        if (Objects.nonNull(result)) {
            return gson.fromJson(result, TypeToken.get(WechatUserInfo.class).getType());
        }
        return null;
    }
}
