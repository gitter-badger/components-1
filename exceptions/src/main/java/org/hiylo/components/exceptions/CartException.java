/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CartException.java
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
public class CartException extends BaseException implements Serializable {
    private static final long serialVersionUID = 6192360479862525938L;

    public CartException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public CartException(Integer code, String message) {
        super(code, message, CartException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }

}
