/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatNotifyVO.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.pay;

public class WechatNotifyVO {
    private long paymentTime;
    private String outTradeNumber;
    private String orderNo;
    private double totalFee;
    private String attach;

    public long getPaymentTime() {
        return paymentTime;
    }

    public WechatNotifyVO setPaymentTime(long paymentTime) {
        this.paymentTime = paymentTime;
        return this;
    }

    public String getOutTradeNumber() {
        return outTradeNumber;
    }

    public WechatNotifyVO setOutTradeNumber(String outTradeNumber) {
        this.outTradeNumber = outTradeNumber;
        return this;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public WechatNotifyVO setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public WechatNotifyVO setTotalFee(double totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WechatNotifyVO setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    @Override
    public String toString() {
        return "WechatNotifyVO{" +
                "paymentTime=" + paymentTime +
                ", outTradeNumber='" + outTradeNumber + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", totalFee=" + totalFee +
                ", attach='" + attach + '\'' +
                '}';
    }
}
