/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : MessageVO.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.eleme;

import lombok.Data;

import java.util.List;

/**
 * @author hiylo
 * @date 2018年10月15日 15:52:48
 */
@Data
public class MessageVO {

    /**
     * id : 1200897812792015983
     * orderId : 1200897812792015983
     * address : 上海市普陀区金沙江路丹巴路119号-NAPOS
     * createdAt : 2017-03-06T12:28:50
     * activeAt : 2017-03-06T12:28:50
     * deliverFee : 0
     * deliverTime : null
     * description : 爱吃辣多点辣
     * groups : [{"name":"1号篮子","type":"normal","items":[{"id":260,"skuId":-1,"name":"红烧肉[重辣]","categoryId":1,"price":4,"quantity":1,"total":4,"additions":[]}]},{"name":"2号篮子","type":"normal","items":[{"id":262,"skuId":-1,"name":"狮子头","categoryId":1,"price":5,"quantity":1,"total":5,"additions":[]}]},{"name":"3号篮子","type":"normal","items":[{"id":261,"skuId":-1,"name":"奶茶[去冰+半塘]","categoryId":1,"price":3,"quantity":2,"total":6,"additions":[]}]}]
     * invoice : 上海市拉拉队有限公司
     * book : false
     * onlinePaid : true
     * railwayAddress : null
     * phoneList : ["13456789012"]
     * shopId : 720032
     * shopName : 测试餐厅001
     * daySn : 7
     * status : unprocessed
     * refundStatus : noRefund
     * userId : 13524069
     * totalPrice : 20
     * originalPrice : 0
     * consignee : 饿了么 先生
     * deliveryGeo : 121.3836479187,31.2299251556
     * deliveryPoiAddress : 上海市普陀区金沙江路丹巴路119号-NAPOS
     * invoiced : true
     * income : 0
     * serviceRate : 0
     * serviceFee : 0
     * hongbao : 0
     * packageFee : 0
     * activityTotal : 0
     * shopPart : 0
     * elemePart : 0
     * downgraded : true
     * vipDeliveryFeeDiscount : 0
     */

    private String id;
    private String orderId;
    private String address;
    private String createdAt;
    private String activeAt;
    private Double deliverFee;
    private Object deliverTime;
    private String description;
    private String invoice;
    private boolean book;
    private boolean onlinePaid;
    private Object railwayAddress;
    private long shopId;
    private String shopName;
    private long daySn;
    private String status;
    private String refundStatus;
    private long userId;
    private Double totalPrice;
    private double originalPrice;
    private String consignee;
    private String deliveryGeo;
    private String deliveryPoiAddress;
    private boolean invoiced;
    private double income;
    private double serviceRate;
    private double serviceFee;
    private double hongbao;
    private double packageFee;
    private double activityTotal;
    private double shopPart;
    private double elemePart;
    private boolean downgraded;
    private Double vipDeliveryFeeDiscount;
    private List<GroupsBean> groups;
    private List<String> phoneList;
    private String state;
    private long updateTime;
    private String nightPrice;
    private String weatherPrice;
    private String holidayPrice;
    private String price;//快件费
    private String sumPrice;//快件费+动态加价
    private long distanceNumber;
    private String distance;//距离
    private String areaPrice;//区域价格
    private String isNight;//是否开启夜间加价
    private String isWeather;//是否开启天气加价
    private String isHoliday;//是否开启节日加价
    private String error;//错误信息
    private String dynamicPriceDesc;//动态加价描述
    private String dynamicPrice;//动态加价
    /**
     * 角色
     * 下单用户	1
     * 饿了么系统	2
     * 饿了么商户	3
     * 饿了么客服	4
     * 饿了么开放平台系统	5
     * 饿了么短信系统	6
     * 饿了么无线打印机系统	7
     * 饿了么风控系统	8
     * 饿了么订单完结	9
     */
    private long role;

    @Data
    public static class GroupsBean {
        /**
         * name : 1号篮子
         * type : normal
         * items : [{"id":260,"skuId":-1,"name":"红烧肉[重辣]","categoryId":1,"price":4,"quantity":1,"total":4,"additions":[]}]
         */

        private String name;
        private String type;
        private List<ItemsBean> items;

        @Data
        public static class ItemsBean {
            /**
             * id : 260
             * skuId : -1
             * name : 红烧肉[重辣]
             * categoryId : 1
             * price : 4
             * quantity : 1
             * total : 4
             * additions : []
             */

            private long id;
            private long skuId;
            private String name;
            private long categoryId;
            private double price;
            private double quantity;
            private double total;
            private List<?> additions;

        }
    }
}
