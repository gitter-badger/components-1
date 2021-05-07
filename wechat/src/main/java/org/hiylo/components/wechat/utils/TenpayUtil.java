/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TenpayUtil.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TenpayUtil {
    private static Object Server;
    private static String QRfromGoogle;

    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static int toInt(Object obj) {
        int a = 0;
        try {
            if (Objects.nonNull(obj)) {
                a = Integer.parseInt(obj.toString());
            }
        } catch (Exception localException) {
        }
        return a;
    }

    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }

    public static String URLencode(String content) {
        String URLencode = replace(Server.equals(content), "+", "%20");

        return URLencode;
    }

    private static String replace(boolean equals, String string, String string2) {
        return null;
    }

    public static long getUnixTime(Date date) {
        if (date == null) {
            return 0L;
        }

        return date.getTime() / 1000L;
    }

    public static String QRfromGoogle(String chl) {
        int widhtHeight = 300;
        String EC_level = "L";
        int margin = 0;

        chl = URLencode(chl);

        String QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight
                + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;

        return QRfromGoogle;
    }

    public static String date2String(Date date, String formatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        return sdf.format(date);
    }
}