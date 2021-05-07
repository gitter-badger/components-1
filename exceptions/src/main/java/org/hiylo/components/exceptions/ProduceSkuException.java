/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ProduceSkuException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.exceptions;

import java.io.Serializable;

/**
 * @author 朱玺
 * @ClassName: ProduceSkuException
 * @Description: 商品SKU异常
 * @date 2016年12月7日 下午12:35:15
 */
public class ProduceSkuException extends BaseException implements Serializable {
    private static final long serialVersionUID = 2560758391939000337L;

    public ProduceSkuException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code));
    }

    public ProduceSkuException(Integer code, String message) {
        super(code, message, ProduceSkuException.class);
    }

    public static <T extends BaseException> T buildException(Integer code) {
        return BaseException.call(code);
    }

    public static <T extends BaseException> T buildException(Integer code, String message) {
        return BaseException.call(code, message);
    }
}
