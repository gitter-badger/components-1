/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : HttpClientTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class HttpClientTest {
    @Test
    public void getEurekaApps() {
        try {
            System.out.println( new HttpClient().post("http://39.96.50.223:8761/login", new HashMap<String, String>() {{
                put("username", "Y1KzSZYpFINS");
                put("password", "2VLej2ZZkXSv");
                put("submit", "Login");
            }}, new HashMap<String, String>() {
                {
                    put("Content-Type", "application/x-www-form-urlencoded");
                    put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
                }
            }, "UTF-8"));;
            String cookie = new HttpClient().postGetHeader("http://39.96.50.223:8761/login", new HashMap<String, String>() {{
                put("username", "Y1KzSZYpFINS");
                put("password", "2VLej2ZZkXSv");
                put("submit", "Login");
            }}, new HashMap<String, String>() {
                {
                    put("Content-Type", "application/x-www-form-urlencoded");
                    put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
                }
            }, "UTF-8", "Set-Cookie");
            System.out.println("------------------" + cookie);
            System.out.println("------------------" + new HttpClient().get("http://39.96.50.223:8761/eureka/apps", null, new HashMap<String, String>() {
                {
                    put("Content-Type", "application/json");
                    put("Accept", "application/json; charset=utf-8");
                    put("Cookie", cookie.split(";")[0]);
                }
            }, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
