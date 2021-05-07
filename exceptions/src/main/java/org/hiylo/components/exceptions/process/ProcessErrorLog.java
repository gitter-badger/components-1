/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ProcessErrorLog.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions.process;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ProcessErrorLog {
    @Pointcut("execution(* org.slf4j.Logger.error(..))")
    public void executeController() {
        // skip
    }

    @Around("executeController()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("错误");
        return pjp.proceed();
    }
}
