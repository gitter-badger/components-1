/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Message.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.wboll;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 2209660164549021822L;
    private String shop_id;
    private String message;
    /**
     * 新订单	1
     * 堂食新订单	2
     * 堂食加菜	3
     * 外卖订单取消	5
     * 堂食订单取消	7
     * 已接单	24
     * 订单完成	4
     * 堂食退菜	6
     * 订单部分退款	16
     * 订单配送中	25
     * 订单配送完成	26
     * 配送异常	27
     * 直接买单	29
     * 待自提	30
     */
    private String type;
    private String sign;
}
