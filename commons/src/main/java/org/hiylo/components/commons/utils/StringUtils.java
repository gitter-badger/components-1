/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : StringUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import java.util.List;
import java.util.Objects;

public class StringUtils {

    public static boolean isNotEmpty(String... values) {
        return !isEmpty(values);
    }

    public static boolean isEmpty(String... values) {
        for (String value : values) {
            if (value == null) {
                return true;
            }
            value = value.trim();
            if (value.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static String join(List<?> objs, String separator) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < objs.size(); i++) {
            Object obj = objs.get(i);
            if (Objects.nonNull(obj)) {
                result.append(obj);
                if (objs.size() != i + 1) {
                    result.append(separator);
                }
            }
        }
        return result.toString();
    }
}
