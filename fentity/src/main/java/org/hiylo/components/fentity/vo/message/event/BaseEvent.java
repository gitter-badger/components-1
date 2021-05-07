/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BaseEvent.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hiylo
 * @date 2019年10月8日 19:14:11
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BaseEvent {
    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String event;
}
