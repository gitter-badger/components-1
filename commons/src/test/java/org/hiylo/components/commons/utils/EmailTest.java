/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EmailTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.junit.Test;

public class EmailTest {

    @Test
    public void sendEmail() {
    }

    @Test
    public void sentSystemNotice() {
        new Email().sentSystemNotice("系统错误");
    }
}