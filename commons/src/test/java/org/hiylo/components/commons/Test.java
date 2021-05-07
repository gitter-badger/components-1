/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Test.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons;

import org.hiylo.components.commons.encrypttools.Encrypt;
import org.hiylo.components.commons.utils.CommonUtils;
import org.hiylo.components.commons.utils.HttpClient;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/大数据");
        System.out.println(file.getPath());
        System.out.println("f2f08be9e907de836ec0b52ee59a1168f0bc21da97b05e6822fab1c347a6c447".toUpperCase());
//        HttpClient httpClient = new HttpClient();
//        Map<String, String> headers = new HashMap<>();
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        String nonce = CommonUtils.getNonceStr();
//        headers.put("appId", "10001");
//        headers.put("timestamp", timestamp);
//        headers.put("nonce", nonce);
//        String sign = timestamp + "10001" + nonce;
//        sign = Encrypt.Md5.sign(sign, "Hx3r11WxDBjr3P6z4Jm3IQAKHAMv5xtI", "UTF-8");
//        headers.put("sign", sign);
//        Map<String, Object> params = new HashMap<>();
//        params.put("senderLatitude", 34.245158);
//        params.put("senderLongitude", 108.993049);
//        params.put("recipientLatitude", 34.244244);
//        params.put("recipientLongitude", 108.990386);
//        String result = httpClient.postJson("https://api.epai.biz/api/open/calculate", params, headers);
//        System.out.println(result);
    }
}
