/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Shop.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.ebai;

import lombok.Data;

import java.util.List;

@Data
public class Shop {
    /**
     * body : {"errno":0,"error":"success","data":{"shop_id":"1684940366","name":" 星巴克测试(温特莱店)","shop_logo":"http://img-star.elemecdn.com/pb/d3151970e0b2ff127ad693daac5597e0be","province":"北京市","city":"北京","county":"朝阳区","address":"北京市西大望路甲一号温特莱中心1楼","brand":"星巴克","category1":"餐饮","category2":"","category3":"","phone":"010-65387097","service_phone":"","longitude":116.479714,"latitude":39.915092,"business_time":[{"start":"10:00","end":"00:00"}],"book_ahead_time":"0","invoice_support":"1","min_order_price":0,"delivery_party":"self","delivery_type":"1|1","package_box_price":0,"delivery_delay_time":"0","status":"1","baidu_shop_id":"1684940366","categorys":[{"category1":"餐饮","category2":"糕点饮品","category3":"咖啡厅"},{"category1":"餐饮","category2":"糕点饮品","category3":"其他饮品"},{"category1":"餐饮","category2":"糕点饮品","category3":"面包糕点"}],"delivery_region":[],"threshold":"","coord_type":"bdll"}}
     * cmd : resp.shop.get
     * encrypt :
     * sign : E7D160F1C5E663B57C77D0DC0AF79791
     * source : 30325
     * ticket : FAF9E07C-9B64-38A3-978F-FACFCBC18E3F
     * timestamp : 1479106794
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
         * data : {"shop_id":"1684940366","name":" 星巴克测试(温特莱店)","shop_logo":"http://img-star.elemecdn.com/pb/d3151970e0b2ff127ad693daac5597e0be","province":"北京市","city":"北京","county":"朝阳区","address":"北京市西大望路甲一号温特莱中心1楼","brand":"星巴克","category1":"餐饮","category2":"","category3":"","phone":"010-65387097","service_phone":"","longitude":116.479714,"latitude":39.915092,"business_time":[{"start":"10:00","end":"00:00"}],"book_ahead_time":"0","invoice_support":"1","min_order_price":0,"delivery_party":"self","delivery_type":"1|1","package_box_price":0,"delivery_delay_time":"0","status":"1","baidu_shop_id":"1684940366","categorys":[{"category1":"餐饮","category2":"糕点饮品","category3":"咖啡厅"},{"category1":"餐饮","category2":"糕点饮品","category3":"其他饮品"},{"category1":"餐饮","category2":"糕点饮品","category3":"面包糕点"}],"delivery_region":[],"threshold":"","coord_type":"bdll"}
         */

        private int errno;
        private String error;
        private DataBean data;

        @Data
        public static class DataBean {
            /**
             * shop_id : 1684940366
             * name :  星巴克测试(温特莱店)
             * shop_logo : http://img-star.elemecdn.com/pb/d3151970e0b2ff127ad693daac5597e0be
             * province : 北京市
             * city : 北京
             * county : 朝阳区
             * address : 北京市西大望路甲一号温特莱中心1楼
             * brand : 星巴克
             * category1 : 餐饮
             * category2 :
             * category3 :
             * phone : 010-65387097
             * service_phone :
             * longitude : 116.479714
             * latitude : 39.915092
             * business_time : [{"start":"10:00","end":"00:00"}]
             * book_ahead_time : 0
             * invoice_support : 1
             * min_order_price : 0
             * delivery_party : self
             * delivery_type : 1|1
             * package_box_price : 0
             * delivery_delay_time : 0
             * status : 1
             * baidu_shop_id : 1684940366
             * categorys : [{"category1":"餐饮","category2":"糕点饮品","category3":"咖啡厅"},{"category1":"餐饮","category2":"糕点饮品","category3":"其他饮品"},{"category1":"餐饮","category2":"糕点饮品","category3":"面包糕点"}]
             * delivery_region : []
             * threshold :
             * coord_type : bdll
             */

            private String shop_id;
            private String name;
            private String province;
            private String city;
            private String county;
            private String address;
            private String brand;
            private String category1;
            private String category2;
            private String category3;
            private String phone;
            private String service_phone;
            private double longitude;
            private double latitude;
            private String book_ahead_time;
            private String invoice_support;
            private int min_order_price;
            private String delivery_party;
            private String delivery_type;
            private int package_box_price;
            private String delivery_delay_time;
            private String status;
            private String baidu_shop_id;
            private List<ThresholdBean> threshold;
            private String coord_type;
            private List<BusinessTimeBean> business_time;
            private List<CategorysBean> categorys;
            private List<?> delivery_region;

            @Data
            public static class BusinessTimeBean {
                /**
                 * start : 10:00
                 * end : 00:00
                 */

                private String start;
                private String end;

            }

            @Data
            public static class CategorysBean {
                /**
                 * category1 : 餐饮
                 * category2 : 糕点饮品
                 * category3 : 咖啡厅
                 */

                private String category1;
                private String category2;
                private String category3;

            }

            @Data
            public static class ThresholdBean {
                private Double num;
                private String time;

            }
        }
    }
}
