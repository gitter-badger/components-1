/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : OldLog.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.aliyun.log;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class OldLog implements Serializable {
    private static final long serialVersionUID = -4770111920613507854L;
    private Long timestamp;
    private String method;
    private String url;
    private String uri;
    private String module;
    private String controller;
    private String httpMethod;
    private String ip;
    private Map<String, String[]> args;
    private Map<String, String> headers;
    private String sn;
    private String token;
    private String deviceType;
    private Integer processStatus;
    private Long responseTime;
    private String body;

    public OldLog() {
    }

    public OldLog(Long timestamp, String method, String url, String uri, String module, String controller, String httpMethod, String ip, Map<String, String[]> args, Map<String, String> headers, String body, String sn, String token, String deviceType) {
        this.timestamp = timestamp;
        this.method = method;
        this.url = url;
        this.uri = uri;
        this.module = module;
        this.controller = controller;
        this.httpMethod = httpMethod;
        this.ip = ip;
        this.args = args;
        this.headers = headers;
        this.body = body;
        this.sn = sn;
        this.token = token;
        this.deviceType = deviceType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, String[]> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String[]> args) {
        this.args = args;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
