/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Base64Test.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.encrypttools;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Test {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Test
    public void encode() {
        String text = "nihao";
        String result = Base64.encode(text.getBytes());
        log.debug(result);
    }

    @Test
    public void decode() {
        String result = "bmloYW8=";
        String test = new String(Base64.decode(result));
        log.debug(test);
    }
}