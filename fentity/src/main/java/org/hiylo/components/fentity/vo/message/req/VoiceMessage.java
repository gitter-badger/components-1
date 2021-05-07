/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : VoiceMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.req;

public class VoiceMessage extends BaseMessage {
    private String MediaId;
    private String Format;
    private String Recognition;

    public String getMediaId() {
        return this.MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getFormat() {
        return this.Format;
    }

    public void setFormat(String format) {
        this.Format = format;
    }

    public String getRecognition() {
        return this.Recognition;
    }

    public void setRecognition(String recognition) {
        this.Recognition = recognition;
    }
}