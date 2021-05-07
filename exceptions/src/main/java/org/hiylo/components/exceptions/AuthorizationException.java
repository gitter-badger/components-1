/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AuthorizationException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

public class AuthorizationException extends BaseException implements Serializable {
    private static final long serialVersionUID = 6192360479862735938L;

    public AuthorizationException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public AuthorizationException(Integer code, String message) {
        super(code, message, AuthorizationException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
