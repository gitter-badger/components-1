/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : StoreException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

public class StoreException extends BaseException {
    public StoreException(Integer code, String message) {
        super(code, message, StoreException.class);
    }

    public StoreException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
