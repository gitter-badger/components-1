/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AssertTest.kt
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils

import org.junit.Test
import java.util.*

/**
 * @author hiylo
 * @date 2018年11月14日 11:37:02
 */
class AssertTest {

    @Test
    fun isNotEmpty() {
        val a = "a"
        val b = "b"
        Assert.isNotEmpty(a, b)
    }

    @Test
    fun isSizeGreaterThanZore() {
        val a = ArrayList<String>(3)
        a.add("a")
        a.add("b")
//        Assert.isSizeGreaterThanZore(a)
    }
}