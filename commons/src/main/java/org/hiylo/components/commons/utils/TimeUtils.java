/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TimeUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

/**
 * @author hiylo
 * @date 2019年1月19日 14:58:47
 */
public class TimeUtils {
    private static final int SECOND_OF_YEAR = 60 * 60 * 24 * 365;
    private static final int SECOND_OF_MONTH = 60 * 60 * 24 * 30;
    private static final int SECOND_OF_DAY = 60 * 60 * 24;
    private static final int SECOND_OF_HOUR = 60 * 60;
    private static final int SECOND_OF_MINUTE = 60;

    public final String parseSecond(int seconds) {
        StringBuilder result = new StringBuilder();
        if (seconds / SECOND_OF_YEAR > 0) {
            result.append(seconds / SECOND_OF_YEAR).append("年");
        }
        seconds = seconds % (SECOND_OF_YEAR);
        if (seconds / SECOND_OF_MONTH > 0) {
            result.append(seconds / SECOND_OF_MONTH).append("月");
        }
        seconds = seconds % (SECOND_OF_MONTH);
        if (seconds / SECOND_OF_DAY > 0) {
            result.append(seconds / SECOND_OF_DAY).append("天");
        }
        seconds = seconds % (SECOND_OF_DAY);
        if (seconds / SECOND_OF_HOUR > 0) {
            result.append(seconds / SECOND_OF_HOUR).append("小时");
        }
        seconds = seconds % (SECOND_OF_HOUR);
        if (seconds / SECOND_OF_MINUTE > 0 || seconds % SECOND_OF_MINUTE > 0) {
            result.append(seconds / SECOND_OF_MINUTE + (seconds % SECOND_OF_MINUTE > 0 ? 1 : 0)).append("分");
        }
        return result.toString();
    }
}
