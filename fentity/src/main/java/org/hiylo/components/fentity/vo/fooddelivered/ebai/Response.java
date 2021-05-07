/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Response.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.ebai;

import lombok.Data;

@Data
public class Response {

    /**
     * body : {"errno":0,"error":"success","data":true}
     * cmd : resp.order.confirm
     * sign : 51BAA29E9CE298241F52985864D23165
     * source : 65400
     * ticket : FEBCA99A-967D-EBDC-8588-F530B3E235E7
     * timestamp : 1452686921
     * version : 3
     */

    private BodyBean body;
    private String cmd;
    private String sign;
    private String source;
    private String ticket;
    private int timestamp;
    private int version;

    @Data
    public static class BodyBean {
        /**
         * errno : 0
         * error : success
         * data : true
         */

        private int errno;
        private String error;
        private Object data;
    }
}
