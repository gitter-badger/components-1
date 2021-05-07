/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : SystemUserException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * ClassName: ProduceException
 *
 * @author hiylo
 * @Description: TODO
 * @date 2016年3月14日
 */
public class SystemUserException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758395331000337L;

    public SystemUserException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public SystemUserException(Integer code, String message) {
        super(code, message, SystemUserException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
