/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PushMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.hiylo.components.commons.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 * @author hiylo
 * @date 2020年9月11日 21:17:29
 */
@Slf4j
@Component
public class PushMessage extends StringUtils {
    private Gson gson = new Gson();

    /**
     * 发送微信公众号消息
     *
     * @param openId      openId
     * @param templateId  模版编号
     * @param map         模版内容信息
     * @param accessToken 服务端访问密钥
     * @param url         点击之后跳转的页面, 可为空, 为空则不支持跳转
     */
    public void pushMessage(String openId, String templateId, Map<String, String> map, String accessToken, String url) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> json = new HashMap<>();
        json.put("touser", openId);
        json.put("template_id", templateId);
        Optional.ofNullable(url).ifPresent(s -> json.put("url", s));
        Map<String, Object> values = new HashMap<>();
        for (String key : map.keySet()) {
            String value = map.get(key);
            Map<String, String> temp = new HashMap<>();
            temp.put("color", "#173177");
            temp.put("value", value);
            values.put(key, temp);
        }
        json.put("data", values);
        JSONObject jsonObject = CommonUtils.httpsRequest(requestUrl, "POST", gson.toJson(json));
        log.debug("微信推送消息 {}", jsonObject);
    }

    /**
     * 微信小程序订阅消息
     *
     * @param openId      openId
     * @param templateId  模版编号
     * @param map         模版内容信息
     * @param accessToken 服务端访问密钥
     */
    public void sendSubscribeMessage(String openId, String templateId, Map<String, String> map, String accessToken) {
        this.sendSubscribeMessage(openId, templateId, map, accessToken, null, null);
    }

    /**
     * 微信小程序订阅消息
     *
     * @param openId      openId
     * @param templateId  模版编号
     * @param map         模版内容信息
     * @param accessToken 服务端访问密钥
     * @param url         要打开的页面
     */
    public void sendSubscribeMessage(String openId, String templateId, Map<String, String> map, String accessToken, String url) {
        this.sendSubscribeMessage(openId, templateId, map, accessToken, url, null);
    }

    /**
     * 微信小程序订阅消息
     *
     * @param openId      openId
     * @param templateId  模版编号
     * @param map         模版内容信息
     * @param accessToken 服务端访问密钥
     * @param url         要打开的页面
     * @param state       要打开的小程序的状态 {@link MiniProgramState}
     */
    public void sendSubscribeMessage(String openId, String templateId, Map<String, String> map, String accessToken, String url, String state) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> json = new HashMap<>();
        json.put("touser", openId);
        json.put("template_id", templateId);
        Optional.ofNullable(url).ifPresent(s -> json.put("page", s));
        Optional.ofNullable(state).ifPresent(s -> json.put("miniprogram_state", s));
        json.put("lang", "zh_CN");
        JSONObject jsonObject = new JSONObject();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            JSONObject tempJsonObject = new JSONObject();
            tempJsonObject.put("value", map.get(key));
            jsonObject.put(key, tempJsonObject);
        }
        json.put("data", jsonObject);
        jsonObject = CommonUtils.httpsRequest(requestUrl, "POST", gson.toJson(json));
        log.debug("微信推送消息 {}", jsonObject);
    }

    public void sendUniformMessage(String wechatAppId, String miniProgramAppId, String openId, String miniProgramTemplateId,
                                   String miniProgramFormId, String wechatTemplateId, Map<String, String> map,
                                   String accessToken, String url, String emphasisKeyword) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> json = new HashMap<>();
        json.put("touser", openId);
        Optional.ofNullable(miniProgramTemplateId).ifPresent(s ->
                json.put("weapp_template_msg", buildWeappMessage(s, miniProgramFormId, url, map, emphasisKeyword)));
        json.put("mp_template_msg", buildWechatMessage(wechatAppId, wechatTemplateId, url, map, miniProgramAppId));
    }

    private JSONObject buildWechatMessage(String wechatAppId, String wechatTemplateId, String url, Map<String, String> map, String miniProgramAppId) {
        JSONObject json = new JSONObject();
        json.put("appid", wechatAppId);
        json.put("template_id", wechatTemplateId);
        json.put("page", url);
//        json.put("form_id", formId);
//        json.put("emphasis_keyword", emphasisKeyword);
        JSONObject jsonObject = new JSONObject();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            JSONObject tempJsonObject = new JSONObject();
            tempJsonObject.put("value", map.get(key));
            jsonObject.put(key, tempJsonObject);
        }
        json.put("data", jsonObject);
        return json;
    }

    private JSONObject buildWeappMessage(String templateId, String formId, String url, Map<String, String> map, String emphasisKeyword) {
        JSONObject json = new JSONObject();
        json.put("template_id", templateId);
        json.put("page", url);
        json.put("form_id", formId);
        json.put("emphasis_keyword", emphasisKeyword);
        JSONObject jsonObject = new JSONObject();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            JSONObject tempJsonObject = new JSONObject();
            tempJsonObject.put("value", map.get(key));
            jsonObject.put(key, tempJsonObject);
        }
        json.put("data", jsonObject);
        return json;
    }

    public enum MiniProgramState {
        /**
         * 开发板
         */
        DEVELOPER("developer"),
        /**
         * 体验版
         */
        TRIAL("trial"),
        /**
         * 正式版本
         */
        FORMAL("formal");

        private String state;

        MiniProgramState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}
