/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Zip.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.zip;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
@Slf4j
public class Zip {
    public Zip() {
    }

//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        Zip book = new Zip();
//        try {
//            book.compress("C:\\Users\\Gaowen\\Desktop\\ZipTestCompressing.zip",
//                    new File("C:\\Users\\Gaowen\\Documents\\Tencent Files"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void compress(String outputFolder, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputFolder));
        BufferedOutputStream bo = new BufferedOutputStream(out);
        compress(out, inputFile, inputFile.getName(), bo);
        bo.close();
        out.close();
    }

    private void compress(ZipOutputStream out, File f, String base, BufferedOutputStream bo) {
        FileInputStream in = null;
        BufferedInputStream bi = null;
        try {
            if (f.isDirectory()) {
                File[] fl = f.listFiles();
                // 创建zip压缩进入点base
                if (fl == null || fl.length == 0) {
                    out.putNextEntry(new ZipEntry(base + "/"));
                }
                // 递归遍历子文件夹
                for (int i = 0; Objects.nonNull(fl) && i < fl.length; i++) {
                    compress(out, fl[i], base + "/" + fl[i].getName(), bo);
                }
            } else {
                // 创建zip压缩进入点base
                out.putNextEntry(new ZipEntry(base));
                in = new FileInputStream(f);
                bi = new BufferedInputStream(in);
                int b;
                while ((b = bi.read()) != -1) {
                    // 将字节流写入当前zip目录
                    bo.write(b);
                }
            }
        } catch (IOException e) {
            log.error("压缩", e);
        } finally {
            try {
                // 输入流关闭
                if (Objects.nonNull(bi)) {
                    bi.close();
                }
                if (Objects.nonNull(in)) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("压缩", e);
            }
        }
    }

    public void uncompress(String inputFile, String outputFolder) {
        ZipInputStream zipInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            // 输入源zip路径
            zipInputStream = new ZipInputStream(new FileInputStream(inputFile));
            bufferedInputStream = new BufferedInputStream(zipInputStream);
            // 输出路径（文件夹目录）
            String parent = outputFolder;
            File outFile;
            ZipEntry entry;
            while (Objects.nonNull(entry = zipInputStream.getNextEntry()) && !entry.isDirectory()) {
                FileOutputStream fileOutputStream = null;
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    outFile = new File(parent, entry.getName());
                    if (!outFile.exists()) {
                        if (!(new File(outFile.getParent())).mkdirs()) {
                            return;
                        }
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    int b;
                    while ((b = bufferedInputStream.read()) != -1) {
                        bufferedOutputStream.write(b);
                    }
                } catch (IOException e) {
                    log.error("解压", e);
                } finally {
                    if (Objects.nonNull(bufferedOutputStream)) {
                        bufferedOutputStream.close();
                    }
                    if (Objects.nonNull(fileOutputStream)) {
                        fileOutputStream.close();
                    }
                }
            }
        } catch (IOException e) {
            log.error("解压", e);
        } finally {
            try {
                if (Objects.nonNull(bufferedInputStream)) {
                    bufferedInputStream.close();
                }
                if (Objects.nonNull(zipInputStream)) {
                    zipInputStream.close();
                }
            } catch (IOException e) {
                log.error("解压", e);
            }
        }
    }
}
