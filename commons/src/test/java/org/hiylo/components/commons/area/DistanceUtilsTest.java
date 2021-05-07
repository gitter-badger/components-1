/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : DistanceUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.area;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DistanceUtilsTest {
    private Gis gis = new Gis();
    private DistanceUtils distanceUtils = new DistanceUtils();

    @Test
    public void getDistanceWithSuffix() {
//        Point point1 = gis.createPoint(106.486654, 29.490295);
//        Point point2 = gis.createPoint(106.581515, 29.615467);
        String distanceWithSuffix = distanceUtils.getDistanceWithSuffix(106.486654, 29.490295, 106.581515, 29.615467);
        log.debug(distanceWithSuffix);
    }

    @Test
    public void getDistance() {
        log.debug(String.valueOf(distanceUtils.getDistance(29.615467, 106.581515, 29.490295, 106.486654))); //16670.90
    }


}