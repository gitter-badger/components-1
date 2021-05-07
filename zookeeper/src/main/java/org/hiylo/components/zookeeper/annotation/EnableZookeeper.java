/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EnableZookeeper.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.zookeeper.annotation;

import org.hiylo.components.zookeeper.I0ItecZooKeeperServiceProvider;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 在Spring上下文中使用此注解可以启用Zookeeper
 * 
 * @author Hsi Chu
 * @date 2021年5月6日 02:03:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(I0ItecZooKeeperServiceProvider.class)
public @interface EnableZookeeper {
}
