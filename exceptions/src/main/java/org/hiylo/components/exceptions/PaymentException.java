/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PaymentException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author 朱玺
 * @ClassName: PaymentException
 * @Description: TODO
 * @date 2016年12月19日 下午4:11:08
 */
public class PaymentException extends BaseException implements Serializable {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -6589911143820148356L;

    public PaymentException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public PaymentException(Integer code, String message) {
        super(code, message, PaymentException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
