/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TransfeTester.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat;

import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.commons.SequenceUtils;
import org.hiylo.components.wechat.pay.Topay;
import org.hiylo.components.wechat.pay.Transfers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WechatApplicationTester.class)
public class TransfeTester implements ApplicationContextAware {
    @Autowired
    private Transfers wechatTransfers;
    @Resource
    private Topay topay;
    private ApplicationContext applicationContext;
    @Autowired
    private SequenceUtils sequenceUtils;

    @Test
    public void getPackage() throws Exception {
        //"o0HiNxMAlmF7pIdQ0yZf1HOKhKro"
        log.debug(topay.refund("4200000537202005117948252107", "118", sequenceUtils.getSequence(), 1.88,
                1.88, null));
//        log.debug(String.valueOf(topay.getPackage("商品名称", "1111111111111111", 10, "http://baidu.com", "APP", "1.1.1.1", null, "")));
    }

    @Test
    public void transfersToBalance() {
        try {
            log.info(String.valueOf(wechatTransfers.transferToBalance("EPT1595898003365", "-", "卢俊聪", "50000",
                    "", "172.17.164.219")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void transfersToBank() {
//        try {
//            log.debug(String.valueOf(userTransfers.transferToBankCard("1111111", "朱玺", "100", "2312312", "172.17.0.1",
//                    "1002", "2543534545345443", "测试")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void getPublicKey() {
//        try {
//            log.debug(userTransfers.getPublicKey());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

//    @Test
//    public void print() throws ClassNotFoundException {
//        Object o = applicationContext.getBeansWithAnnotation(EnableWechat.class);
//        log.debug(String.valueOf(o));
//        Class<?> wechatApplicationTesterClass = Class.forName("org.hiylo.components.wechat.WechatApplicationTester");
//        Annotation[] annotations = wechatApplicationTesterClass.getAnnotations();
//        for (Annotation annotation : annotations) {
//            log.debug(annotation.toString());
//            Annotation[] as = annotation.annotationType().getAnnotations();
//            for (Annotation a : as) {
//                log.debug(a.toString());
//            }
//        }
//
//    }

}
