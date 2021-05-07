/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : HtmlRender.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import java.util.Map;

public class HtmlRender {
    public static String render(String template, Map<String, String> args) {
        args.keySet().forEach(item -> {
            template.replace("{{" + item + "}}", args.get(item));
        });
        return template;
    }
}
