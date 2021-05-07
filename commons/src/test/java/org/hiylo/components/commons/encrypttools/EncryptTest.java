/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EncryptTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.encrypttools;

import org.junit.Test;

public class EncryptTest {
    @Test
    public void testSign() {
        long timestamp = System.currentTimeMillis();

        System.out.println(Encrypt.Md5.sign("", "Hx3r11WxDBjr3P6z4Jm3IQAKHAMv5xtI", "UTF-8"));
    }
}