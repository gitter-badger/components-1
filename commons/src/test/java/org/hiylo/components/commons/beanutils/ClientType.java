/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ClientType.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

public enum ClientType {
    TYPE0((byte) 0, "用户端文章分享"),
    TYPE1((byte) 1, "提现"),
    TYPE2((byte) 2, "用户邀请好友现金有奖"),
    TYPE3((byte) 3, "用户端快件分红"),
    TYPE4((byte) 4, "用户端退款"),
    TYPE5((byte) 5, "用户端商品支付"),
    TYPE6((byte) 6, "用户下单加价"),
    TYPE7((byte) 7, "用户端打赏快送员"),
    TYPE8((byte) 8, "用户端付款快件费用"),
    TYPE9((byte) 9, "用户端抢红包"),
    TYPE10((byte) 10, "动态加价"),
    TYPE11((byte) 11, "用户端打赏退款"),
    TYPE12((byte) 12, "12用户端加价退款");
    /**
     * 编号
     */
    private byte index;
    /**
     * 描述
     */
    private String description;

    ClientType(byte index, String description) {
        this.index = index;
        this.description = description;
    }

    public static ClientType getClientType(Byte index) {
        if (index < 0) {
            return null;
        }
        for (ClientType temp : ClientType.values()) {
            if (temp.getIndex() == index) {
                return temp;
            }
        }
        return null;
    }

    public static Map<Byte, String> getList() {
        Map<Byte, String> result = new HashMap<Byte, String>();
        for (AuditState temp : AuditState.values()) {
            result.put(temp.getIndex(), temp.getDescription());
        }
        return result;
    }

    public byte getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}
