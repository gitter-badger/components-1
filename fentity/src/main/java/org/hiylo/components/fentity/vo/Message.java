/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Message.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class Message {
    private String messageId;
    private String resultCode;
    private Content messageContent;
    private int type;
    private String serverId;

    public Message() {
    }

    public Message(String messageId, String resultCode, Content messageContent, int type, String serverId) {
        this.messageId = messageId;
        this.resultCode = resultCode;
        this.messageContent = messageContent;
        this.type = type;
        this.serverId = serverId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Content getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(Content messageContent) {
        this.messageContent = messageContent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", messageContent=" + messageContent +
                ", type=" + type +
                '}';
    }

    public static class Content {
        private int type;
        private Long from;
        private Long to;
        private String content;
        private Object object;

        public Content() {
        }

        public Content(int type, Long from, Long to, String content, Object object) {
            this.type = type;
            this.from = from;
            this.to = to;
            this.content = content;
            this.object = object;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Long getFrom() {
            return from;
        }

        public void setFrom(Long from) {
            this.from = from;
        }

        public Long getTo() {
            return to;
        }

        public void setTo(Long to) {
            this.to = to;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

    }
}
