/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : IDCardInfo.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.aliyun.openapi;

import java.util.Objects;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class IDCardInfo {
    private String sex;
    private String address;
    private String birthday;
    private String cardcode;
    private String realname;

    public IDCardInfo() {
    }

    public IDCardInfo(String sex, String address, String birthday, String cardcode, String realname) {
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.cardcode = cardcode;
        this.realname = realname;
    }

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

    public String getCardcode() {
        return cardcode;
    }

    public void setCardcode(String cardcode) {
        this.cardcode = cardcode;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public boolean hasCardcode() {
        return Objects.nonNull(cardcode) && !"".equals(cardcode);
    }
}
