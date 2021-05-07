///*
// * Copyright (c)  2018 Hiylo Org. All rights reserved
// * Project: components
// * File: ChineseToPinyin.java
// * Data: 11/24/18 2:44 PM
// * Author: hiylo
// */
//package org.hiylo.components.commons.utils;
//
//import net.sourceforge.pinyin4j.PinyinHelper;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * @author 朱玺
// * @ClassName: ChineseToPinyin
// * @Description: 中文转拼音
// * @date 2016年12月2日上午 11:45:39
// */
//public class ChineseToPinyin {
//    private final static String DEFAULT_ENCODING = "UTF-8";
//
//    /**
//     * 将汉字转换为全拼
//     *
//     * @param src 需要转换的汉字
//     * @return 转换之后的拼音
//     */
//    public static String getPingYin(String src) {
//
//        char[] t1 = null;
//        t1 = src.toCharArray();
//        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
//        String[] t2;
//        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
//        StringBuffer t4 = new StringBuffer();
//        int t0 = t1.length;
//        try {
//
//            for (int i = 0; i < t0; i++) {
//                // 判断是否为汉字字符
//                if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
//                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
//                    t4.append(t2[0]);
//                } else {
//                    t4.append(Character.toString(t1[i]));
//                }
//            }
//            return t4.toString();
//        } catch (BadHanyuPinyinOutputFormatCombination e1) {
//            e1.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 返回中文的首字母
//     *
//     * @param str 需要转换的汉字
//     * @return 转换后的首字母
//     */
//    public static String getPinYinHeadChar(String str) {
//
//        StringBuffer convert = new StringBuffer();
//        for (int j = 0; j < str.length(); j++) {
//            char word = str.charAt(j);
//            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
//            if (Objects.nonNull(pinyinArray)) {
//                convert.append(pinyinArray[0].charAt(0));
//            } else {
//                convert.append(word);
//            }
//        }
//        return convert.toString().substring(0, 1);
//    }
//
//    /**
//     * 将字符串转移为ASCII码, 默认UTF-8
//     *
//     * @param cnStr 需要转换的中文
//     * @return 转换后的ASCII码
//     */
//    public static String getCnASCII(String cnStr) {
//        StringBuffer strBuf = new StringBuffer();
//        byte[] bGBK = new byte[0];
//        try {
//            bGBK = cnStr.getBytes(DEFAULT_ENCODING);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < bGBK.length; i++) {
//            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
//        }
//        return strBuf.toString();
//    }
//
//    /**
//     * 将字符串转移为ASCII码
//     *
//     * @param cnStr 需要转换的中文
//     * @return 转换后的ASCII码
//     */
//    public static String getCnASCII(String cnStr, String charset) {
//        StringBuffer strBuf = new StringBuffer();
//        byte[] bGBK = new byte[0];
//        try {
//            bGBK = cnStr.getBytes(charset);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < bGBK.length; i++) {
//            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
//        }
//        return strBuf.toString();
//    }
//}