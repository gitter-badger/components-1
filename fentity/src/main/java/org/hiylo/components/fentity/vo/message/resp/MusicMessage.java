/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : MusicMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.resp;


public class MusicMessage extends BaseMessage {
    private Music Music;

    public Music getMusic() {
        return this.Music;
    }

    public void setMusic(Music music) {
        this.Music = music;
    }
}
