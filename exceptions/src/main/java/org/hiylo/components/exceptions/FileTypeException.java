/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : FileTypeException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author Johnny
 * @ClassName: PictureException
 * @Description: 图片业务异常
 * @date 2016年1月17日 14:15:43
 */
public class FileTypeException extends BaseException implements Serializable {
    private static final long serialVersionUID = -2740402812439388308L;

    public FileTypeException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public FileTypeException(Integer code, String message) {
        super(code, message, FileTypeException.class);
    }


    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
