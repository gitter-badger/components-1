/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : GenerateUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 生成指定条件的对象
 *
 * @author Johnny
 * @since 2016-12-05
 */
public class GenerateUtils {
    /**
     * 生成字符串型随机数
     *
     * @param length 字符串长度
     * @return 生成的随机数字符串
     */
    public static String generateStrNumber(int length) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            strBuffer.append(new Random().nextInt(10));
        }
        return strBuffer.toString();
    }

    /**
     * 生成随机字符串
     *
     * @param length 字符串长度
     * @return 生成的随机数字符串
     */
    public static String generateRandomStr(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成long型随机数
     *
     * @param length 生成long型数字长度
     * @return 当length大于1时, 返回值大于10的length-1次方,e.g. length=2,number>=10
     */
    public static long generateLongNumber(int length) {
        long number = 0;
        for (int i = 1; i <= length; i++) {
            if (i == length && length > 1) {
                int randomNum = new Random().nextInt(10);
                while (randomNum == 0) {
                    randomNum = new Random().nextInt(10);
                }
                number += randomNum;
            } else {
                number += new Random().nextInt(10) * Math.pow(10, i);
            }
        }
        return number;
    }

    /**
     * 根据收货人姓名生成加密收货人姓名
     *
     * @param consigneeName 收货人姓名
     * @return
     */
    public static String generateConsigneeName(String consigneeName) {
        if (consigneeName.length() > 1) {
            StringBuffer strBuffer = new StringBuffer();
            strBuffer.append(consigneeName, 0, 1);
            int consigneeNameLength = consigneeName.length();
            while (consigneeNameLength - 1 > 0) {
                consigneeNameLength--;
                strBuffer.append("*");
            }
            return strBuffer.toString();
        } else {
            return consigneeName + "*";
        }
    }

    /**
     * 根据用户手机号生成默认昵称
     *
     * @param phoneNumber 手机号码
     * @return 昵称
     */
    public static String nickNameByPhoneNumber(String phoneNumber) {
        return phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7);
    }

    /**
     * 根据手机号生成订单编号
     *
     * @param phoneNumber 用户手机号
     * @return
     */
    public static String orderNo(String phoneNumber) {
        //日+月+年(后两位)+时+分+秒+手机号后四位
        return new SimpleDateFormat("ddMMyyHHmmss").format(new Date()) + phoneNumber.substring(7);
    }

}
