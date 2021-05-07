/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BaseException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hiylo on 12/19/2016.
 */
public class BaseException extends Exception implements Serializable {
    private static final long serialVersionUID = 2543258395234000337L;
    private Integer code;
    private Class clazz;

    public BaseException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code), BaseException.class);
    }

    public BaseException(Integer code, String message) {
        this(code, message, BaseException.class);
    }

    public BaseException(Integer code, String message, Class clazz) {
        super("{\"retCode\":\"" + code + "\",\"retObject\":\"" + message + "\",\"clazz\":\"" + clazz.getName() + "\"}");
        this.setCode(code);
        this.clazz = clazz;
    }


    public static <T extends BaseException> T call(Integer code) {
        StackTraceElement[] elements = (new Throwable()).getStackTrace();
        for (StackTraceElement ele : elements) {
            try {
                if (Class.forName(ele.getClassName()).getSuperclass() == BaseException.class) {
                    Constructor constructor = Class.forName(ele.getClassName()).getConstructor(Integer.class, String.class);
                    T t = (T) constructor.newInstance(code, Constants.ExceptionDescript.get(code));
                    return t;
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T extends BaseException> T call(Integer code, String message) {
        StackTraceElement[] elements = (new Throwable()).getStackTrace();
        for (StackTraceElement ele : elements) {
            try {
                if (Class.forName(ele.getClassName()).getSuperclass() == BaseException.class) {
                    Constructor constructor = Class.forName(ele.getClassName()).getConstructor(Integer.class, String.class);
                    return (T) constructor.newInstance(code, message);
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
