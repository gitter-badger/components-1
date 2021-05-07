/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ContentUtilsTest.java
 * Date : 2020/9/14 下午1:24
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentUtilsTest {

    @Test
    void riskyContentCheck() {
        new ContentUtils().riskyContentCheck("-----", "特3456书yuuo莞6543李zxcz蒜7782法fgnv级\n" +
                "完2347全dfji试3726测asad感3847知qwez到");
    }
}