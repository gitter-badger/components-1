/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : HtmlGeneratorTest.kt
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils

import org.junit.Test

class HtmlGeneratorTest {

    @Test
    fun wapGenerator() {
        print(HtmlGenerator().wapGenerator("<div></div>"))
    }
}