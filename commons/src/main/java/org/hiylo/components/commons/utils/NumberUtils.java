/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : NumberUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class NumberUtils {
    /**
     * 将double类型的数值转化为保留两位小数的字符串
     *
     * @param price double类型的数值
     * @return 保留两位小数的字符串
     */
    public static String castDoublePriceToString(double price) {
        return castDoubleKeepTwoDecimalPlaces(price);
    }

    public static String castDoubleKeepTwoDecimalPlaces(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(price);
    }

    public static boolean greaterThanZero(int... values) {
        for (int value : values) {
            if (value <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThanZero(int... values) {
        for (int value : values) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsAndGreaterThanZero(int... values) {
        for (int value : values) {
            if (value < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThanZero(double... values) {
        for (double value : values) {
            if (value <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(int src, int... values) {
        for (int value : values) {
            if (value >= src) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsAndLessThan(int src, int... values) {
        for (int value : values) {
            if (value > src) {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(double src, double... values) {
        for (double value : values) {
            if (value >= src) {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThan(double src, double... values) {
        for (double value : values) {
            if (value < src) {
                return false;
            }
        }
        return true;
    }

    private static final int DEF_DIV_SCALE = 10;

    /**
     * * 两个Double数相加 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double add(Double v1, Double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * * 两个Double数相减 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * * 两个Double数相乘 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double mul(Double v1, Double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * * 两个Double数相除 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double div(Double v1, Double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * * 两个Double数相除，并保留scale位小数 *
     *
     * @param v1    *
     * @param v2    *
     * @param scale *
     * @return Double
     */
    public static Double div(Double v1, Double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 保留小数点两位(四舍五入)
     *
     * @param v1
     * @return
     */
    public static Double round(Double v1) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(v1));
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static Double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = BigDecimal.valueOf(v);
        return b.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String formatString(double d) {
        BigDecimal b = new BigDecimal(d);
        return b.toString();
    }

    public static double formatDouble(String s) {
        BigDecimal b = new BigDecimal(s);
        return b.doubleValue();
    }

    /**
     * 保留小数点两位(未四舍五入)
     *
     * @param v1
     * @return
     */
    public static Double noRound(Double v1) {
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(2);
        formater.setGroupingSize(0);
        formater.setRoundingMode(RoundingMode.FLOOR);
        return Double.parseDouble(formater.format(v1));
    }

    /**
     * 保留小数点两位(未四舍五入)
     *
     * @param v1
     * @return
     */
    public static Double noRound(Double v1, int digits) {
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(digits);
        formater.setGroupingSize(0);
        formater.setRoundingMode(RoundingMode.FLOOR);
        return Double.parseDouble(formater.format(v1));
    }

    /**
     * 保留小数点两位（未四舍五入）
     *
     * @param v1
     * @return
     */
    public static String decimalFormat(Double v1) {
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setMaximumFractionDigits(2);
        df.setGroupingSize(0);
        df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(v1);
    }

    /**
     * 清楚尾部多余的0
     *
     * @param aDouble
     * @return
     */
    public static String clearZero(Double aDouble) {
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return decimalFormat.format(aDouble);
    }

    /**
     * 判断是否是数字
     *
     * @param numbers 需要验证的内容
     * @return true is not a number , false is a number
     */
    public static boolean isNan(String... numbers) {
        for (String number : numbers) {
            try {
                Double.parseDouble(number);
            } catch (NumberFormatException | NullPointerException e) {
                return true;
            }
        }
        return false;
    }
}
