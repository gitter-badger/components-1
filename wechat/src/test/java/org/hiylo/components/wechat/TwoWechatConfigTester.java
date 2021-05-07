/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TwoWechatConfigTester.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat;

import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.wechat.pay.Topay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WechatApplicationTester.class)
public class TwoWechatConfigTester {
    @Resource
    private Topay userTopay;
    @Resource
    private Topay sendTopay;
    @Resource
    private Topay wechatTopay;

    @Test
    public void testTwoWechatConfig() {
    }
}
