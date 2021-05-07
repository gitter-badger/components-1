/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : HtmlGenerator.kt
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.commons.utils

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
class HtmlGenerator {
    /**
     * <style type=\"text/css\"></style>
     */
    private val PREFIX = "<!DOCTYPE HTML><html xmlns:th=\"http://www.thymeleaf.org/\"><head><meta charset=\"utf-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes\" /></head><body>"
    private val SUFFIX = "</body></html>"

    fun wapGenerator(content: String): String {
        return (PREFIX + content + SUFFIX).replace("<img ".toRegex(), "<img style=\"max-width:100%;\" width=\"100%\"")
    }

}
