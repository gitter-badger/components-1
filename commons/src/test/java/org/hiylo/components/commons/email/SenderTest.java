///*
// * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
// * Project : components
// * File : SenderTest.java
// * Date : 3/10/20, 1:42 AM
// * Author : Hsi Chu
// * Contact : hiylo@live.com
// */
//
//package org.hiylo.components.commons.emall;
//
//import lombok.extern.slf4j.Slf4j;
//import org.hiylo.components.commons.CommonsApplicationTester;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.MailSender;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = CommonsApplicationTester.class)
//class SenderTest {
//    @Autowired
//    private MailSender mailSender;
//
//    @Test
//    void sendMail() {
//        mailSender.sendMail("hiylo@live.com", "测试邮件", "这是一封测试邮件");
//    }
//}