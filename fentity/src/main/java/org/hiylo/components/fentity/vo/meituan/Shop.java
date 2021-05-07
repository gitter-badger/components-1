/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Shop.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.meituan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hiylo
 * @date 2019年5月6日 19:43:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    /**
     * 商户名
     */
    private String name;
    /**
     * 商铺名
     */
    private String shop_name;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 编号
     */
    private String merchant_unique;
    /**
     * 编号
     */
    private String shop_unique;
    /**
     * 美团用户名
     */
    private String meituanUsername;
    /**
     * 美团密码
     */
    private String meituanPassword;
}
