/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : DateUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author hiylo
 * @date 2018年12月19日 18:30:34
 */
@Slf4j
public class DateUtils {
    private final SimpleDateFormat standardSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat standardSimpleDateFormatT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private final SimpleDateFormat standardSimpleDateFormatTZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
    private final SimpleDateFormat standardSimpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
    private final DateTimeFormatter standarDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DateTimeFormatter standarDayTimeFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateUtils dateUtils = new DateUtils();

    public SimpleDateFormat getStandardSimpleDateFormat() {
        return standardSimpleDateFormat;
    }

    public SimpleDateFormat getStandardSimpleDateFormatT() {
        return standardSimpleDateFormatT;
    }

    public SimpleDateFormat getStandardSimpleTimeFormat() {
        return standardSimpleTimeFormat;
    }

    public SimpleDateFormat getStandardSimpleDateFormatTZ() {
        return standardSimpleDateFormatTZ;
    }

    public DateTimeFormatter getStandarDataTimeFormat() {
        return standarDateTimeFormat;
    }

    public DateTimeFormatter getStandarDateTimeFormat() {
        return standarDateTimeFormat;
    }

    public DateTimeFormatter getStandarDayTimeFormat() {
        return standarDayTimeFormat;
    }

    /**
     * 把Timestamp格式换成String
     *
     * @param timestamp 需要格式化的Timestamp
     * @return 格式化之后的日期
     */
    public static String formatTimestampToStandardDateString(Timestamp timestamp) {
        if (Objects.nonNull(timestamp)) {
            return dateUtils.getStandardSimpleDateFormat().format(new Date(timestamp.getTime()));
        } else {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
    }

    /**
     * 把Timestamp格式换成String
     *
     * @param timestamp 需要格式化的Timestamp
     * @return 格式化之后的日期
     */
    public static String formatTimestampToStandardDateStringTZ(Timestamp timestamp) {
        if (Objects.nonNull(timestamp)) {
            return dateUtils.getStandardSimpleDateFormatTZ().format(new Date(timestamp.getTime()));
        } else {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
    }

    public static Date parseStandardDate(String date) {
        if (StringUtils.isEmpty(date)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        try {
            return dateUtils.getStandardSimpleDateFormat().parse(date);
        } catch (ParseException e) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
    }

    /**
     * 把Date转成Timestamp
     *
     * @param date 日期字符串
     * @return 时间戳
     * @throws ParseException 解析错误
     */
    public static Timestamp parseStandardDateStringToTimestamp(String date) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        long timestamp = dateUtils.getStandardSimpleDateFormat().parse(date).getTime();
        return new Timestamp(timestamp);
    }

    public static String formatNowToStandardDateFormat() {
        return dateUtils.getStandardSimpleDateFormat().format(new Date());
    }

    /**
     * 吧中间带T的日期字符串转换成Timestamp
     *
     * @param date 日期字符串
     * @return 时间戳
     * @throws ParseException 解析错误
     */
    public static Timestamp parseStandardDateStringTToTimestamp(String date) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        long timestamp = dateUtils.getStandardSimpleDateFormatT().parse(date).getTime();
        return new Timestamp(timestamp);
    }

    /**
     * 把时间戳转换成String中间带T
     *
     * @param timestamp 时间戳
     * @return 日期字符串
     */
    public static String formatTimestampToStandardDateStringT(Timestamp timestamp) {
        if (timestamp == null) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        return dateUtils.getStandardSimpleDateFormatT().format(new Date(timestamp.getTime()));
    }

    /**
     * 把时间戳转换成String中间带T
     *
     * @param timestamp 时间戳
     * @return 日期字符串
     */
    public static String formatLocalDateTimeToStandardDateString(LocalDateTime timestamp) {
        if (timestamp == null) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        return dateUtils.getStandarDataTimeFormat().format(timestamp);
    }

    /**
     * 把日期字符串转成时间戳
     *
     * @param date 日期字符串
     * @return 时间戳
     * @throws ParseException 解析错误
     */
    public static Timestamp parseDateStringToTimestamp(String date) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        try {
            return parseStandardDateStringToTimestamp(date);
        } catch (ParseException e) {
            try {
                return parseStandardDateStringTToTimestamp(date);
            } catch (ParseException e1) {
                log.debug("日期转换错误{} {}", date, e1);
                throw e1;
            }
        }
    }

    /**
     * 对日期字符串进行操作
     *
     * @param date  日期字符串
     * @param field 操作什么 {@link Calendar}
     * @param value 值
     * @return 操作之后的字符串
     * @throws ParseException 解析错误
     */
    public static String computeDateString(String date, int field, int value) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        Timestamp timestamp = DateUtils.parseStandardDateStringToTimestamp(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.add(field, value);
        return dateUtils.getStandardSimpleDateFormat().format(calendar.getTime());
    }

    public static Date getFirstDayMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
        return calendar.getTime();
    }

    public static String getFirstDayMonthString() {
        return formatDateToStandardDateString(getFirstDayMonth());
    }

    public static String getBeginningOfTheDay(Date date) {
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        return formatDateToStandardDateString(date);
    }

    public static String getEndOfTheDay(Date date) {
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        return formatDateToStandardDateString(date);
    }

    public static String formatDateToStandardDateString(Date date) {
        if (date == null) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        return dateUtils.getStandardSimpleDateFormat().format(date);
    }

    public static String formatDateToCustom(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parseDateToCustom(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    public static boolean timeIsInRange(Date date, String startTime, String endTime, String pattern) {
        if (date == null || StringUtils.isEmpty(startTime, endTime, pattern)) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar item = Calendar.getInstance();
        item.setTime(date);
        try {
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            if (pattern.indexOf("yyyy") == -1) {
                start.set(Calendar.YEAR, item.get(Calendar.YEAR));
                end.set(Calendar.YEAR, item.get(Calendar.YEAR));
            }
            if (pattern.indexOf("MM") == -1) {
                start.set(Calendar.MONTH, item.get(Calendar.MONTH));
                end.set(Calendar.MONTH, item.get(Calendar.MONTH));
            }
            if (pattern.indexOf("dd") == -1) {
                start.set(Calendar.DAY_OF_YEAR, item.get(Calendar.DAY_OF_YEAR));
                end.set(Calendar.DAY_OF_YEAR, item.get(Calendar.DAY_OF_YEAR));
                start.set(Calendar.DATE, item.get(Calendar.DATE));
                end.set(Calendar.DATE, item.get(Calendar.DATE));
            }
            if (pattern.indexOf("HH") == -1) {
                start.set(Calendar.HOUR, item.get(Calendar.HOUR));
                end.set(Calendar.HOUR, item.get(Calendar.HOUR));
                start.set(Calendar.HOUR_OF_DAY, item.get(Calendar.HOUR_OF_DAY));
                end.set(Calendar.HOUR_OF_DAY, item.get(Calendar.HOUR_OF_DAY));
            }
            if (pattern.indexOf("mm") == -1) {
                start.set(Calendar.MINUTE, item.get(Calendar.MINUTE));
                end.set(Calendar.MINUTE, item.get(Calendar.MINUTE));
            }
            if (pattern.indexOf("ss") == -1) {
                start.set(Calendar.SECOND, item.get(Calendar.SECOND));
                end.set(Calendar.SECOND, item.get(Calendar.SECOND));
            }
            return item.getTimeInMillis() >= start.getTimeInMillis() && item.getTimeInMillis() <= end.getTimeInMillis();
        } catch (ParseException e) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
    }

    public static String getDateDescriptionDetail(Date date) {
        if (date == null) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar now = Calendar.getInstance();
        int dateDifference = calendar.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR);
        int yearDifference = calendar.get(Calendar.YEAR) - now.get(Calendar.YEAR);
        int monthDifference = calendar.get(Calendar.MONTH) - now.get(Calendar.MONTH);
        StringBuilder result = new StringBuilder();
        boolean currentYear = false;
        boolean currentMonth = false;
        if (yearDifference == 0) {
            currentYear = true;
        } else if (yearDifference == 1) {
            result.append("明年");
        } else if (yearDifference == -1) {
            result.append("去年");
        } else {
            result.append(calendar.get(Calendar.YEAR) + "年");
        }
        if (currentYear) {
            if (monthDifference == 0) {
                currentMonth = true;
                result.append("本月");
            } else if (monthDifference == 1) {
                result.append("下月");
            } else if (monthDifference == -1) {
                result.append("上月");
            } else {
                result.append((calendar.get(Calendar.MONTH) + 1) + "月");
            }
        } else {
            result.append((calendar.get(Calendar.MONTH) + 1) + "月");
        }
        if (currentYear && currentMonth) {
            if (dateDifference == 1) {
                result.append("明日");
            } else if (dateDifference == 0) {
                result.append("今日");
            } else if (dateDifference == -1) {
                result.append("昨日");
            } else {
                result.append(calendar.get(Calendar.DAY_OF_MONTH) + "日");
            }
        } else {
            result.append(calendar.get(Calendar.DAY_OF_MONTH) + "日");
        }
        return result.toString();
    }

    public static String getDateDescription(Date date) {
        if (date == null) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar now = Calendar.getInstance();
        int dateDifference = calendar.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR);
        int yearDifference = calendar.get(Calendar.YEAR) - now.get(Calendar.YEAR);
        int monthDifference = calendar.get(Calendar.MONTH) - now.get(Calendar.MONTH);
        StringBuilder result = new StringBuilder();
        if (yearDifference == 0 && monthDifference == 0) {
            if (dateDifference == 1) {
                result.append("明日 ");
                result.append(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
                return result.toString();
            } else if (dateDifference == 0) {
                result.append("今日 ");
                result.append(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
                return result.toString();
            }
        }
        return formatDateToStandardDateString(date);
    }

    public static boolean timeIsInRange(Date date, Time startTime, Time endTime) {
        if (date == null || startTime == null || endTime == null) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL, "日期格式转换异常");
        }
        Calendar item = Calendar.getInstance();
        item.setTime(date);

        String startTimeStr = startTime.getHours() + ":" + startTime.getMinutes() + ":" + startTime.getSeconds();
        ;
        String endTimeStr = endTime.getHours() + ":" + endTime.getMinutes() + ":" + endTime.getSeconds();
        return DateUtils.timeIsInRange(date, startTimeStr, endTimeStr, "HH:mm:ss");
    }

    public static String formatNowToStandardDateString() {
        return dateUtils.getStandardSimpleDateFormat().format(new Date());
    }

    public static String formatNowToStandardDateStringT() {
        return dateUtils.getStandardSimpleDateFormatT().format(new Date());
    }

    public static String formatToday() {
        return dateUtils.getStandarDayTimeFormat().format(LocalDateTime.now());
    }

    public static int getLastDateOfMonth(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return new Date().getYear() + 1900 % 4 ==0?29: 28;
            default:
                return 30;
        }
    }
}
