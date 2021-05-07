/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommentException.java
 * Date : 2020/11/29 下午4:57
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

public class CommentException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2543258391576000337L;

    public CommentException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public CommentException(Integer code, String message) {
        super(code, message, BrandException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
