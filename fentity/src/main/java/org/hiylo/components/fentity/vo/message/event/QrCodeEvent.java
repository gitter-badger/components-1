/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : QrCodeEvent.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.event;

public class QrCodeEvent extends BaseEvent {
    private String EventKey;
    private String Ticket;

    public String getEventKey() {
        return this.EventKey;
    }

    public void setEventKey(String eventKey) {
        this.EventKey = eventKey;
    }

    public String getTicket() {
        return this.Ticket;
    }

    public void setTicket(String ticket) {
        this.Ticket = ticket;
    }
}
