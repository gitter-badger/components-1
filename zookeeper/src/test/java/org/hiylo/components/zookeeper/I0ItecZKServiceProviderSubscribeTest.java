/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : I0ItecZKServiceProviderSubscribeTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.zookeeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Zookeeper 事件回调测试
 * @author Hsi Chu
 * @date 2021年5月6日 02:04:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZookeeperApplicationTester.class)
public class I0ItecZKServiceProviderSubscribeTest implements I0ItecZooKeeperServiceProviderSubscribe {
    @Autowired
    private I0ItecZooKeeperServiceProvider i0ItecZooKeeperServiceProvider;

    /**
     * 监听事件
     */
    @Test
    @Async
    public void subscribeChildChanges() {
        long begin = System.currentTimeMillis();
        i0ItecZooKeeperServiceProvider.subscribeChildChanges("/config/test", this);
        for (int i = 0; i < 10; i++) {
            i0ItecZooKeeperServiceProvider.put("/config/test", "text" + i);
        }
        long end = System.currentTimeMillis();
//       log.debug(((end - begin) / 1000) + "秒");
//        Thread.sleep(100000);
    }

    /**
     * 回调处理
     */
    @Override
    public void callback(List<String> childs) {
//       log.debug("===================================" + childs.toString());
//       log.debug(childs.size());
    }
}