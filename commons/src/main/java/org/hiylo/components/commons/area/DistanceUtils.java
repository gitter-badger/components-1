/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : DistanceUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.area;

import com.vividsolutions.jts.geom.Point;
import org.hiylo.components.commons.utils.NumberUtils;

/**
 * 距离工具类
 * 
 * @author hiylo
 * @date 2019年1月18日 14:17:53
 */
public class DistanceUtils {
    private static final int THOUSAND = 1000;
    private Gis gis = new Gis();

    // /**
    // * 计算两点之间的距离 (带后缀)
    // *
    // * @param start 起始点
    // * @param end 结束点
    // * @return 距离
    // */
    // public final String getDistanceWithSuffix(Point start, Point end) {
    // double distance = this.getDistance(start, end);
    // return getDistanceWithSuffix(distance);
    // }

    /**
     * 在距离(单位米)后面加上单位
     * 
     * @param meter 距离
     * @return 加上单位的距离字符串
     */
    public final String getDistanceWithSuffix(int meter) {
        if (meter / THOUSAND > 0) {
            return NumberUtils.castDoubleKeepTwoDecimalPlaces(((double) meter) / THOUSAND) + "km";
        } else {
            return meter + "m";
        }
    }

    /**
     * 计算两点之间的距离 (带后缀)
     * 
     * @param startLatitude  起始经度
     * @param startLongitude 起始纬度
     * @param endLatitude    结束经度
     * @param endLongitude   结束纬度
     * @return
     */
    public final String getDistanceWithSuffix(double startLatitude, double startLongitude, double endLatitude,
            double endLongitude) {
        // return this.getDistanceWithSuffix(gis.createPoint(startX, startY),
        // gis.createPoint(endX, endY));
        int distance = this.getDistance(startLatitude, startLongitude, endLatitude, endLongitude);
        return getDistanceWithSuffix(distance);
    }

    /**
     * 计算距离 (单位米)
     * 
     * @param startLatitude  起始经度
     * @param startLongitude 起始纬度
     * @param endLatitude    结束经度
     * @param endLongitude   结束纬度
     * @return
     */
    public final int getDistance(double startLatitude, double startLongitude, double endLatitude, double endLongitude) {
        return (int) (Math.round(2
                * Math.asin(Math.sqrt(Math
                        .pow(Math.sin((startLatitude * Math.PI / 180.00 - endLatitude * Math.PI / 180.00) / 2), 2)
                        + Math.cos(startLatitude) * Math.cos(endLatitude)
                                * Math.pow(Math.sin(
                                        (startLongitude * Math.PI / 180.00 - endLongitude * Math.PI / 180.00) / 2), 2)))
                * 6378137.0 * 10000d) / 10000d);
    }

    /**
     * 将角度换算成弧度
     * @param degrees 角度
     * @return 弧度
     */
    private Double convertDegreesToRadians(Double degrees) {
        return degrees * Math.PI / 180;
    }

    // /**
    // * 计算两点之间的距离
    // *
    // * @param start 起始点
    // * @param end 结束点
    // * @return 距离 (单位M)
    // */
    // public final double getDistance(Point start, Point end) {
    // double distance = start.distance(end);
    // return distance * THOUSAND * THOUSAND;
    // }
}
