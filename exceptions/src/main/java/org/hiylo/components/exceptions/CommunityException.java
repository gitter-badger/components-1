/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommunityException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author Johnny
 * @ClassName: CommunityException
 * @Description: Ad业务异常
 * @date 2016年12月16日 16:10:43
 */
public class CommunityException extends BaseException implements Serializable {

    private static final long serialVersionUID = -7139938524472399576L;

    public CommunityException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public CommunityException(Integer code, String message) {
        super(code, message, CommunityException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
