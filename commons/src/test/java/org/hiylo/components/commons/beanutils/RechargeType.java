/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : RechargeType.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

public enum RechargeType {
    APP((byte) 0, "APP"),
    WEBSITE((byte) 1, "官网"),
    WECHAT((byte) 2, "微信公众号");
    /**
     * 编号
     */
    private byte index;
    /**
     * 描述
     */
    private String description;

    RechargeType(byte index, String description) {
        this.index = index;
        this.description = description;
    }

    public static String getRechargeType(byte index) {
        if (index < 0) {
            return null;
        }
        for (RechargeType temp : RechargeType.values()) {
            if (temp.getIndex() == index) {
                return temp.getDescription();
            }
        }
        return null;
    }

    public static Map<Byte, String> getList() {
        Map<Byte, String> result = new HashMap<Byte, String>();
        for (RechargeType temp : RechargeType.values()) {
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
