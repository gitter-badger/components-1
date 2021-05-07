/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Platforms.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.enums;

/**
 * @author hiylo
 * @date
 */
public enum Platforms {
    /**
     * 通用
     */
    ALL(0),
    /**
     * 微信
     */
    WECHAT(1),
    /**
     * ios
     */
    APP_IOS(2),
    /**
     * android
     */
    APP_ANDROID(3),
    /**
     * android 和 ios
     */
    APP(4);

    private Integer type;

    Platforms(int type) {
        this.type = type;
    }

    public Platforms getPlatforms(int type) {
        if (type < 0) {
            return null;
        }
        for (Platforms temp : Platforms.values()) {
            if (temp.type() == type) {
                return temp;
            }
        }
        return null;
    }

    public int type() {
        return type;
    }
}
