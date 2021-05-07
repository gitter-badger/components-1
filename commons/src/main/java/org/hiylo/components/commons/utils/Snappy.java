/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Snappy.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 用以解压或者压缩Snappy格式文件
 *
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
@Component
public class Snappy {
    private final static String DEFAULT_ENCODING = "UTF-8";

    /**
     * 将Snappy格式的文件解压返回文件内容
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String uncompress(String file) throws IOException {
        RandomAccessFile randomFile = new RandomAccessFile(file, "r");
        try {
            int fileLength = (int) randomFile.length();
            randomFile.seek(0);
            byte[] bytes = new byte[fileLength];
            int byteread = randomFile.read(bytes);
            if (byteread != -1) {
                byte[] uncompressed = org.xerial.snappy.Snappy.uncompress(bytes);
                String result = new String(uncompressed, "UTF-8");
                randomFile.close();
                return result;
            } else {
                return null;
            }
        } finally {
            randomFile.close();
        }
    }

    /**
     * 将字符串以Snappy格式压缩然后输出到指定文件中, 默认UTF-8
     *
     * @param content
     * @param filename
     * @return
     * @throws IOException
     */
    public boolean compress(String content, String filename) throws IOException {
        File file = new File(filename);
        if (file.getParentFile().exists() && file.getParentFile().isDirectory()) {
            try {
                FileUtils.writeByteArrayToFile(new File(filename), content.getBytes(DEFAULT_ENCODING));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            throw new IOException("Directory not exosts");
        }
    }

    /**
     * 将字符串以Snappy格式压缩然后输出到指定文件中
     *
     * @param content
     * @param filename
     * @return
     * @throws IOException
     */
    public boolean compress(String content, String filename, String charset) throws IOException {
        File file = new File(filename);
        if (file.getParentFile().exists() && file.getParentFile().isDirectory()) {
            try {
                FileUtils.writeByteArrayToFile(new File(filename), content.getBytes(charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            throw new IOException("Directory not exosts");
        }
    }
}
