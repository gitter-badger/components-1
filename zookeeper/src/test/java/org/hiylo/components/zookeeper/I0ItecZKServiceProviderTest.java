/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : I0ItecZKServiceProviderTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Zookeeper 基于Spring context的功能测试
 * 
 * @author Hsi Chu
 * @date 2021年5月6日 12:04:40
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZookeeperApplicationTester.class)
public class I0ItecZKServiceProviderTest {
    @Autowired
    private I0ItecZooKeeperServiceProvider i0ItecZooKeeperServiceProvider;

    /**
     * 测试put
     */
    @Test
    public void put() {
        if (i0ItecZooKeeperServiceProvider.get("/lock/123456789").isEmpty()) {
            i0ItecZooKeeperServiceProvider.put("/lock/123456789", "1");
        } else {
            log.debug("锁住了");
        }


//        i0ItecZooKeeperServiceProvider.put("/config/test1", "text1");
//        i0ItecZooKeeperServiceProvider.put("/config/test2", "text2");
//        i0ItecZooKeeperServiceProvider.put("/config/test3", "text3");
//        i0ItecZooKeeperServiceProvider.put("/config", "text4");
//        i0ItecZooKeeperServiceProvider.put("/config", "text5");
//        i0ItecZooKeeperServiceProvider.put("/config", "text6");
//        i0ItecZooKeeperServiceProvider.put("/config", "text7");
//        i0ItecZooKeeperServiceProvider.put("/config", "text8");
//        i0ItecZooKeeperServiceProvider.put("/config/worker/sequence", "1");
//       log.debug(i0ItecZooKeeperServiceProvider.get("/config/worker/sequence"));
////        i0ItecZooKeeperServiceProvider.resetZookeeper("/config");
    }

    /**
     * 测试get
     */
    @Test
    public void get() {
//        i0ItecZooKeeperServiceProvider.put("/hbase/meta-region-server", "");
        log.debug(String.valueOf(i0ItecZooKeeperServiceProvider.get("/hbase/master")));
    }

    /**
     * 测试reset
     */
//    @Test
//    public void reset() {
//        i0ItecZooKeeperServiceProvider.resetZookeeper("/config");
//    }
}