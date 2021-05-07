/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EnableWechat.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.annotation;

import org.hiylo.components.wechat.config.WechatConfig;
import org.hiylo.components.wechat.pay.ResponseHandle;
import org.hiylo.components.wechat.pay.Topay;
import org.hiylo.components.wechat.pay.Transfers;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 单微信支付使用此注解
 *
 * @author hiylo
 * @date 2021年5月7日 18:42:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({Topay.class, ResponseHandle.class, Transfers.class})
@EnableConfigurationProperties(WechatConfig.class)
public @interface EnableWechat {
}
