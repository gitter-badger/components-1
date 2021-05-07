/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : I0ItecZooKeeperServiceProviderSubscribe.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.zookeeper;

import java.util.List;

/**
 * Zookeeper 监听接口, 实现此类用来接收Zookeeper回调事件
 * @author hiylo
 * @date 2018年8月11日12:25:13
 */
public interface I0ItecZooKeeperServiceProviderSubscribe {
    /**
     * 监听事件的回调方法
     *
     * @param childs 监听节点的子节点
     */
    void callback(List<String> childs);
}
