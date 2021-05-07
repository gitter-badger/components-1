/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EnableMultiWechat.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.annotation;

import java.lang.annotation.*;

/**
 * 多微信环境使用此注解
 *
 * @author hiylo
 * @date 2021年5月7日 18:41:46
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableMultiWechat {
}
