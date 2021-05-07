/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ServiceException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author hiylo
 * @date 2018年3月29日 14:46:51
 */
public class ServiceException extends BaseException implements Serializable {
    public ServiceException(Integer code, String message) {
        super(code, message, ServiceException.class);
    }

    public ServiceException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
