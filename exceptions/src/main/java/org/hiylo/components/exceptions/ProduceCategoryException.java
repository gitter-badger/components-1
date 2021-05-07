/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ProduceCategoryException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author 朱玺
 * @ClassName: ProduceCategoryException
 * @Description: 商品分类异常
 * @date 2016年12月7日 上午11:49:42
 */
public class ProduceCategoryException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public ProduceCategoryException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public ProduceCategoryException(Integer code, String message) {
        super(code, message, ProduceCategoryException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
