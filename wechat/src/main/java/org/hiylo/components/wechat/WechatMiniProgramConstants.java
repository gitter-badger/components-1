/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatMiniProgramConstants.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat;

import org.hiylo.components.wechat.config.WechatConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class WechatMiniProgramConstants implements Serializable {
    private static final long serialVersionUID = -1;
    private WechatConfig wechatConfig;

    public class Request implements Serializable {
        private static final long serialVersionUID = -1;
        private static final String GRANT_USER_AUTHORIZATION_TOKEN = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
    }

    @Autowired
    public WechatMiniProgramConstants(WechatConfig wechatConfig) {
        this.wechatConfig = wechatConfig;
    }

    public String getUserAuthorizationTokenUrl(String code) {
        return Request.GRANT_USER_AUTHORIZATION_TOKEN.replace("JSCODE", code).replace("APPID", wechatConfig.getAppID()).replace("SECRET", wechatConfig.getAppsecret());
    }

    public WechatConfig getWechatConfig() {
        return wechatConfig;
    }

    public void setWechatConfig(WechatConfig wechatConfig) {
        this.wechatConfig = wechatConfig;
    }
}
