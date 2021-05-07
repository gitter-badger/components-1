/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatApplicationTester.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat;

import org.hiylo.components.wechat.annotation.EnableWechat;
import org.hiylo.components.wechat.annotation.EnableWechatPublicAccount;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hiylo on 2/13/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.hiylo")
@EnableWechat
//@EnableMultiWechat
@EnableWechatPublicAccount
public class WechatApplicationTester {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WechatApplicationTester.class).run(args);
    }

//    @Bean(name = "wechatWxConfig")
//    @ConfigurationProperties(prefix = "sender.wechat", ignoreInvalidFields = true)
//    public WechatAppPayConfig wechatWxConfig(ConfigurableApplicationContext context) {
//        WechatAppPayConfig wechatAppPayConfig = new WechatAppPayConfig();
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        beanFactory.registerSingleton("wechatTopay", new Topay(wechatAppPayConfig));
//        beanFactory.registerSingleton("wechatTransfers", new Transfers(wechatAppPayConfig));
//        return wechatAppPayConfig;
//    }

}
