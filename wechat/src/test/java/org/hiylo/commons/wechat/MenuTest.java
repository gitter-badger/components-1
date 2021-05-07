///*
// * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
// * Project : components
// * File : MenuTest.java
// * Date : 7/22/20, 12:51 AM
// * Author : Hsi Chu
// * Contact : hiylo@live.com
// */
//
//package org.hiylo.commons.wechat;
//
//import lombok.extern.slf4j.Slf4j;
////import org.hiylo.components.commons.utils.HttpClient;
////import org.hiylo.components.wechat.MenuManager;
//import org.hiylo.components.commons.utils.HttpClient;
//import org.hiylo.components.wechat.MenuManager;
//import org.hiylo.components.wechat.WechatApplicationTester;
//import org.hiylo.components.wechat.user.WechatUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by hiylo on 2/13/2017.
// */
//@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = WechatApplicationTester.class)
//public class MenuTest {
//    @Autowired
//    private MenuManager menuManager;
//    @Autowired
//    private WechatUtils wechatUtils;
//
//
//    @Test
//    public void getMenu() {
//        String serviceToken = wechatUtils.getServiceToken().getAccess_token();
//        System.out.println(serviceToken);
//        String menu = menuManager.getMenu(serviceToken);
//        System.out.println(menu);
//        menu = "{\n" +
//                "        \"button\": [\n" +
//                "            {\n" +
//                "                \"type\": \"view\",\n" +
//                "                \"name\": \"快速下单\",\n" +
//                "                \"url\": \"http:\\/\\/wechat.epai.biz\\/\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"type\": \"miniprogram\",\n" +
//                "                \"name\": \"小渔接龙\",\n" +
//                "                \"appid\": \"wx1ecfa8a408dbe2d7\",\n" +
//                "                \"pagepath\": \"pages\\/fabu\\/fabu\",\n" +
//                "                \"url\": \"http:\\/\\/wechat.epai.biz\\/\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"name\": \"加入我们\",\n" +
//                "                \"sub_button\": [\n" +
//                "                    {\n" +
//                "                        \"type\": \"view\",\n" +
//                "                        \"name\": \"下载APP\",\n" +
//                "                        \"url\": \"https:\\/\\/www.epaikj.com\\/download\"\n" +
//                "                    },\n" +
//                "                    {\n" +
//                "                        \"type\": \"view\",\n" +
//                "                        \"name\": \"公司简介\",\n" +
//                "                        \"url\": \"https:\\/\\/www.epaikj.com\\/company-introduction.html\"\n" +
//                "                    },\n" +
//                "                    {\n" +
//                "                        \"type\": \"view\",\n" +
//                "                        \"name\": \"历史文章\",\n" +
//                "                        \"url\": \"https:\\/\\/mp.weixin.qq.com\\/mp\\/homepage?__biz=MzIxMjI2MTU0OA%3D%3D&hid=2&sn=f8655c571d6324f49dfbedaf753e6d4c&scene=18\"\n" +
//                "                    },\n" +
//                "                    {\n" +
//                "                        \"type\": \"view\",\n" +
//                "                        \"name\": \"下单指引\",\n" +
//                "                        \"url\": \"https:\\/\\/static.epaikj.com\\/h5\\/html\\/order-flow.html\"\n" +
//                "                    }\n" +
//                "                ]\n" +
//                "            }\n" +
//                "        ]\n" +
//                "    }";
//        System.out.println(menu);
//        HttpClient httpClient = new HttpClient();
//        String result = httpClient.httpsRequest("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + serviceToken, "POST", menu);
//        System.out.println(result);
//    }
//}
