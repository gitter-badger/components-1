/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CourierType.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

public enum CourierType {
    TYPE0((byte) 0, "快送员快件收益"),
    TYPE1((byte) 1, "提现"),
    TYPE2((byte) 2, "快送员订单完成打赏"),
    TYPE3((byte) 3, "用户端给快送员的加价"),
    TYPE4((byte) 4, "快送员端壹商城商家分润"),
    TYPE5((byte) 5, "快送员端保险费"),
    TYPE6((byte) 6, "快送员推荐奖励"),
    TYPE7((byte) 7, "快送员首单接单完成奖励"),
    TYPE8((byte) 8, "快送员首月接单完成奖励"),
    TYPE9((byte) 9, "快送员接单完成奖励"),
    TYPE10((byte) 10, "快送员充值押金");
    /**
     * 编号
     */
    private byte index;
    /**
     * 描述
     */
    private String description;

    CourierType(byte index, String description) {
        this.index = index;
        this.description = description;
    }

    public static String getCourierType(byte index) {
        if (index < 0) {
            return null;
        }
        for (CourierType temp : CourierType.values()) {
            if (temp.getIndex() == index) {
                return temp.getDescription();
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
