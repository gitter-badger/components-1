/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AuthorizationResponse.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.aliyun.openapi;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class AuthorizationResponse {
    /**
     * resp : {"code":0,"desc":"匹配"}
     * data : {"sex":"男","address":"广东省清远市清新县","birthday":"1989-05-25"}
     */

    private RespBean resp;
    private DataBean data;

    public RespBean getResp() {
        return resp;
    }

    public void setResp(RespBean resp) {
        this.resp = resp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class RespBean {
        /**
         * code : 0
         * desc : 匹配
         */

        private int code;
        private String desc;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class DataBean {
        /**
         * sex : 男
         * address : 广东省清远市清新县
         * birthday : 1989-05-25
         */

        private String sex;
        private String address;
        private String birthday;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
