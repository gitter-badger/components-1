/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : VoiceMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.resp;


public class VoiceMessage extends BaseMessage {
    private Voice Voice;

    public Voice getVoice() {
        return this.Voice;
    }

    public void setVoice(Voice voice) {
        this.Voice = voice;
    }
}
