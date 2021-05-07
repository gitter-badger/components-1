/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatPublicAccountConstants.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat;

import org.hiylo.components.wechat.config.WechatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WechatPublicAccountConstants implements Serializable {
    private static final long serialVersionUID = -1;
    private WechatConfig wechatConfig;

    @Autowired
    public WechatPublicAccountConstants(WechatConfig wechatConfig) {
        this.wechatConfig = wechatConfig;
    }

    public class RequestMessageType implements Serializable {
        private static final long serialVersionUID = -1;
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_TEXT = "text";
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_IMAGE = "image";
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_VOICE = "voice";
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_VIDEO = "video";
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_LOCATION = "location";
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_LINK = "link";
        public static final String WEIXIN_REQUEST_MESSAGE_TYPE_EVENT = "event";
        public static final String WEIXIN_EVENT_TYPE_SUBSCRIBE = "subscribe";
        public static final String WEIXIN_EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
        public static final String WEIXIN_EVENT_TYPE_SCAN = "SCAN";
        public static final String WEIXIN_EVENT_TYPE_LOCATION = "LOCATION";
        public static final String WEIXIN_EVENT_TYPE_CLICK = "CLICK";
        public static final String WEIXIN_RESPONSE_MESSAGE_TYPE_TEXT = "text";
        public static final String WEIXIN_RESPONSE_MESSAGE_TYPE_IMAGE = "image";
        public static final String WEIXIN_RESPONSE_MESSAGE_TYPE_VOICE = "voice";
        public static final String WEIXIN_RESPONSE_MESSAGE_TYPE_VIDEO = "video";
        public static final String WEIXIN_RESPONSE_MESSAGE_TYPE_MUSIC = "music";
        public static final String WEIXIN_RESPONSE_MESSAGE_TYPE_NEWS = "news";
    }

    public class Request implements Serializable {
        private static final long serialVersionUID = -1;
        private static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        private static final String GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
        private static final String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        private static final String GRANT_CLIENT_CREDENTIAL_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APP_ID&secret=SECRET";
        private static final String GRANT_USER_AUTHORIZATION_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APP_ID&secret=SECRET&code=CODE&grant_type=authorization_code";
        private static final String GET_USER_AUTHORIZATION = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APP_ID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        private static final String GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        private static final String GET_JSAPI_TOKEN = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    }

    public String getUserAuthorizationUrl(String url) {
        ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = attributes.getRequest();
        try {
            return Request.GET_USER_AUTHORIZATION.replace("REDIRECT_URI",
                    URLEncoder.encode(url, "UTF-8")).
                    replace("APP_ID", wechatConfig.getAppID());
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public String getJsTicketUrl(String accessToken) {
        return Request.GET_JSAPI_TOKEN.replace("ACCESS_TOKEN", accessToken);
    }

    public String getUserAuthorizationTokenUrl(String code) {
        return Request.GRANT_USER_AUTHORIZATION_TOKEN.replace("CODE", code).replace("APP_ID", wechatConfig.getAppID()).replace("SECRET", wechatConfig.getAppsecret());
    }

    public String getGrantClientCredentialTokenUrl() {
        return Request.GRANT_CLIENT_CREDENTIAL_TOKEN.replace("APP_ID", wechatConfig.getAppID()).replace("SECRET", wechatConfig.getAppsecret());
    }

    public String getUserInfoUrl(String accessToken, String openId) {
        return Request.GET_USER_INFO.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
    }

    public String getMenu(String accessToken) {
        return Request.GET_MENU.replace("ACCESS_TOKEN", accessToken);
    }

    public String deleteMenu(String accessToken) {
        return Request.DELETE_MENU.replace("ACCESS_TOKEN", accessToken);
    }

    public String createMenu(String accessToken) {
        return Request.CREATE_MENU.replace("ACCESS_TOKEN", accessToken);
    }

    public WechatConfig getWechatConfig() {
        return wechatConfig;
    }
}
