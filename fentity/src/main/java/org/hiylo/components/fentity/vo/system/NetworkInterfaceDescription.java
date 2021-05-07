/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : NetworkInterfaceDescription.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.system;

public class NetworkInterfaceDescription {
    private String name;
    private String ip;
    private String mac;

    public String getName() {
        return name;
    }

    public NetworkInterfaceDescription setName(String name) {
        this.name = name;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public NetworkInterfaceDescription setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getMac() {
        return mac;
    }

    public NetworkInterfaceDescription setMac(String mac) {
        this.mac = mac;
        return this;
    }

    @Override
    public String toString() {
        return "NetworkInterfaceDescription{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}
