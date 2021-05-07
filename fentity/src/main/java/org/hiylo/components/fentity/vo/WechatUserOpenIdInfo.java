/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : WechatUserOpenIdInfo.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author hiylo
 * @date 2020年1月26日 22:08:25
 */
@Data
public class WechatUserOpenIdInfo {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private int expiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
    private String openid;
    private String scope;
}
