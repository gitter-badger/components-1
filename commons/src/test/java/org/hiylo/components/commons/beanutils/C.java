/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : C.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

public class C {
    private String bName;
    private String bPassword;
    private String name;
    private String clientType;
    private String age;
    private Integer num;
    private B b;
    private B2 b2;

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getbPassword() {
        return bPassword;
    }

    public void setbPassword(String bPassword) {
        this.bPassword = bPassword;
    }


    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public B2 getB2() {
        return b2;
    }

    public void setB2(B2 b2) {
        this.b2 = b2;
    }

    @Override
    public String toString() {
        return "C{" +
                "bName='" + bName + '\'' +
                ", bPassword='" + bPassword + '\'' +
                ", name='" + name + '\'' +
                ", clientType='" + clientType + '\'' +
                ", age='" + age + '\'' +
                ", num=" + num +
                ", b=" + b +
                ", b2=" + b2 +
                '}';
    }
}
