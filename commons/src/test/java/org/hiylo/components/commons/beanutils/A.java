/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : A.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import org.hiylo.components.commons.beanutils.annotation.EnumMapper;
import org.hiylo.components.commons.beanutils.annotation.PropertyMapper;

public class A {
    @EnumMapper(refer = "org.hiylo.components.commons.beanutils.ClientType", referField = "description", method = "getClientType", to = "clientType", methodReturnObject = false)
    private Byte clientType;
    @PropertyMapper(refer = {"name", "password", "name", "password", "name", "password", "b2.bname"}, to = {"bName", "bPassword", "b.name", "b.password", "b2.bname", "b2.bpassword", "bName"})
    private B b;
    //    @PropertyMapper(ignore = true)
    private String name;
    private String age;
    private Integer num;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
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

    public Byte getClientType() {
        return clientType;
    }

    public void setClientType(Byte clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", num=" + num +
                '}';
    }
}
