/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatAppPrepayVO.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.pay;

/**
 * 微信支付prepay值对象
 *
 * @author hiylo
 * @date 2018年4月3日 16:15:12
 */
public class WechatAppPrepayVO {
    private String appid;
    private String partnerid;
    private String prepayid;
    private String noncestr;
    private String sign;
    private String packages;
    private long timestamp;

    public WechatAppPrepayVO() {
    }

    public WechatAppPrepayVO(String appid, String partnerid, String prepayid, String noncestr, String sign, String packages,
                             long timestamp) {
        this.appid = appid;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.noncestr = noncestr;
        this.sign = sign;
        this.packages = packages;
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WechatAppPrepayVO{" + "appid='" + appid + '\'' + ", partnerid='" + partnerid + '\'' + ", prepayid='"
                + prepayid + '\'' + ", noncestr='" + noncestr + '\'' + ", sign='" + sign + '\'' + ", packages='"
                + packages + '\'' + ", timestamp=" + timestamp + '}';
    }
}
