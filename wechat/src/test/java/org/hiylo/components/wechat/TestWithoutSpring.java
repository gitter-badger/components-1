///*
// * Copyright (c)  2019 Hiylo Org. All rights reserved
// * Project: components
// * File: TestWithoutSpring.java
// * Data: 1/11/19 1:07 PM
// * Author: hiylo
// */
//
//package org.hiylo.components.wechat;
//
//import org.hiylo.components.exceptions.PaymentException;
//import org.hiylo.components.wechat.config.WechatAppPayConfig;
//import org.hiylo.components.wechat.pay.Topay;
//import org.hiylo.components.wechat.pay.Transfers;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
//public class TestWithoutSpring {
//    private WechatAppPayConfig config = new WechatAppPayConfig("", "", "", "");
//    //    private WechatAppPayConfig config = new WechatAppPayConfig("config.properties");
//    private Transfers transfers = new Transfers(config);
//    private Topay topay = new Topay(config);
//
//    public TestWithoutSpring() throws IOException {
//    }
//
//    @Test
//    public void getPackage() throws PaymentException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
//       log.debug(topay.getPackage("商品名称", "1111111111111111", 10, "http://baidu.com", "APP", "1.1.1.1", "", ""));
//    }
//
//    @Test
//    public void transfersToBalance() {
//        try {
//            transfers.transferToBalance("1111111", "", "12321321", "2312312",
//                    "32132131", "3213123");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void transfersToBank() {
//        transfers.transferToBankCard("1111111", "朱玺", "100", "2312312", "172.17.0.1",
//                "1002", "2543534545345443", "测试");
//    }
//
//    @Test
//    public void getPublicKey() {
//        try {
//           log.debug(transfers.getPublicKey());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
