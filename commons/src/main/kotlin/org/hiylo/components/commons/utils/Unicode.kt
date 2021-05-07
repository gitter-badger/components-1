/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Unicode.kt
 * Date : 2020/9/26 下午5:20
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils

/**
 * @author hiylo
 * @date 2020年9月26日 17:20:42
 */
class Unicode {

    fun decode(value: String): String {
        print(value)
        var start = 0
        var end: Int
        val result = StringBuilder()
        while (start > -1) {
            end = value.indexOf("\\u", start + 2)
            var char = ""
            if (end == -1) {
                char = value.substring(start + 2, value.length)
            } else {
                char = value.substring(start + 2, end)
            }
            val letter = Integer.parseInt(char, 16).toChar()
            result.append(letter.toString())
            start = end
        }
        return result.toString()
    }
}