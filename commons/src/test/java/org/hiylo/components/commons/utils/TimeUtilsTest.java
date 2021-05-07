/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TimeUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

@Slf4j
public class TimeUtilsTest {
    private TimeUtils timeUtils = new TimeUtils();

    @Test
    public void parseSecond() {
//       log.debug(timeUtils.parseSecond(60 * 60 * 24 * 365 * 2 + 60 * 60 * 24 * 30 * 5 + 60 * 60 * 24 + 60 * 60 * 20 + 60 * 24 + 1));
        System.out.println(UUID.randomUUID().toString());
    }
}