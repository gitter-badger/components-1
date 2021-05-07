/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Response.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.eleme;

import lombok.Data;

/**
 * @author hiylo
 * @date 2018年10月16日 11:33:51
 */
@Data
public class Response {

    /**
     * id : a4a3f8c9-b8f1-458e-924b-91e45781414b
     * result : null
     * error : {"code":"VALIDATION_FAILED","message":"参数校验失败"}
     */

    private String id;
    private Object result;
    private ErrorBean error;

    @Data
    public static class ErrorBean {
        /**
         * code : VALIDATION_FAILED
         * message : 参数校验失败
         */

        private String code;
        private String message;


    }
}
