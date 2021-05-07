/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EnableWechatPublicAccount.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.annotation;

import org.hiylo.components.wechat.WechatPublicAccountConstants;
import org.hiylo.components.wechat.config.WechatConfig;
import org.hiylo.components.wechat.user.WechatUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 微信公众号使用此注解
 *
 * @author hiylo
 * @date 2021年5月7日 18:42:55
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableConfigurationProperties(WechatConfig.class)
@Import({WechatPublicAccountConstants.class, WechatUtils.class})
public @interface EnableWechatPublicAccount {
}
