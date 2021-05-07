/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommonUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class CommonUtilsTest {

    @Test
    public void getFileTypeMap() {
    }

    @Test
    public void createToken() {
    }

    @Test
    public void stringFilter() {
    }

    @Test
    public void isImage() {
    }

    @Test
    public void getImageFileType() {
    }

    @Test
    public void getFileByFile() {
    }

    @Test
    public void getFileTypeByStream() {
    }

    @Test
    public void isImage1() {
    }

    @Test
    public void getFileHexString() {
    }

    @Test
    public void firstChatToUpcase() {
    }

    @Test
    public void convertStringToList() {
    }

    @Test
    public void jsonToXML() {
    }

    @Test
    public void mapToXML() {
    }

    @Test
    public void xml2Map() {
    }

    @Test
    public void getChildElements() {
    }

    @Test
    public void map2Json() {
    }

    @Test
    public void signWithMd5() {
    }

    @Test
    public void createSignParam() throws UnsupportedEncodingException {
        Map<String, Object> sonMap = new TreeMap<>();
        sonMap.put("1233", "456");

        log.debug(CommonUtils.createSignParam(sonMap));
    }

    @Test
    public void removeLatestCharacter() {
        log.debug(CommonUtils.removeLatestCharacter("1234567"));
    }

    @Test
    public void mapToUriVariables() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "zhangsan");
        params.put("age", 2);
        params.put("sex", 1);
//       log.debug(CommonUtils.mapToUriVariables(params));
    }
}