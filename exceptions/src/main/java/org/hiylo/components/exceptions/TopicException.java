/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TopicException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

public class TopicException extends BaseException implements Serializable {

    private static final long serialVersionUID = -7668374644924042558L;

    public TopicException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public TopicException(Integer code, String message) {
        super(code, message, TopicException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
