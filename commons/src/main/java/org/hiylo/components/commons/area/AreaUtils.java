/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : AreaUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.area;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域工具类
 * 
 * @author hiylo
 * @date 2018年12月10日 14:08:50
 */
public class AreaUtils {
    private AreaUtils() {

    }

    /**
     * 直辖市adcode列表
     */
    private static final List<String> MUNICIPALITY_ADCODE;
    /**
     * 直辖市名称列表
     */
    private static final List<String> MUNICIPALITY_CITY;
    /**
     * 没有市辖区的市
     */
    private static final List<String> NO_MUNICIPAL_DISTRICTS_ADCODE;

    /**
     * 省会城市
     */
    private static final List<String> PROVINCIAL_CAPITAL_ADCODE;

    static {
        MUNICIPALITY_ADCODE = new ArrayList<>(4);
        MUNICIPALITY_ADCODE.add("110000");
        MUNICIPALITY_ADCODE.add("120000");
        MUNICIPALITY_ADCODE.add("310000");
        MUNICIPALITY_ADCODE.add("500000");
        MUNICIPALITY_CITY = new ArrayList<>(4);
        MUNICIPALITY_CITY.add("北京市");
        MUNICIPALITY_CITY.add("天津市");
        MUNICIPALITY_CITY.add("上海市");
        MUNICIPALITY_CITY.add("重庆市");
        NO_MUNICIPAL_DISTRICTS_ADCODE = new ArrayList<>(5);
        NO_MUNICIPAL_DISTRICTS_ADCODE.add("442000");
        NO_MUNICIPAL_DISTRICTS_ADCODE.add("441900");
        NO_MUNICIPAL_DISTRICTS_ADCODE.add("620200");
        NO_MUNICIPAL_DISTRICTS_ADCODE.add("460400");
        NO_MUNICIPAL_DISTRICTS_ADCODE.add("460300");
        PROVINCIAL_CAPITAL_ADCODE = new ArrayList<>(34);
        PROVINCIAL_CAPITAL_ADCODE.add("230100");
        PROVINCIAL_CAPITAL_ADCODE.add("130100");
        PROVINCIAL_CAPITAL_ADCODE.add("620100");
        PROVINCIAL_CAPITAL_ADCODE.add("530100");
        PROVINCIAL_CAPITAL_ADCODE.add("510100");
        PROVINCIAL_CAPITAL_ADCODE.add("220100");
        PROVINCIAL_CAPITAL_ADCODE.add("210100");
        PROVINCIAL_CAPITAL_ADCODE.add("630100");
        PROVINCIAL_CAPITAL_ADCODE.add("610100");
        PROVINCIAL_CAPITAL_ADCODE.add("410100");
        PROVINCIAL_CAPITAL_ADCODE.add("370100");
        PROVINCIAL_CAPITAL_ADCODE.add("140100");
        PROVINCIAL_CAPITAL_ADCODE.add("340100");
        PROVINCIAL_CAPITAL_ADCODE.add("420100");
        PROVINCIAL_CAPITAL_ADCODE.add("430100");
        PROVINCIAL_CAPITAL_ADCODE.add("320100");
        PROVINCIAL_CAPITAL_ADCODE.add("520100");
        PROVINCIAL_CAPITAL_ADCODE.add("450100");
        PROVINCIAL_CAPITAL_ADCODE.add("330100");
        PROVINCIAL_CAPITAL_ADCODE.add("360100");
        PROVINCIAL_CAPITAL_ADCODE.add("440100");
        PROVINCIAL_CAPITAL_ADCODE.add("350100");
        PROVINCIAL_CAPITAL_ADCODE.add("460100");
        PROVINCIAL_CAPITAL_ADCODE.add("150100");
        PROVINCIAL_CAPITAL_ADCODE.add("640100");
        PROVINCIAL_CAPITAL_ADCODE.add("650100");
        PROVINCIAL_CAPITAL_ADCODE.add("540100");
        PROVINCIAL_CAPITAL_ADCODE.add("820000");
        PROVINCIAL_CAPITAL_ADCODE.add("110000");
        PROVINCIAL_CAPITAL_ADCODE.add("310000");
        PROVINCIAL_CAPITAL_ADCODE.add("810000");
        PROVINCIAL_CAPITAL_ADCODE.add("120000");
        PROVINCIAL_CAPITAL_ADCODE.add("500000");
    }

    /**
     * 直辖市
     *
     * @param value code 或者 名字
     * @return 是不是直辖市
     */
    public static boolean isMunicipality(String value) {
        return MUNICIPALITY_ADCODE.contains(value) || MUNICIPALITY_CITY.contains(value);
    }


    /**
     * 判断是否为不设市辖区的地级市
     * 中国目前有5个不设市辖区的地级市  中山市442000 东莞市441900 嘉峪关市620200 儋州市460400 三沙市
     *
     * @param adcode adcode
     * @return 是不是直辖市
     */
    public static boolean isNoDistrictCity(String adcode) {
        return NO_MUNICIPAL_DISTRICTS_ADCODE.contains(adcode);
    }

    /**
     * 是否是省会城市
     *
     * @param adcode adcode
     * @return 是否
     */
    public static boolean isProvincialCapital(String adcode) {
        return PROVINCIAL_CAPITAL_ADCODE.contains(adcode);
    }
}
