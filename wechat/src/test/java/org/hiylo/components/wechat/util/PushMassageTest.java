/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PushMassageTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.util;

import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.wechat.WechatApplicationTester;
import org.hiylo.components.wechat.user.WechatUtils;
import org.hiylo.components.wechat.utils.PushMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WechatApplicationTester.class)
public class PushMassageTest {
    @Autowired
    private PushMessage pushMessage;
    @Autowired
    private WechatUtils wechatUtils;

    @Test
    public void pushMessage() {
        Map<String, String> values = new HashMap<>();
        pushMessage.pushMessage("", "",values, "----", null);
    }

    @Test
    public void sendOrder() {
    }

    @Test
    public void headtoken() {
    }
}
