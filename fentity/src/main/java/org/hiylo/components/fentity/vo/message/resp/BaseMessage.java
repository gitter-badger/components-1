/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BaseMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BaseMessage {
    @SerializedName("ToUserName")
    private String toUserName;
    @SerializedName("FromUserName")
    private String fromUserName;
    @SerializedName("CreateTime")
    private long createTime;
    @SerializedName("MsgType")
    private String msgType;
}
