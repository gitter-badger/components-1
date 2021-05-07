/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : JsonTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
class JsonTest {

    @Test
    void toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("111", "222");
        log.debug(Json.toJson(map));
    }

    @Test
    void toJson() {
    }

    @Test
    void parse() {
    }
}