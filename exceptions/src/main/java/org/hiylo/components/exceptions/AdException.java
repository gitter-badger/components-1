/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AdException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author Johnny
 * @ClassName: AdException
 * @Description: Ad业务异常
 * @date 2016年12月16日 16:10:43
 */
public class AdException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public AdException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public AdException(Integer code, String message) {
        super(code, message, AdException.class);
    }

    public AdException(Integer code, String message, Class clazz) {
        super(code, message, clazz);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
