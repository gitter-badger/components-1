/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommonsApplicationTester.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hiylo
 * @date 2/20/2018 1:24 1:33 AM
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.hiylo")
public class CommonsApplicationTester {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CommonsApplicationTester.class).run(args);
    }
}
