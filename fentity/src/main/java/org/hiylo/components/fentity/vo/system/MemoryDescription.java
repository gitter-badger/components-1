/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : MemoryDescription.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.system;

public class MemoryDescription {
    private Long totalMemorySize;
    private Long usedMemorySize;
    private Long availableMemorySize;
    private Long jvmTotalMemorySize;
    private Long jvmMaxMemorySize;
    private Long jvmUsedMemorySize;

    public Long getTotalMemorySize() {
        return totalMemorySize;
    }

    public MemoryDescription setTotalMemorySize(Long totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
        return this;
    }

    public Long getAvailableMemorySize() {
        return availableMemorySize;
    }

    public MemoryDescription setAvailableMemorySize(Long availableMemorySize) {
        this.availableMemorySize = availableMemorySize;
        return this;
    }

    public Long getUsedMemorySize() {
        return usedMemorySize;
    }

    public MemoryDescription setUsedMemorySize(Long usedMemorySize) {
        this.usedMemorySize = usedMemorySize;
        return this;
    }

    public Long getJvmTotalMemorySize() {
        return jvmTotalMemorySize;
    }

    public MemoryDescription setJvmTotalMemorySize(Long jvmTotalMemorySize) {
        this.jvmTotalMemorySize = jvmTotalMemorySize;
        return this;
    }

    public Long getJvmMaxMemorySize() {
        return jvmMaxMemorySize;
    }

    public MemoryDescription setJvmMaxMemorySize(Long jvmMaxMemorySize) {
        this.jvmMaxMemorySize = jvmMaxMemorySize;
        return this;
    }

    public Long getJvmUsedMemorySize() {
        return jvmUsedMemorySize;
    }

    public MemoryDescription setJvmUsedMemorySize(Long jvmUsedMemorySize) {
        this.jvmUsedMemorySize = jvmUsedMemorySize;
        return this;
    }

    @Override
    public String toString() {
        return "MemoryDescription{" +
                "totalMemorySize=" + (totalMemorySize / 1024 / 1024) + "MB" +
                ", usedMemorySize=" + (usedMemorySize / 1024 / 1024) + "MB" +
                ", availableMemorySize=" + (availableMemorySize / 1024 / 1024) + "MB" +
                ", jvmTotalMemorySize=" + (jvmTotalMemorySize / 1024 / 1024) + "MB" +
                ", jvmMaxMemorySize=" + (jvmMaxMemorySize / 1024 / 1024) + "MB" +
                ", jvmUsedMemorySize=" + (jvmUsedMemorySize / 1024 / 1024) + "MB" +
                '}';
    }
}
