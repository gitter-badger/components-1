/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : I0ItecZooKeeperServiceProvider.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Zookeeper 工具类
 * 
 * @author hiylo
 * @date 2018年8月11日12:22:29
 */
public class I0ItecZooKeeperServiceProvider {
    private static ZkClient zkClient;
    private static Logger log = LoggerFactory.getLogger(I0ItecZooKeeperServiceProvider.class);
    /**
     * Zookeeper服务地址 可以是多个地址 结构类似 "zookeeper:2181", "zookeeper1:2181"
     */
    @Value("${zookeeper.locations}")
    public String zookeeperServerLocation;

    private I0ItecZooKeeperServiceProvider() {

    }

    /**
     * 非Spring方式启动时调用此构造方法
     * 
     * @param zookeeperServerLocation 192.168.1.1, 192.168.1.2
     */
    public I0ItecZooKeeperServiceProvider(String zookeeperServerLocation) {
        this.zookeeperServerLocation = zookeeperServerLocation;
        zkClient = new ZkClient(zookeeperServerLocation);
    }

    /**
     * Spring 方式启动是的初始化方法
     */
    @PostConstruct
    private void init() {
        zkClient = new ZkClient(zookeeperServerLocation);
    }

    /**
     * 添加值到Zookeeper
     * 
     * @param path  要添加到的Path, 类似于Redis中的Key
     * @param value 要添加的值
     */
    public void put(final String path, final String value) {
        boolean serviceExists = zkClient.exists(path);
        if (!serviceExists) {
            this.createPath(path);
        }
        if (!zkClient.exists(path + "/" + value)) {
            zkClient.createEphemeral(path + "/" + value);
        } else {
            zkClient.delete(path + "/" + value);
            this.put(path, value);
        }
    }

    /**
     * 获取Zookeeper中的值
     * 
     * @param path 获取路径, 类似Redis中的Key
     * @return 获取到的值列表
     */
    public List<String> get(final String path) {
        boolean serviceExists = zkClient.exists(path);
        // 如果服务提供者信息存在,则获取服务提供者列表
        if (serviceExists) {
            return zkClient.getChildren(path);
        } else { // 若不存在则创建路径, 同时返回空列表
            this.createPath(path);
            return Collections.emptyList();
        }
    }

    /**
     * 清空某个路径下的所有值, 包括子路径下的所有值
     * 
     * @param path 要清空的路径
     */
    public void resetZookeeper(String path) {
        log.debug(path);
        try {
            ZooKeeper zookeeper = new ZooKeeper(zookeeperServerLocation, 300000, null);
            List<String> names = zookeeper.getChildren(path, null);
            for (String name : names) {
                String tempPath = "";
                if ("/".equals(path)) {
                    tempPath = path + name;
                } else {
                    tempPath = path + "/" + name;
                }
                this.resetZookeeper(tempPath);
                zookeeper.delete(tempPath, -1);
            }
        } catch (IOException | KeeperException e) {
            log.debug("resetZookeeper", e);
        } catch (InterruptedException e) {
            log.debug("Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 订阅Zookeeper事件
     * 
     * @param path 要订阅改变的路径
     * @param obj 实现{@link I0ItecZooKeeperServiceProviderSubscribe}接口的类, 用来处理回调内容
     */
    public void subscribeChildChanges(final String path, final Object obj) {
        if (!(obj instanceof I0ItecZooKeeperServiceProviderSubscribe)) {
            throw new RuntimeException("Not a subscribe");
        }
        if (zkClient == null) {
            zkClient = new ZkClient(zookeeperServerLocation);
        }
        boolean serviceExists = zkClient.exists(path);
        if (!serviceExists) {
            this.createPath(path);
        }
        zkClient.subscribeChildChanges(path, (parentPath, currentChilds) -> obj.getClass()
                .getMethod("callback", List.class).invoke(obj, currentChilds));

    }

    /**
     * 创建Zookeeper路径
     * 
     * @param path 要创建的路径
     */
    private void createPath(String path) {
        String[] paths = path.split("/");
        String ps = "";
        for (String p : paths) {
            if (StringUtils.hasText(p)) {
                ps += "/" + p;
                boolean exists = zkClient.exists(ps);
                if (!exists) {
                    zkClient.createPersistent(ps);
                }
            }
        }
    }
}
