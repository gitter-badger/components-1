/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Order.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered;

import lombok.Data;

/**
 * @author hiylo
 * @date 2019年5月6日 18:37:44
 */
@Data
public class Order {
    /**
     * 订单备注
     */
    private String remark;
    /**
     * 当日流水号
     */
    private String day_seq;
    /**
     * 预约送达时间
     */
    private String delivery_time;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 收货地纬度
     */
    private String latitude;
    /**
     * 收货地经度
     */
    private String longitude;
    private double shopLatitude;
    private double shopLongitude;
    /**
     * 发货地址
     */
    private String poi_address;
    /**
     * 发货店铺名
     */
    private String poi_name;
    /**
     * 发货店铺电话
     */
    private String poi_phone;
    /**
     * 收货人地址
     */
    private String recipient_address;
    /**
     * 收货人名称
     */
    private String recipient_name;
    /**
     * 收货人电话
     */
    private String recipient_phone;
    /**
     * 订单状态
     * 1-用户已提交订单；
     * 2-可推送到App方平台也可推送到商家；
     * 4-商家已确认；6-已配送；
     * 8-已完成；9-已取消
     */
    private String status;
    /**
     * 下单时间
     */
    private String create_time;
    /**
     * 订单原价
     */
    private String original_price;
    /**
     * 订单支付金额
     */
    private String total;
    /**
     * 数据ID 用于查询订单详情，
     * 如获取菜品信息
     */
    private String data_id;
    /**
     * mt店铺ID
     */
    private String mt_shop_id;
    /**
     * 是否是该用户在该店首单
     */
    private String is_poi_first_order;
    /**
     * 该用户是否收藏店铺
     */
    private String is_favorites;
    private String merchantId;
    private String elemeShopId;
    private int orderType;
    private Long timestamp;
    private int day_sn;
}
