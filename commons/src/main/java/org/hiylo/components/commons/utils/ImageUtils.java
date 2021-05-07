/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ImageUtils.java
 * Date : 2020/10/18 上午10:57
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图片工具
 *
 * @author hiylo
 * @date 2020年10月18日 11:28:16
 */
public class ImageUtils {

    /**
     * 创建Resize之后的Thumbnails
     *
     * @param inputStream 输入流
     * @param newWidth    新宽度
     * @param newHeight   新高度
     * @param forceResize 强制装换
     * @return Thumbnails对象
     */
    private Thumbnails.Builder<? extends InputStream> buildThumbnails(InputStream inputStream, int newWidth,
                                                                      int newHeight, boolean forceResize) {
        Thumbnails.Builder<? extends InputStream> of = Thumbnails.of(inputStream);
        if (forceResize) {
            of = of.forceSize(newWidth, newHeight);
        } else {
            of = of.width(newWidth).height(newHeight);
        }
        return of;
    }

    /**
     * 改变图片分辨率
     *
     * @param inputStream  输入流
     * @param newWidth     新的宽
     * @param newHeight    新的高
     * @param forceResize  是否强制宽高
     * @return 输入流
     * @throws IOException 文件输出异常
     */
    public InputStream resize(InputStream inputStream, int newWidth, int newHeight,
                       boolean forceResize) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Thumbnails.Builder<? extends InputStream> of = this.buildThumbnails(inputStream, newWidth, newHeight, forceResize);
        ImageIO.write(of.asBufferedImage(), "png", os);
        InputStream input = new ByteArrayInputStream(os.toByteArray());
        return input;
    }

    /**
     * 改变图片分辨率
     *
     * @param inputStream  输入流
     * @param outputStream 输出流
     * @param newWidth     新的宽
     * @param newHeight    新的高
     * @param forceResize  是否强制宽高
     * @throws IOException 文件输出异常
     */
    public void resize(InputStream inputStream, OutputStream outputStream, int newWidth, int newHeight,
                       boolean forceResize) throws IOException {
        Thumbnails.Builder<? extends InputStream> of = this.buildThumbnails(inputStream, newWidth, newHeight, forceResize);
        of.toOutputStream(outputStream);
    }

    /**
     * 获取图片的宽高比
     *
     * @param inputStream 输入流
     * @return 宽高比例
     * @throws IOException 文件异常
     */
    public int getAspectRatio(InputStream inputStream) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        return bufferedImage.getWidth() / bufferedImage.getHeight();
    }
}
