/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Order.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.wboll;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 2161772580362111560L;
    private String number;
    private String type;
    private String order_type;
    private String status;
    private String price;
    private String real_price;
    private String business_price;
    private String box_price;
    private String delivery_price;
    private String user_note;
    private String record_number;
    private String delivery_name;
    private String delivery_mobile;
    private String delivery_address;
    private String delivery_latitude;
    private String delivery_longitude;
    private String is_invoice;
    private String is_preordain;
    private String deliverTime;
    private String invoice_desc;
    private String tax_no;
    private String dm_name;
    private String dm_mobile;
    private String xklj_discount;
    private String food_discount;
    private String discount_price;
    private String coupon_price;
    private String less_price;
    private List<OrderDetail> detail;
}
