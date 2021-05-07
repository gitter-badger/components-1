/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ContentUtils.java
 * Date : 2020/9/13 下午12:23
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.wechat.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hiylo
 */
@Slf4j
public class ContentUtils {
    private Gson gson = new Gson();

    /**
     * 敏感文字校验
     *
     * @param accessToken accessToken
     * @param content     验证内容
     * @return 是否通过验证
     */
    public boolean riskyContentCheck(String accessToken, String content) {
        String requestUrl = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        log.info("敏感信息验证 {}", requestUrl);
        Map<String, Object> json = new HashMap<>();
        json.put("content", content);
        log.info("验证内容 {}", json);
        JSONObject jsonObject = CommonUtils.httpsRequest(requestUrl, "POST", gson.toJson(json));
        log.info("验证结果{}", jsonObject);
        return jsonObject.getInt("errcode") == 0 || jsonObject.getInt("errcode") == 40001;
    }
}
