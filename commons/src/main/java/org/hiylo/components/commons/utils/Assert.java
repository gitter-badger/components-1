/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Assert.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;

import java.util.List;

/**
 * @author hiylo
 * @date 2018年9月21日 14:07:08
 */
public class Assert {
    public static void isNotEmpty(String... values) {
        if (StringUtils.isEmpty(values)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    public static void isSizeGreaterThanZore(List<?> value) {
        if (value == null || value.size() == 0) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }
}
