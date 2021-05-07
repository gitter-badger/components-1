/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : GenerateUtilsTest.java
 * Date : 2021/2/2 下午3:45
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.commons.utils

import lombok.extern.slf4j.Slf4j
import org.junit.jupiter.api.Test

@Slf4j
internal class GenerateUtilsTest {
    private val generateUtils = GenerateUtils()
    @Test
    fun generateStrNumber() {
    }

    @Test
    fun generateRandomStr() {
        print(GenerateUtils.generateRandomStr(11))
    }

    @Test
    fun generateLongNumber() {
    }

    @Test
    fun generateConsigneeName() {
    }

    @Test
    fun nickNameByPhoneNumber() {
    }

    @Test
    fun orderNo() {
    }
}