/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Store.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.wboll;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Store implements Serializable {

    private static final long serialVersionUID = 7103629653270303716L;
    /**
     * id : 77898
     * name : 周黑鸭玄武湖店
     * address : 北京市西直门内大街
     * business_time : 1,2,3,4,5,6,7
     * all_day : 0
     * range_times : 00:00-01:00,11:00-23:59
     * longitude : 118.813328
     * latitude : 32.077855
     * phone_number : 025-80106640
     * is_open : 1
     * is_close : 1
     * public_notice : 新店开业
     * created_at : 2017-11-27 11:16:34
     * manager : zoeey
     * mobile : 18765889900
     * province : 江苏省
     * city : 南京市
     * district : 玄武区
     * hall_eat : 0
     * since : 0
     */

    private String id;
    private String name;
    private String address;
    private String business_time;
    private String all_day;
    private String range_times;
    private String longitude;
    private String latitude;
    private String phone_number;
    private String is_open;
    private String is_close;
    private String public_notice;
    private String created_at;
    private String manager;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String hall_eat;
    private String since;
}
