/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : QrCode.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class QrCode {

    public static byte[] generateQRCode(String content) throws WriterException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String format = "png";
        Map<EncodeHintType, Object> hints = new HashMap(0, 0.75F);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 生成矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, 320, 320, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
        byte[] result = outputStream.toByteArray();
        outputStream.close();
        return result;
    }

    public static void writeQRCode(String content, OutputStream outputStream) throws WriterException, IOException {
        String format = "png";
        Map<EncodeHintType, Object> hints = new HashMap(0, 0.75F);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 生成矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, 320, 320, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
    }

//    public static void main(String[] args) {
//        FileOutputStream output = null;
//        try {
//            String fileName = "D:/p.png";
//            byte[] result = QrCode.generateQRCode("你好啊");
//           log.debug(result.length);
//            output = new FileOutputStream("D:/b.png");
//            output.write(result);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                output.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
