/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommonsRuntimeException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author 潘江楠
 * @ClassName: CommonsRuntimeException
 * @Description: 公共业务异常
 * @date 2016年12月6日 上午10:08:43
 */
public class CommonsRuntimeException extends BaseRuntimeException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public CommonsRuntimeException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public CommonsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonsRuntimeException(Integer code, String message) {
        super(code, message, CommonsRuntimeException.class);
    }


    public static <T extends BaseRuntimeException> T buildException(Integer code) {
        return BaseRuntimeException.call(code);
    }

    public static <T extends BaseRuntimeException> T buildException(Integer code, String message) {
        return BaseRuntimeException.call(code, message);
    }

}
