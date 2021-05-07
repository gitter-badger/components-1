/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : FileException.java
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
public class FileException extends BaseException implements Serializable {
    private static final long serialVersionUID = -2740402812439388308L;

    public FileException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public FileException(Integer code, String message) {
        super(code, message, FileException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }

    public static void main(String[] args) {
        FileException e = FileException.buildException(Constants.EXCEPTION_CODE_FILE_TYPE_ALREADY_EXIST);
        e.printStackTrace();
    }
}
