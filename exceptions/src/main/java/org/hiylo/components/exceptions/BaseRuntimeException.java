/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BaseRuntimeException.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:20
 */
public class BaseRuntimeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 2543258395234000337L;
    private Integer code;

    public BaseRuntimeException(Integer code) {
        this(code, Constants.ExceptionDescript.get(code), BaseException.class);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimeException(Integer code, String message) {
        this(code, message, BaseRuntimeException.class);
    }

    public BaseRuntimeException(Integer code, String message, Class clazz) {
        super("{\"retCode\":\"" + code + "\",\"retObject\":\"" + message + "\",\"clazz\":\"" + clazz.getName() + "\"}");
        this.setCode(code);
    }

    public static <T extends BaseRuntimeException> T call(Integer code) {
        StackTraceElement[] elements = (new Throwable()).getStackTrace();
        for (StackTraceElement ele : elements) {
            try {
                if (Class.forName(ele.getClassName()).getSuperclass() == BaseRuntimeException.class) {
                    Constructor constructor = Class.forName(ele.getClassName()).getConstructor(Integer.class, String.class);
                    return (T) constructor.newInstance(code, Constants.ExceptionDescript.get(code));
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T extends BaseRuntimeException> T call(Integer code, String message) {
        StackTraceElement[] elements = (new Throwable()).getStackTrace();
        for (StackTraceElement ele : elements) {
            try {
                if (Class.forName(ele.getClassName()).getSuperclass() == BaseRuntimeException.class) {
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
