/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Json.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author hiylo
 * @date 2019年3月12日 15:59:51
 */
@Slf4j
public class Json {
    private Json() {

    }

    private static Gson gson = new Gson();

    public static Map<String, Object> toMap(String json) {
        return gson.fromJson(json, Map.class);
    }

    public static String toJson(Object object) {
        String json = gson.toJson(object);
        if (JSON.isValidObject(json)) {
            JSONObject jsonObject = JSON.parseObject(json);
            jsonObject.put("class", object.getClass());
            return jsonObject.toJSONString();
        } else if (JSON.isValidArray(json)) {
            List list = (List) object;
            Object o = list.get(0);
            JSONArray jsonArray = JSON.parseArray(json);
            JSONArray array = new JSONArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jsonObject.put("class", o.getClass());
                array.add(jsonObject);
            }
            return array.toJSONString();
        }
        return null;
    }

    public static Object parse(String json) {
        log.debug(json);
        if (StringUtils.isEmpty(json)) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL, "Value is empty!");
        }
        if (JSON.isValidObject(json)) {
            JSONObject jsonObject = JSON.parseObject(json);
            if (Objects.isNull(jsonObject)) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL, "Value is not a json!");
            }
            String clazzStr = jsonObject.getString("class");
            if (StringUtils.isEmpty(clazzStr)) {
                return jsonObject;
            } else {
                try {
                    Class clazz = Class.forName(clazzStr);
                    log.debug(jsonObject.toJSONString());
                    Object object = gson.fromJson(json, clazz);
                    log.debug(String.valueOf(object));
                    return object;
                } catch (ClassNotFoundException e) {
                    throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL, "Class not found!");
                }
            }
        } else if (JSON.isValidArray(json)) {
            JSONArray jsonArray = JSON.parseArray(json);
            for (int i = 0; i < jsonArray.size(); i++) {
                String clazzStr = jsonArray.getJSONObject(i).getString("class");
                if (StringUtils.isEmpty(clazzStr)) {
                    return jsonArray.getJSONObject(i);
                } else {
                    try {
                        Class clazz = Class.forName(clazzStr);
                        log.debug(jsonArray.getJSONObject(i).toJSONString());
                        Object object = gson.fromJson(json, clazz);
                        log.debug(String.valueOf(object));
                        return object;
                    } catch (ClassNotFoundException e) {
                        throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL, "Class not found!");
                    }
                }
            }
        }
        return null;
    }

    public static Integer getInteger(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getInteger(field);
    }

    public static String getString(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getString(field);
    }

    public static Boolean getBoolean(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getBoolean(field);
    }

    public static Short getShort(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getShort(field);
    }

    public static Byte getByte(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getByte(field);
    }

    public static List<String> getStringList(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getJSONArray(field).toJavaList(String.class);
    }

    public static List<Integer> getIntegerList(String body, String field) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        return jsonObject.getJSONArray(field).toJavaList(Integer.class);
    }
}
