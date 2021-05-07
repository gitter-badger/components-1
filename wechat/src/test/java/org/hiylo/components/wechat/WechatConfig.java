/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatConfig.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat;

import org.springframework.context.annotation.Configuration;

/**
 * 这里配置的两种方式都可以使用
 */
@Configuration
public class WechatConfig {
//    @Bean(name = "userWxConfig")
//    @ConfigurationProperties(prefix = "user.wechat", ignoreInvalidFields = true)
//    public WechatAppPayConfig userWxConfig() {
//        return new WechatAppPayConfig();
//    }
//
//    @Bean(name = "sendWxConfig")
//    @ConfigurationProperties(prefix = "sender.wechat", ignoreInvalidFields = true)
//    public WechatAppPayConfig sendWxConfig() {
//        return new WechatAppPayConfig();
//    }
//
//
//    @Bean(name = "userTopay")
//    public Topay userTopay(WechatAppPayConfig userWxConfig) {
//        return new Topay(userWxConfig);
//    }
//
//    @Bean(name = "sendTopay")
//    public Topay senderTopay(WechatAppPayConfig sendWxConfig) {
//        return new Topay(sendWxConfig);
//    }
//
//    @Bean(name = "userTransfers")
//    public Transfers userTransfers(WechatAppPayConfig sendWxConfig) {
//        return new Transfers(sendWxConfig);
//    }
//
//    @Bean(name = "senderTransfers")
//    public Transfers senderTransfers(WechatAppPayConfig sendWxConfig) {
//        return new Transfers(sendWxConfig);
//    }

//    @Bean(name = "userWxConfig")
//    @ConfigurationProperties(prefix = "user.wechat", ignoreInvalidFields = true)
//    public WechatAppPayConfig userWxConfig(ConfigurableApplicationContext context) {
//        WechatAppPayConfig wechatAppPayConfig = new WechatAppPayConfig();
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        beanFactory.registerSingleton("userTopay", new Topay(wechatAppPayConfig));
//        beanFactory.registerSingleton("userTransfers", new Transfers(wechatAppPayConfig));
//        return wechatAppPayConfig;
//    }
//
//    @Bean(name = "sendWxConfig")
//    @ConfigurationProperties(prefix = "sender.wechat", ignoreInvalidFields = true)
//    public WechatAppPayConfig sendWxConfig(ConfigurableApplicationContext context) {
//        WechatAppPayConfig wechatAppPayConfig = new WechatAppPayConfig();
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        beanFactory.registerSingleton("sendTopay", new Topay(wechatAppPayConfig));
//        beanFactory.registerSingleton("senderTransfers", new Transfers(wechatAppPayConfig));
//        return wechatAppPayConfig;
//    }
//

}
