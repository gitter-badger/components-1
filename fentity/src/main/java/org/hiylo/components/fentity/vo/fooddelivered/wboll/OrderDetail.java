/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : OrderDetail.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.wboll;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1122215479300064376L;
    private String food_id;
    private String name;
    private String img;
    private String specification;
    private String attribute;
    private String price;
    private String count;
    private String category_id;
    private String group_name;
    private String category_name;
}
