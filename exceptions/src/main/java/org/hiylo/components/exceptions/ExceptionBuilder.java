/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ExceptionBuilder.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import com.google.gson.Gson;
import org.hiylo.components.exceptions.vo.BaseInfo;

public class ExceptionBuilder {
    private static Gson gson = new Gson();

    public static BaseException buildBaseException(String json) {
        BaseInfo baseInfo = gson.fromJson(json, BaseInfo.class);
        return new BaseException(Integer.valueOf(String.valueOf(baseInfo.getRetCode())), baseInfo.getRetObject());
    }
}
