/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : NoAuthorizationException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class NoAuthorizationException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public NoAuthorizationException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public NoAuthorizationException(Integer code, String message) {
        super(code, message, NoAuthorizationException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}