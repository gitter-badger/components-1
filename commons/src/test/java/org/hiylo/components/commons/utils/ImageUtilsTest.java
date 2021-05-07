/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ImageUtilsTest.java
 * Date : 2020/10/18 下午1:10
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtilsTest {
    ImageUtils imageUtils = new ImageUtils();

    @Test
    public void testGetImageAspectRatio() throws IOException {
        System.out.println(imageUtils.getAspectRatio(new FileInputStream(ImageUtilsTest.class.getClassLoader()
                .getResource("20200904093853.jpg").getFile())));
    }

    @Test
    public void testResize() throws IOException {
        System.out.println(ImageUtilsTest.class.getClassLoader()
                .getResource("").getFile() + "new.jpg");
        imageUtils.resize(new FileInputStream(ImageUtilsTest.class.getClassLoader()
                        .getResource("20200904093853.jpg").getFile()),
                new FileOutputStream(new File(ImageUtilsTest.class.getClassLoader()
                        .getResource("").getFile() + "/new.jpg")), 200, 300, true
        );
    }
}