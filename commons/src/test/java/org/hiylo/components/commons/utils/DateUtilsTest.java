/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : DateUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtilsTest {

    @Test
    public void formatTimestampToStandardDateString() {
    }

    @Test
    public void parseStandardDateStringToTimestamp() {
    }

    @Test
    public void parseStandardDateStringTToTimestamp() {
    }
    @Test
    public void formatLocalDateTimeToStandardDateString() {
        log.debug(DateUtils.formatLocalDateTimeToStandardDateString(LocalDateTime.now()));
    }

    @Test
    public void parseDateStringToTimestamp() {
    }

    @Test
    public void computeDateString() {
        try {
            log.debug(DateUtils.computeDateString("2018-12-19 00:00:00", Calendar.DATE, -7));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStandardDateFormat() {
    }

    @Test
    public void getStandardDateFormatT() {
    }

    @Test
    public void formatTimestampToStandardDateString1() {
    }

    @Test
    public void parseStandardDateStringToTimestamp1() {
    }

    @Test
    public void parseStandardDateStringTToTimestamp1() {
    }

    @Test
    public void formatTimestampToStandardDateStringT1() {
    }

    @Test
    public void parseDateStringToTimestamp1() {
    }

    @Test
    public void computeDateString1() {
    }

    @Test
    public void getFirstDayMonth() {
    }

    @Test
    public void getFirstDayMonthString() {
    }

    @Test
    public void timeIsInRange() {
        log.debug(String.valueOf(DateUtils.timeIsInRange(new Date(), "13:39", "13:45", "HH:mm")));
    }

    @Test
    public void getDateDescription() {
        Date date = new Date();
//        date.setYear(date.getYear() -1);
//        date.setMonth(date.getMonth()  + 1);
//        date.setDate(date.getDate() - 2);
        log.debug(DateUtils.getDateDescription(date));
    }
}