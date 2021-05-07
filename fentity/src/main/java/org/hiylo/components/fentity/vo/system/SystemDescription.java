/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : SystemDescription.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.system;

public class SystemDescription {
    private String servcerName;
    private String serverArch;
    private String serverVersion;
    private String javaVersion;
    private String javaVendor;
    private String javaVendorUrl;
    private String javaHome;
    private String javaVmVersion;
    private String javaVmVendor;
    private String javaVmName;
    private String javaTmpDir;

    public String getServcerName() {
        return servcerName;
    }

    public SystemDescription setServcerName(String servcerName) {
        this.servcerName = servcerName;
        return this;
    }

    public String getServerArch() {
        return serverArch;
    }

    public SystemDescription setServerArch(String serverArch) {
        this.serverArch = serverArch;
        return this;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public SystemDescription setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
        return this;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public SystemDescription setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
        return this;
    }

    public String getJavaVendor() {
        return javaVendor;
    }

    public SystemDescription setJavaVendor(String javaVendor) {
        this.javaVendor = javaVendor;
        return this;
    }

    public String getJavaVendorUrl() {
        return javaVendorUrl;
    }

    public SystemDescription setJavaVendorUrl(String javaVendorUrl) {
        this.javaVendorUrl = javaVendorUrl;
        return this;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public SystemDescription setJavaHome(String javaHome) {
        this.javaHome = javaHome;
        return this;
    }

    public String getJavaVmVersion() {
        return javaVmVersion;
    }

    public SystemDescription setJavaVmVersion(String javaVmVersion) {
        this.javaVmVersion = javaVmVersion;
        return this;
    }

    public String getJavaVmVendor() {
        return javaVmVendor;
    }

    public SystemDescription setJavaVmVendor(String javaVmVendor) {
        this.javaVmVendor = javaVmVendor;
        return this;
    }

    public String getJavaVmName() {
        return javaVmName;
    }

    public SystemDescription setJavaVmName(String javaVmName) {
        this.javaVmName = javaVmName;
        return this;
    }

    public String getJavaTmpDir() {
        return javaTmpDir;
    }

    public SystemDescription setJavaTmpDir(String javaTmpDir) {
        this.javaTmpDir = javaTmpDir;
        return this;
    }

    @Override
    public String toString() {
        return "SystemDescription{" +
                "servcerName='" + servcerName + '\'' +
                ", serverArch='" + serverArch + '\'' +
                ", serverVersion='" + serverVersion + '\'' +
                ", javaVersion='" + javaVersion + '\'' +
                ", javaVendor='" + javaVendor + '\'' +
                ", javaVendorUrl='" + javaVendorUrl + '\'' +
                ", javaHome='" + javaHome + '\'' +
                ", javaVmVersion='" + javaVmVersion + '\'' +
                ", javaVmVendor='" + javaVmVendor + '\'' +
                ", javaVmName='" + javaVmName + '\'' +
                ", javaTmpDir='" + javaTmpDir + '\'' +
                '}';
    }
}
