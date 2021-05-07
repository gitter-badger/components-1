/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : FormalDelete.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

public enum FormalDelete {
    NOT_DELETE((byte) 0, "未删除"),
    STOP_ORDER((byte) 1, "暂停接单"),
    DELETE((byte) 2, "删除"),
    REMOVE((byte) 3, "彻底删除");
    /**
     * 编号
     */
    private byte index;
    /**
     * 描述
     */
    private String description;

    FormalDelete(byte index, String description) {
        this.index = index;
        this.description = description;
    }

    public static String getFormalDelete(byte index) {
        if (index < 0) {
            return null;
        }
        for (FormalDelete temp : FormalDelete.values()) {
            if (temp.getIndex() == index) {
                return temp.getDescription();
            }
        }
        return null;
    }

    public static Map<Byte, String> getList() {
        Map<Byte, String> result = new HashMap<Byte, String>();
        for (FormalDelete temp : FormalDelete.values()) {
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
