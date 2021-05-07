/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ConditionType.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.enums;

/**
 * @author hiylo
 * @date 2018年11月14日 11:32:40
 */
public enum ConditionType {
    /**
     * 时间判断,什么时候开始
     */
    SINCE(1),
    /**
     * between
     */
    BETWEEN(2),
    /**
     * 等于
     */
    EQUALS(3),
    /**
     * 大于
     */
    GREATER(4),
    /**
     * 小于
     */
    LESS(5),
    /**
     * 不等于
     */
    UNEQUALS(6),
    ORDER(7),
    /**
     * 小于等于
     */
    LESSEQUES(8),
    /**
     * 大于等于
     */
    GREATEEQUES(9),
    /**
     * 是Null
     */
    IS_NULL(10),
    /**
     * 不是Null
     */
    IS_NOT_NULL(11);
    private Integer id;

    ConditionType(int id) {
        this.id = id;
    }

    public int value() {
        return this.id;
    }
}
