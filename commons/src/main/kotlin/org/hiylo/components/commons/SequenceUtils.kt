/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : SequenceUtils.kt
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons

import org.hiylo.components.commons.utils.HttpClient
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.*

/**
 * @author hiylo
 * @date 2018年12月7日 10:36:41
 */
@Component
class SequenceUtils {
    private val httpClient = HttpClient()

    val sequence: String?
        get() {
            return try {
                httpClient.get("http://47.100.31.22:8773/getSequenceLong")
            } catch (e: IOException) {
                UUID.randomUUID().toString().replace("-", "")
            }

        }
}
