/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AuditState.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

public enum AuditState {
    APPLY((byte) 0, "待审核"),
    FIRST_PASS((byte) 1, "初审通过"),
    FIRST_NOT_PASS((byte) 2, "初审不通过"),
    SENCOND_PASS((byte) 3, "复审通过"),
    SENCOND_NOT_PASS((byte) 4, "复审不通过");
    /**
     * 编号
     */
    private byte index;
    /**
     * 描述
     */
    private String description;

    AuditState(byte index, String description) {
        this.index = index;
        this.description = description;
    }

    public static String getAuditState(byte index) {
        if (index < 0) {
            return null;
        }
        for (AuditState temp : AuditState.values()) {
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
