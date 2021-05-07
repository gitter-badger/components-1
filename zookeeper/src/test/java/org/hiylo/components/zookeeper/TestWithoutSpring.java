/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TestWithoutSpring.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * Zookeeper 非Spring context 的功能测试
 */
@Slf4j
public class TestWithoutSpring implements I0ItecZooKeeperServiceProviderSubscribe {
    private I0ItecZooKeeperServiceProvider i0ItecZooKeeperServiceProvider = new I0ItecZooKeeperServiceProvider("127.0.0.1:2181");

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
        log.debug(((end - begin) / 1000) + "秒");
//        Thread.sleep(100000);
    }

    /**
     * 测试put方法
     */
    @Test
    public void put() {
        i0ItecZooKeeperServiceProvider.put("/config/test1", "text1");
        i0ItecZooKeeperServiceProvider.put("/config/test2", "text2");
        i0ItecZooKeeperServiceProvider.put("/config/test3", "text3");
        i0ItecZooKeeperServiceProvider.put("/config", "text4");
        i0ItecZooKeeperServiceProvider.put("/config", "text5");
        i0ItecZooKeeperServiceProvider.put("/config", "text6");
        i0ItecZooKeeperServiceProvider.put("/config", "text7");
        i0ItecZooKeeperServiceProvider.put("/config", "text8");
        i0ItecZooKeeperServiceProvider.put("/config/worker/sequence", "1");
        log.debug(String.valueOf(i0ItecZooKeeperServiceProvider.get("/config/worker/sequence")));
//        i0ItecZooKeeperServiceProvider.resetZookeeper("/config");
    }

    /**
     * 测试get方法
     */
    @Test
    public void get() {
        i0ItecZooKeeperServiceProvider.put("/config/worker/sequence", "1");
        log.debug(String.valueOf(i0ItecZooKeeperServiceProvider.get("/config/worker/sequence")));
    }

    /**
     * 事件回调
     */
    @Override
    public void callback(List<String> childs) {
        log.debug("===================================" + childs.toString());
        log.debug(String.valueOf(childs.size()));
    }
}
