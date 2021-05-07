/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Response.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.wboll;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hiylo
 * @date 2019年10月22日 14:55:51
 */
@Data
public class Response implements Serializable {
    private static final long serialVersionUID = 3873708409147464001L;
    private Head head;
    private String body;

    @Data
    public class Head implements Serializable {
        private static final long serialVersionUID = 2461397671486362897L;
        private String code;
        private String msg;
    }
}
