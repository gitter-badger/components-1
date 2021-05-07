/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatMiniProgramUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.miniprogram.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.commons.utils.HttpClient;
import org.hiylo.components.fentity.vo.WechatMiniProgramToken;
import org.hiylo.components.wechat.WechatMiniProgramConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 微信小程序工具类
 *
 * @author hiylo
 * @date 2021年5月7日 18:37:41
 */
@Slf4j
public class WechatMiniProgramUtils {
    private HttpClient httpClient = new HttpClient();
    private Gson gson = new Gson();
    private WechatMiniProgramConstants wechatMiniProgramConstants;

    @Autowired
    public WechatMiniProgramUtils(WechatMiniProgramConstants wechatMiniProgramConstants) {
        this.wechatMiniProgramConstants = wechatMiniProgramConstants;
    }

    /**
     * 通过用户端获取到的code获取用户openId等信息
     *
     * @param code 用户端获取到的code
     * @return 用户openId等信息
     */
    public WechatMiniProgramToken getUserToken(String code) {
        try {
            String result = httpClient
                    .get(wechatMiniProgramConstants.getUserAuthorizationTokenUrl(code));
            log.info(result);
            return gson.fromJson(result, TypeToken.get(WechatMiniProgramToken.class).getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
