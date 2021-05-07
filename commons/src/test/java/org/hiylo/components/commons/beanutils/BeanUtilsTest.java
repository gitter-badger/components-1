/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BeanUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BeanUtilsTest {
    BeanUtils beanUtils = new BeanUtils();

    @Test
    public void convert() {
        A a = new A();
        B b = new B();
        a.setAge("1");
        a.setName("2222");
        a.setClientType((byte) 1);
        a.setNum(111);
//        b.setName("3333");
        b.setPassword("4444444444");
        B2 b2 = new B2();
        b2.setBname("张三");
        b.setB2(b2);
        a.setB(b);
        List<Object> as = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            as.add(a);
        }
        C c = new C();
        long begin = System.currentTimeMillis();
        log.debug("开始" + begin);

//       log.debug(beanUtils.convertList(as, C.class));
        long end = System.currentTimeMillis();
        log.debug("总执行时间" + ((end - begin) / 1000));
        beanUtils.convert(a, c);
        log.debug(a.toString());
        log.debug(c.toString());
    }
}