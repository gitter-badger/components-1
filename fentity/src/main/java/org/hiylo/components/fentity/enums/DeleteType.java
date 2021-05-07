/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : DeleteType.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.enums;

/**
 * 删除方式
 *
 * @author hiylo
 * @date 2019年2月18日 09:55:21
 */
public enum DeleteType {
    /**
     * 物理方式
     */
    PHYSICAL(0),
    /**
     * 逻辑删除
     */
    LOGICAL(1);

    private Integer type;

    DeleteType(int type) {
        this.type = type;
    }

    public int value() {
        return this.type;
    }
}
