/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BrandException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * Created by hiylo on 12/19/2016.
 */
public class BrandException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2543258391939000337L;

    public BrandException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public BrandException(Integer code, String message) {
        super(code, message, BrandException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
