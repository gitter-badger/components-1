/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommonsException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author 潘江楠
 * @ClassName: CommonException
 * @Description: 公共业务异常
 * @date 2016年12月6日 上午10:08:43
 */
public class CommonsException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public CommonsException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public CommonsException(Integer code, String message) {
        super(code, message, CommonsException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
