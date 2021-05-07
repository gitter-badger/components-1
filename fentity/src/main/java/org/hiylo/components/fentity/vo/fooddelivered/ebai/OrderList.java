/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : OrderList.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.ebai;

import lombok.Data;

import java.util.List;

@Data
public class OrderList {

    /**
     * body : {"errno":0,"error":"success","data":{"total":1,"page":1,"pages":1,"list":[{"order_id":"15408210705015","create_time":1540821070,"shop_id":"14c16e73f22b442b8fb300cb05a68320","baidu_shop_id":"2234706796","user_phone":"18149004880","order_from":1,"order_status":1,"status":1,"pay_status":"1","pay_type":1}]}}
     * cmd : resp.order.list
     * encrypt :
     * sign : D8F9DF9B18F823EF972A62996C1D4216
     * source : 62827
     * ticket : 7520B358-24DE-F339-6F55-45E7BEB317A7
     * timestamp : 1540821156
     * version : 3
     */

    private BodyBean body;
    private String cmd;
    private String encrypt;
    private String sign;
    private String source;
    private String ticket;
    private int timestamp;
    private String version;

    @Data
    public static class BodyBean {
        /**
         * errno : 0
         * error : success
         * data : {"total":1,"page":1,"pages":1,"list":[{"order_id":"15408210705015","create_time":1540821070,"shop_id":"14c16e73f22b442b8fb300cb05a68320","baidu_shop_id":"2234706796","user_phone":"18149004880","order_from":1,"order_status":1,"status":1,"pay_status":"1","pay_type":1}]}
         */

        private int errno;
        private String error;
        private DataBean data;

        @Data
        public static class DataBean {
            /**
             * total : 1
             * page : 1
             * pages : 1
             * list : [{"order_id":"15408210705015","create_time":1540821070,"shop_id":"14c16e73f22b442b8fb300cb05a68320","baidu_shop_id":"2234706796","user_phone":"18149004880","order_from":1,"order_status":1,"status":1,"pay_status":"1","pay_type":1}]
             */

            private int total;
            private int page;
            private int pages;
            private List<ListBean> list;

            @Data
            public static class ListBean {
                /**
                 * order_id : 15408210705015
                 * create_time : 1540821070
                 * shop_id : 14c16e73f22b442b8fb300cb05a68320
                 * baidu_shop_id : 2234706796
                 * user_phone : 18149004880
                 * order_from : 1
                 * order_status : 1
                 * status : 1
                 * pay_status : 1
                 * pay_type : 1
                 */

                private String order_id;
                private int create_time;
                private String shop_id;
                private String baidu_shop_id;
                private String user_phone;
                private int order_from;
                private int order_status;
                private int status;
                private String pay_status;
                private int pay_type;

            }
        }
    }
}
