/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : SentryConfiguration.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions.config;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.PostConstruct;

/**
 * sentry配置类
 * 
 * @author hiylo
 * @date 2020年1月21日 14:15:36
 */
@Slf4j
@Configuration
@ConditionalOnProperty(name = "sentry.enable", havingValue = "true")
public class SentryConfiguration {
    /**
     * 环境
     */
    @Value("${spring.profiles.active}")
    private String profile;
    /**
     * 版本号
     */
    @Value("${eureka.instance.metadataMap.version:1.0.0}")
    private String version;
    /**
     * 应用名称
     */
    @Value("${spring.application.name:hiylo}")
    private String applicationName;
    /**
     * 服务地址
     */
    @Value("${sentry.dsn}")
    private String sentryDsn;
    /**
     * 上报样本比例
     */
    @Value("${sentry.sample.rate:0.75}")
    private String sampleRate;
    /**
     * 需要上报的包名
     */
    @Value("${sentry.stacktrace.app.packages:org.hiylo,org.springframework,org.hibernate}")
    private String packages;

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        System.setProperty("SENTRY_STACKTRACE_APP_PACKAGES", packages);
        System.setProperty("stacktrace.app.packages", packages);
        System.setProperty("SENTRY_SAMPLE_RATE", sampleRate);
        SentryClient sentryClient = Sentry.init(sentryDsn);
        sentryClient.setEnvironment(profile);
        sentryClient.setRelease(version);
        sentryClient.setServerName(applicationName);
        log.debug("sentry started!");
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new io.sentry.spring.SentryServletContextInitializer();
    }

    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new io.sentry.spring.SentryExceptionResolver();
    }

}
