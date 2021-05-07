/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ServiceTypeException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author hiylo
 * @date 2018年3月29日 14:47:36
 */
public class ServiceTypeException extends BaseException implements Serializable {
    public ServiceTypeException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public ServiceTypeException(Integer code, String message) {
        super(code, message, ServiceTypeException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
