/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : IdcardUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class IdcardUtilsTest {
    @Test
    public void isTrue() {
        log.debug(String.valueOf(IdcardUtils.isTrue("610524199111074886")));
        // 610103198809152039
    }
}