/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Order.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.ebai;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    /**
     * body : {"errno":0,"error":"success","data":{"source":"65472","shop":{"id":"baidubqa01","name":"测试-QA-骑兵专用","baidu_shop_id":"1483446181"},"order":{"expect_time_mode":1,"pickup_time":0,"atshop_time":0,"delivery_time":0,"delivery_phone":"","finished_time":"0","confirm_time":"0","order_id":"14788454249947","eleme_order_id":"14788454249947","order_index":"1","status":1,"order_flag":0,"send_immediately":2,"send_time":"1479091500","send_fee":0,"package_fee":1500,"discount_fee":0,"total_fee":5100,"shop_fee":5100,"user_fee":5100,"pay_type":1,"pay_status":1,"need_invoice":2,"invoice_title":"","remark":"请提供餐具","delivery_party":2,"create_time":"1478845425","cancel_time":"0"},"user":{"name":"邓","phone":"13261158090","gender":1,"address":"上地 彩虹大厦","province":"北京市","city":"北京市","district":"海淀区","coord":{"longitude":116.321306,"latitude":40.041169}},"products":[[{"baidu_product_id":"1529731460","other_dish_id":"1529731460","upc":"","product_name":"紫薯粥_小盒","product_type":1,"product_price":600,"product_amount":1,"product_fee":600,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":1100,"product_custom_index":"1529731460_0_0","product_attr":[{"baidu_attr_id":"1703572077","attr_id":"","name":"规格","option":"小盒"}],"product_features":[{"baidu_feature_id":"1703572074","name":"辣的","option":"微辣"},{"baidu_feature_id":"1703573994","name":"温度","option":"常温"}],"product_id":"","is_fixed_price":"0","group":[{"group_name":"大叔套餐","baidu_group_id":"1724959965","product":[{"baidu_product_id":"1529731874","other_dish_id":"1529731874","upc":"","product_name":"花生粥","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"product_attr":[],"product_features":[{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]}]},{"group_name":"学生套餐","baidu_group_id":"1724959966","product":[{"baidu_product_id":"1537991176","other_dish_id":"1537991176","upc":"","product_name":"蛋炒饭_超辣","product_type":1,"product_price":1500,"product_amount":1,"product_fee":1500,"product_attr":[{"baidu_attr_id":"1723616803","attr_id":"","name":"规格","option":"超辣"}],"product_features":[{"baidu_feature_id":"1723619110","name":"配菜","option":"韭菜"}]}]}]},{"baidu_product_id":"1724959964","product_id":"","product_type":2,"product_name":"奥运会青春套餐","is_fixed_price":"0","product_price":2500,"product_amount":1,"product_fee":2500,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":3000,"group":[{"group_name":"大叔套餐","baidu_group_id":"1724959965","product":[{"baidu_product_id":"1529731874","other_dish_id":"1529731874","upc":"","product_name":"花生粥","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"product_attr":[],"product_features":[{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]}]},{"group_name":"学生套餐","baidu_group_id":"1724959966","product":[{"baidu_product_id":"1537991176","other_dish_id":"1537991176","upc":"","product_name":"蛋炒饭_超辣","product_type":1,"product_price":1500,"product_amount":1,"product_fee":1500,"product_attr":[{"baidu_attr_id":"1723616803","attr_id":"","name":"规格","option":"超辣"}],"product_features":[{"baidu_feature_id":"1723619110","name":"配菜","option":"韭菜"}]}]}]},{"baidu_product_id":"1591504578","other_dish_id":"1591504578","upc":"","product_name":"看(⊙o⊙)","product_type":1,"product_price":500,"product_amount":1,"product_fee":500,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":1000,"product_attr":[],"product_features":[]}]],"discount":[],"part_refund_info":[{"status":"10","total_price":200,"shop_fee":0,"order_price":100,"package_fee":0,"discount_fee":0,"send_fee":100,"refund_price":1000,"refund_box_price":0,"refund_send_price":0,"refund_discount_price":0,"refuse_platform":0,"commission":0,"order_detail":[[{"baidu_product_id":"1772493433","upc":"","product_name":"13241","product_type":1,"product_price":100,"product_amount":1,"product_fee":100,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":100,"product_attr":[],"product_features":[],"product_custom_index":"1772493433_0_0"}]],"refund_detail":[[{"baidu_product_id":"1926765752","other_dish_id":"1926765727","upc":"","product_name":"同步菜","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":1000,"product_attr":[],"product_features":[],"product_custom_index":"1926765752_0_0"}]],"discount":[]}]}}
     * cmd : resp.order.get
     * encrypt :
     * sign : ECD12F403A7A96CD8D9F0FD8B9571003
     * source : 65472
     * ticket : EAAD2A1F-8EA9-7F34-EF50-20007982CF52
     * timestamp : 1478845788
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
         * data : {"source":"65472","shop":{"id":"baidubqa01","name":"测试-QA-骑兵专用","baidu_shop_id":"1483446181"},"order":{"expect_time_mode":1,"pickup_time":0,"atshop_time":0,"delivery_time":0,"delivery_phone":"","finished_time":"0","confirm_time":"0","order_id":"14788454249947","eleme_order_id":"14788454249947","order_index":"1","status":1,"order_flag":0,"send_immediately":2,"send_time":"1479091500","send_fee":0,"package_fee":1500,"discount_fee":0,"total_fee":5100,"shop_fee":5100,"user_fee":5100,"pay_type":1,"pay_status":1,"need_invoice":2,"invoice_title":"","remark":"请提供餐具","delivery_party":2,"create_time":"1478845425","cancel_time":"0"},"user":{"name":"邓","phone":"13261158090","gender":1,"address":"上地 彩虹大厦","province":"北京市","city":"北京市","district":"海淀区","coord":{"longitude":116.321306,"latitude":40.041169}},"products":[[{"baidu_product_id":"1529731460","other_dish_id":"1529731460","upc":"","product_name":"紫薯粥_小盒","product_type":1,"product_price":600,"product_amount":1,"product_fee":600,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":1100,"product_custom_index":"1529731460_0_0","product_attr":[{"baidu_attr_id":"1703572077","attr_id":"","name":"规格","option":"小盒"}],"product_features":[{"baidu_feature_id":"1703572074","name":"辣的","option":"微辣"},{"baidu_feature_id":"1703573994","name":"温度","option":"常温"}]},{"baidu_product_id":"1724959964","product_id":"","product_type":2,"product_name":"奥运会青春套餐","is_fixed_price":"0","product_price":2500,"product_amount":1,"product_fee":2500,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":3000,"group":[{"group_name":"大叔套餐","baidu_group_id":"1724959965","product":[{"baidu_product_id":"1529731874","other_dish_id":"1529731874","upc":"","product_name":"花生粥","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"product_attr":[],"product_features":[{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]}]},{"group_name":"学生套餐","baidu_group_id":"1724959966","product":[{"baidu_product_id":"1537991176","other_dish_id":"1537991176","upc":"","product_name":"蛋炒饭_超辣","product_type":1,"product_price":1500,"product_amount":1,"product_fee":1500,"product_attr":[{"baidu_attr_id":"1723616803","attr_id":"","name":"规格","option":"超辣"}],"product_features":[{"baidu_feature_id":"1723619110","name":"配菜","option":"韭菜"}]}]}]},{"baidu_product_id":"1591504578","other_dish_id":"1591504578","upc":"","product_name":"看(⊙o⊙)","product_type":1,"product_price":500,"product_amount":1,"product_fee":500,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":1000,"product_attr":[],"product_features":[]}]],"discount":[],"part_refund_info":[{"status":"10","total_price":200,"shop_fee":0,"order_price":100,"package_fee":0,"discount_fee":0,"send_fee":100,"refund_price":1000,"refund_box_price":0,"refund_send_price":0,"refund_discount_price":0,"refuse_platform":0,"commission":0,"order_detail":[[{"baidu_product_id":"1772493433","upc":"","product_name":"13241","product_type":1,"product_price":100,"product_amount":1,"product_fee":100,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":100,"product_attr":[],"product_features":[],"product_custom_index":"1772493433_0_0"}]],"refund_detail":[[{"baidu_product_id":"1926765752","other_dish_id":"1926765727","upc":"","product_name":"同步菜","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":1000,"product_attr":[],"product_features":[],"product_custom_index":"1926765752_0_0"}]],"discount":[]}]}
         */

        private int errno;
        private String error;
        private DataBean data;

        @Data
        public static class DataBean {
            /**
             * source : 65472
             * shop : {"id":"baidubqa01","name":"测试-QA-骑兵专用","baidu_shop_id":"1483446181"}
             * order : {"expect_time_mode":1,"pickup_time":0,"atshop_time":0,"delivery_time":0,"delivery_phone":"","finished_time":"0","confirm_time":"0","order_id":"14788454249947","eleme_order_id":"14788454249947","order_index":"1","status":1,"order_flag":0,"send_immediately":2,"send_time":"1479091500","send_fee":0,"package_fee":1500,"discount_fee":0,"total_fee":5100,"shop_fee":5100,"user_fee":5100,"pay_type":1,"pay_status":1,"need_invoice":2,"invoice_title":"","remark":"请提供餐具","delivery_party":2,"create_time":"1478845425","cancel_time":"0"}
             * user : {"name":"邓","phone":"13261158090","gender":1,"address":"上地 彩虹大厦","province":"北京市","city":"北京市","district":"海淀区","coord":{"longitude":116.321306,"latitude":40.041169}}
             * products : [[{"baidu_product_id":"1529731460","other_dish_id":"1529731460","upc":"","product_name":"紫薯粥_小盒","product_type":1,"product_price":600,"product_amount":1,"product_fee":600,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":1100,"product_custom_index":"1529731460_0_0","product_attr":[{"baidu_attr_id":"1703572077","attr_id":"","name":"规格","option":"小盒"}],"product_features":[{"baidu_feature_id":"1703572074","name":"辣的","option":"微辣"},{"baidu_feature_id":"1703573994","name":"温度","option":"常温"}]},{"baidu_product_id":"1724959964","product_id":"","product_type":2,"product_name":"奥运会青春套餐","is_fixed_price":"0","product_price":2500,"product_amount":1,"product_fee":2500,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":3000,"group":[{"group_name":"大叔套餐","baidu_group_id":"1724959965","product":[{"baidu_product_id":"1529731874","other_dish_id":"1529731874","upc":"","product_name":"花生粥","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"product_attr":[],"product_features":[{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]}]},{"group_name":"学生套餐","baidu_group_id":"1724959966","product":[{"baidu_product_id":"1537991176","other_dish_id":"1537991176","upc":"","product_name":"蛋炒饭_超辣","product_type":1,"product_price":1500,"product_amount":1,"product_fee":1500,"product_attr":[{"baidu_attr_id":"1723616803","attr_id":"","name":"规格","option":"超辣"}],"product_features":[{"baidu_feature_id":"1723619110","name":"配菜","option":"韭菜"}]}]}]},{"baidu_product_id":"1591504578","other_dish_id":"1591504578","upc":"","product_name":"看(⊙o⊙)","product_type":1,"product_price":500,"product_amount":1,"product_fee":500,"package_price":500,"package_amount":"1","package_fee":500,"total_fee":1000,"product_attr":[],"product_features":[]}]]
             * discount : []
             * part_refund_info : [{"status":"10","total_price":200,"shop_fee":0,"order_price":100,"package_fee":0,"discount_fee":0,"send_fee":100,"refund_price":1000,"refund_box_price":0,"refund_send_price":0,"refund_discount_price":0,"refuse_platform":0,"commission":0,"order_detail":[[{"baidu_product_id":"1772493433","upc":"","product_name":"13241","product_type":1,"product_price":100,"product_amount":1,"product_fee":100,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":100,"product_attr":[],"product_features":[],"product_custom_index":"1772493433_0_0"}]],"refund_detail":[[{"baidu_product_id":"1926765752","other_dish_id":"1926765727","upc":"","product_name":"同步菜","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":1000,"product_attr":[],"product_features":[],"product_custom_index":"1926765752_0_0"}]],"discount":[]}]
             */

            private String source;
            private ShopBean shop;
            private ShopBean.OrderBean order;
            private ShopBean.UserBean user;
            private List<List<ShopBean.ProductsBean>> products;
            private List<?> discount;
            private List<ShopBean.PartRefundInfoBean> part_refund_info;
            private String error;
            private String chatelainId;
            private Integer distanceNumber;
            private String distance;
            private String areaId;
            private String areaPrice;

            @Data
            public static class ShopBean {
                /**
                 * id : baidubqa01
                 * name : 测试-QA-骑兵专用
                 * baidu_shop_id : 1483446181
                 */

                private String id;
                private String name;
                private String baidu_shop_id;

                @Data
                public static class OrderBean {
                    /**
                     * expect_time_mode : 1
                     * pickup_time : 0
                     * atshop_time : 0
                     * delivery_time : 0
                     * delivery_phone :
                     * finished_time : 0
                     * confirm_time : 0
                     * order_id : 14788454249947
                     * eleme_order_id : 14788454249947
                     * order_index : 1
                     * status : 1
                     * order_flag : 0
                     * send_immediately : 2
                     * send_time : 1479091500
                     * send_fee : 0
                     * package_fee : 1500
                     * discount_fee : 0
                     * total_fee : 5100
                     * shop_fee : 5100
                     * user_fee : 5100
                     * pay_type : 1
                     * pay_status : 1
                     * need_invoice : 2
                     * invoice_title :
                     * remark : 请提供餐具
                     * delivery_party : 2
                     * create_time : 1478845425
                     * cancel_time : 0
                     */

                    private int expect_time_mode;
                    private int pickup_time;
                    private int atshop_time;
                    private int delivery_time;
                    private String delivery_phone;
                    private String finished_time;
                    private String confirm_time;
                    private String order_id;
                    private String eleme_order_id;
                    private String order_index;
                    private int status;
                    private int order_flag;
                    private int send_immediately;
                    private String send_time;
                    private int send_fee;
                    private int package_fee;
                    private int discount_fee;
                    private int total_fee;
                    private int shop_fee;
                    private int user_fee;
                    private int pay_type;
                    private int pay_status;
                    private int need_invoice;
                    private String invoice_title;
                    private String remark;
                    private int delivery_party;
                    private String create_time;
                    private String cancel_time;
                }

                @Data
                public static class UserBean {
                    /**
                     * name : 邓
                     * phone : 13261158090
                     * gender : 1
                     * address : 上地 彩虹大厦
                     * province : 北京市
                     * city : 北京市
                     * district : 海淀区
                     * coord : {"longitude":116.321306,"latitude":40.041169}
                     */

                    private String name;
                    private String phone;
                    private String gender;
                    private String address;
                    private String province;
                    private String city;
                    private String district;
                    private CoordBean coord;

                    @Data
                    public static class CoordBean {
                        /**
                         * longitude : 116.321306
                         * latitude : 40.041169
                         */

                        private double longitude;
                        private double latitude;

                    }
                }

                @Data
                public static class ProductsBean {
                    /**
                     * baidu_product_id : 1529731460
                     * other_dish_id : 1529731460
                     * upc :
                     * product_name : 紫薯粥_小盒
                     * product_type : 1
                     * product_price : 600
                     * product_amount : 1
                     * product_fee : 600
                     * package_price : 500
                     * package_amount : 1
                     * package_fee : 500
                     * total_fee : 1100
                     * product_custom_index : 1529731460_0_0
                     * product_attr : [{"baidu_attr_id":"1703572077","attr_id":"","name":"规格","option":"小盒"}]
                     * product_features : [{"baidu_feature_id":"1703572074","name":"辣的","option":"微辣"},{"baidu_feature_id":"1703573994","name":"温度","option":"常温"}]
                     * product_id :
                     * is_fixed_price : 0
                     * group : [{"group_name":"大叔套餐","baidu_group_id":"1724959965","product":[{"baidu_product_id":"1529731874","other_dish_id":"1529731874","upc":"","product_name":"花生粥","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"product_attr":[],"product_features":[{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]}]},{"group_name":"学生套餐","baidu_group_id":"1724959966","product":[{"baidu_product_id":"1537991176","other_dish_id":"1537991176","upc":"","product_name":"蛋炒饭_超辣","product_type":1,"product_price":1500,"product_amount":1,"product_fee":1500,"product_attr":[{"baidu_attr_id":"1723616803","attr_id":"","name":"规格","option":"超辣"}],"product_features":[{"baidu_feature_id":"1723619110","name":"配菜","option":"韭菜"}]}]}]
                     */

                    private String baidu_product_id;
                    private String other_dish_id;
                    private String upc;
                    private String product_name;
                    private int product_type;
                    private int product_price;
                    private int product_amount;
                    private int product_fee;
                    private int package_price;
                    private String package_amount;
                    private int package_fee;
                    private int total_fee;
                    private String product_custom_index;
                    private String product_id;
                    private String is_fixed_price;
                    private List<ProductAttrBean> product_attr;
                    private List<ProductFeaturesBean> product_features;
                    private List<GroupBean> group;

                    @Data
                    public static class ProductAttrBean {
                        /**
                         * baidu_attr_id : 1703572077
                         * attr_id :
                         * name : 规格
                         * option : 小盒
                         */

                        private String baidu_attr_id;
                        private String attr_id;
                        private String name;
                        private String option;

                    }

                    @Data
                    public static class ProductFeaturesBean {
                        /**
                         * baidu_feature_id : 1703572074
                         * name : 辣的
                         * option : 微辣
                         */

                        private String baidu_feature_id;
                        private String name;
                        private String option;

                    }

                    @Data
                    public static class GroupBean {
                        /**
                         * group_name : 大叔套餐
                         * baidu_group_id : 1724959965
                         * product : [{"baidu_product_id":"1529731874","other_dish_id":"1529731874","upc":"","product_name":"花生粥","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"product_attr":[],"product_features":[{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]}]
                         */

                        private String group_name;
                        private String baidu_group_id;
                        private List<ProductBean> product;

                        @Data
                        public static class ProductBean {
                            /**
                             * baidu_product_id : 1529731874
                             * other_dish_id : 1529731874
                             * upc :
                             * product_name : 花生粥
                             * product_type : 1
                             * product_price : 1000
                             * product_amount : 1
                             * product_fee : 1000
                             * product_attr : []
                             * product_features : [{"baidu_feature_id":"1776052375","name":"温度","option":"高"}]
                             */

                            private String baidu_product_id;
                            private String other_dish_id;
                            private String upc;
                            private String product_name;
                            private int product_type;
                            private int product_price;
                            private int product_amount;
                            private int product_fee;
                            private List<?> product_attr;
                            private List<ProductFeaturesBeanX> product_features;

                            @Data
                            public static class ProductFeaturesBeanX {
                                /**
                                 * baidu_feature_id : 1776052375
                                 * name : 温度
                                 * option : 高
                                 */

                                private String baidu_feature_id;
                                private String name;
                                private String option;

                            }
                        }
                    }
                }

                @Data
                public static class PartRefundInfoBean {
                    /**
                     * status : 10
                     * total_price : 200
                     * shop_fee : 0
                     * order_price : 100
                     * package_fee : 0
                     * discount_fee : 0
                     * send_fee : 100
                     * refund_price : 1000
                     * refund_box_price : 0
                     * refund_send_price : 0
                     * refund_discount_price : 0
                     * refuse_platform : 0
                     * commission : 0
                     * order_detail : [[{"baidu_product_id":"1772493433","upc":"","product_name":"13241","product_type":1,"product_price":100,"product_amount":1,"product_fee":100,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":100,"product_attr":[],"product_features":[],"product_custom_index":"1772493433_0_0"}]]
                     * refund_detail : [[{"baidu_product_id":"1926765752","other_dish_id":"1926765727","upc":"","product_name":"同步菜","product_type":1,"product_price":1000,"product_amount":1,"product_fee":1000,"package_price":0,"package_amount":"1","package_fee":0,"total_fee":1000,"product_attr":[],"product_features":[],"product_custom_index":"1926765752_0_0"}]]
                     * discount : []
                     */

                    private String status;
                    private int total_price;
                    private int shop_fee;
                    private int order_price;
                    private int package_fee;
                    private int discount_fee;
                    private int send_fee;
                    private int refund_price;
                    private int refund_box_price;
                    private int refund_send_price;
                    private int refund_discount_price;
                    private int refuse_platform;
                    private int commission;
                    private List<List<OrderDetailBean>> order_detail;
                    private List<List<RefundDetailBean>> refund_detail;
                    private List<?> discount;

                    @Data
                    public static class OrderDetailBean {
                        /**
                         * baidu_product_id : 1772493433
                         * upc :
                         * product_name : 13241
                         * product_type : 1
                         * product_price : 100
                         * product_amount : 1
                         * product_fee : 100
                         * package_price : 0
                         * package_amount : 1
                         * package_fee : 0
                         * total_fee : 100
                         * product_attr : []
                         * product_features : []
                         * product_custom_index : 1772493433_0_0
                         */

                        private String baidu_product_id;
                        private String upc;
                        private String product_name;
                        private int product_type;
                        private int product_price;
                        private int product_amount;
                        private int product_fee;
                        private int package_price;
                        private String package_amount;
                        private int package_fee;
                        private int total_fee;
                        private String product_custom_index;
                        private List<?> product_attr;
                        private List<?> product_features;

                    }

                    @Data
                    public static class RefundDetailBean {
                        /**
                         * baidu_product_id : 1926765752
                         * other_dish_id : 1926765727
                         * upc :
                         * product_name : 同步菜
                         * product_type : 1
                         * product_price : 1000
                         * product_amount : 1
                         * product_fee : 1000
                         * package_price : 0
                         * package_amount : 1
                         * package_fee : 0
                         * total_fee : 1000
                         * product_attr : []
                         * product_features : []
                         * product_custom_index : 1926765752_0_0
                         */

                        private String baidu_product_id;
                        private String other_dish_id;
                        private String upc;
                        private String product_name;
                        private int product_type;
                        private int product_price;
                        private int product_amount;
                        private int product_fee;
                        private int package_price;
                        private String package_amount;
                        private int package_fee;
                        private int total_fee;
                        private String product_custom_index;
                        private List<?> product_attr;
                        private List<?> product_features;

                    }
                }
            }
        }
    }
}
