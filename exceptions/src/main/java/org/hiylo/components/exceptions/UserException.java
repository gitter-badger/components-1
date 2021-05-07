/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : UserException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author 朱玺
 * @ClassName: UserException
 * @Description: 用户业务异常
 * @date 2016年12月5日 上午10:36:43
 */
public class UserException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public UserException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public UserException(Integer code, String message) {
        super(code, message, UserException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
