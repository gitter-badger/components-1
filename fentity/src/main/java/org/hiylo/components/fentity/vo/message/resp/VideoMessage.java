/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : VideoMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.resp;


public class VideoMessage extends BaseMessage {
    private Video Video;

    public Video getVideo() {
        return this.Video;
    }

    public void setVideo(Video video) {
        this.Video = video;
    }
}
