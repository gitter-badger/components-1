/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : FileFormatNotSupportedException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * Created by hiylo on 1/18/2017.
 */
public class FileFormatNotSupportedException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public FileFormatNotSupportedException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public FileFormatNotSupportedException(Integer code, String message) {
        super(code, message, FileFormatNotSupportedException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
