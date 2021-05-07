/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AccessToken.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.aliyun.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessToken implements Serializable {
    private static final long serialVersionUID = -4770111582913507854L;
    private String accessKey;
    private String accessSecret;
}
