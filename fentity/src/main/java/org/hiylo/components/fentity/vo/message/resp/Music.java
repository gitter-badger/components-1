/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Music.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.resp;

public class Music {
    private String Title;
    private String Description;
    private String MusicUrl;
    private String HQMusicUrl;
    private String ThumbMediaId;

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getMusicUrl() {
        return this.MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return this.HQMusicUrl;
    }

    public void setHQMusicUrl(String musicUrl) {
        this.HQMusicUrl = musicUrl;
    }

    public String getThumbMediaId() {
        return this.ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.ThumbMediaId = thumbMediaId;
    }
}
