/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Response.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.meituan;

public class Response {

    /**
     * timestamp : 20190121161001
     * appId : 10080
     * sign : 20d48f2240e7eb8277b1b1c1d9ca1604
     * body : {"epid":"a305c33c94fb4287b468776f3661088b","action_type":3,"data":{"remark":"例汤热一点，最好烫烫的感谢！茄子辣一点，可以多放点辣椒，谢谢 收餐人隐私号 13044593409_7783，手机号 131****7889","day_seq":"24","delivery_time":0,"orderId":50115600331134772,"latitude":25.090195,"longitude":117.01921,"poi_address":"福建省龙岩市新罗区西城西安商业城市场95号店铺","poi_name":"台资味·卤肉饭（龙岩西安店）","poi_phone":"18650275541","recipient_address":"福建省龙岩市新罗区龙岩大道龙岩大道御龙首府3号楼-御龙首府3号楼 (1号店森品)","recipient_location":"御龙首府3号楼 (1号店森品)","recipient_location_details":"福建省龙岩市新罗区龙岩大道龙岩大道御龙首府3号楼","recipient_name":"小白(女士)","recipient_phone":"13044593409_7783","status":4,"create_time":"2019-01-21 13:08:43","original_price":23.9,"total":23.9,"data_id":256739}}
     */

    private String timestamp;
    private long appId;
    private String sign;
    private BodyBean body;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * epid : a305c33c94fb4287b468776f3661088b
         * action_type : 3
         * data : {"remark":"例汤热一点，最好烫烫的感谢！茄子辣一点，可以多放点辣椒，谢谢 收餐人隐私号 13044593409_7783，手机号 131****7889","day_seq":"24","delivery_time":0,"orderId":50115600331134772,"latitude":25.090195,"longitude":117.01921,"poi_address":"福建省龙岩市新罗区西城西安商业城市场95号店铺","poi_name":"台资味·卤肉饭（龙岩西安店）","poi_phone":"18650275541","recipient_address":"福建省龙岩市新罗区龙岩大道龙岩大道御龙首府3号楼-御龙首府3号楼 (1号店森品)","recipient_location":"御龙首府3号楼 (1号店森品)","recipient_location_details":"福建省龙岩市新罗区龙岩大道龙岩大道御龙首府3号楼","recipient_name":"小白(女士)","recipient_phone":"13044593409_7783","status":4,"create_time":"2019-01-21 13:08:43","original_price":23.9,"total":23.9,"data_id":256739}
         */

        private String epid;
        private long action_type;
        private DataBean data;

        public String getEpid() {
            return epid;
        }

        public void setEpid(String epid) {
            this.epid = epid;
        }

        public long getAction_type() {
            return action_type;
        }

        public void setAction_type(long action_type) {
            this.action_type = action_type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * remark : 例汤热一点，最好烫烫的感谢！茄子辣一点，可以多放点辣椒，谢谢 收餐人隐私号 13044593409_7783，手机号 131****7889
             * day_seq : 24
             * delivery_time : 0
             * orderId : 50115600331134772
             * latitude : 25.090195
             * longitude : 117.01921
             * poi_address : 福建省龙岩市新罗区西城西安商业城市场95号店铺
             * poi_name : 台资味·卤肉饭（龙岩西安店）
             * poi_phone : 18650275541
             * recipient_address : 福建省龙岩市新罗区龙岩大道龙岩大道御龙首府3号楼-御龙首府3号楼 (1号店森品)
             * recipient_location : 御龙首府3号楼 (1号店森品)
             * recipient_location_details : 福建省龙岩市新罗区龙岩大道龙岩大道御龙首府3号楼
             * recipient_name : 小白(女士)
             * recipient_phone : 13044593409_7783
             * status : 4
             * create_time : 2019-01-21 13:08:43
             * original_price : 23.9
             * total : 23.9
             * data_id : 256739
             */

            private String remark;
            private String day_seq;
            private long delivery_time;
            private long orderId;
            private double latitude;
            private double longitude;
            private String poi_address;
            private String poi_name;
            private String poi_phone;
            private String recipient_address;
            private String recipient_location;
            private String recipient_location_details;
            private String recipient_name;
            private String recipient_phone;
            private long status;
            private String create_time;
            private double original_price;
            private double total;
            private long data_id;

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getDay_seq() {
                return day_seq;
            }

            public void setDay_seq(String day_seq) {
                this.day_seq = day_seq;
            }

            public long getDelivery_time() {
                return delivery_time;
            }

            public void setDelivery_time(long delivery_time) {
                this.delivery_time = delivery_time;
            }

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getPoi_address() {
                return poi_address;
            }

            public void setPoi_address(String poi_address) {
                this.poi_address = poi_address;
            }

            public String getPoi_name() {
                return poi_name;
            }

            public void setPoi_name(String poi_name) {
                this.poi_name = poi_name;
            }

            public String getPoi_phone() {
                return poi_phone;
            }

            public void setPoi_phone(String poi_phone) {
                this.poi_phone = poi_phone;
            }

            public String getRecipient_address() {
                return recipient_address;
            }

            public void setRecipient_address(String recipient_address) {
                this.recipient_address = recipient_address;
            }

            public String getRecipient_location() {
                return recipient_location;
            }

            public void setRecipient_location(String recipient_location) {
                this.recipient_location = recipient_location;
            }

            public String getRecipient_location_details() {
                return recipient_location_details;
            }

            public void setRecipient_location_details(String recipient_location_details) {
                this.recipient_location_details = recipient_location_details;
            }

            public String getRecipient_name() {
                return recipient_name;
            }

            public void setRecipient_name(String recipient_name) {
                this.recipient_name = recipient_name;
            }

            public String getRecipient_phone() {
                return recipient_phone;
            }

            public void setRecipient_phone(String recipient_phone) {
                this.recipient_phone = recipient_phone;
            }

            public long getStatus() {
                return status;
            }

            public void setStatus(long status) {
                this.status = status;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public double getOriginal_price() {
                return original_price;
            }

            public void setOriginal_price(double original_price) {
                this.original_price = original_price;
            }

            public double getTotal() {
                return total;
            }

            public void setTotal(double total) {
                this.total = total;
            }

            public long getData_id() {
                return data_id;
            }

            public void setData_id(long data_id) {
                this.data_id = data_id;
            }
        }
    }
}
