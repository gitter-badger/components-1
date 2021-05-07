/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ImageMessage.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.message.resp;

public class ImageMessage extends BaseMessage {
    private Image Image;

    public Image getImage() {
        return this.Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }
}
