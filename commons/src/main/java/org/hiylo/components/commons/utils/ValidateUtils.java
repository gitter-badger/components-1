/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ValidateUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author hiylo
 * @date 2018年2月9日 11:43:53
 */
public class ValidateUtils {
    private static Logger log = LoggerFactory.getLogger(ValidateUtils.class.getClass().getName());

    /**
     * 判断String 不是null 不是 "" ,另外每一个string都会被trim
     *
     * @param values 需要验证的值
     * @return 成功或者失败
     */
    public static boolean isNotEmpty(String... values) {
        return StringUtils.isNotEmpty(values);
    }

    /**
     * 是不是大于0
     *
     * @param values 需要判断的值
     * @return 成功或者失败
     */
    public static boolean greaterZore(Integer... values) {
        AtomicBoolean hasNull = new AtomicBoolean(false);
        int[] temp = new int[values.length];
        final int[] index = {0};
        Arrays.stream(values).forEach(item -> {
            if (!Objects.nonNull(item)) {
                hasNull.set(true);
                return;
            }
            temp[index[0]] = item.intValue();
            index[0]++;
        });
        if (hasNull.get()) {
            return false;
        }
        return NumberUtils.greaterThanZero(temp);
    }

    /**
     * 将需要的异常拉出来, 放过其它异常
     *
     * @param bindingResult bindingResult
     * @param fields        需要的值的field
     * @return
     */
    public static List<ObjectError> process(BindingResult bindingResult, String... fields) {
        List<ObjectError> objectErrors = new ArrayList<>(10);
        Arrays.stream(fields).forEach(f -> objectErrors.addAll(bindingResult.getFieldErrors(f)));
        return objectErrors;
    }

    /**
     * 将需要的异常拉出来, 放过其它异常
     *
     * @param bindingResult bindingResult
     * @param fields        需要的值的field
     * @return
     */
    public static void validate(BindingResult bindingResult, String... fields) {
        AtomicBoolean isSuccess = new AtomicBoolean(true);
        Arrays.stream(fields).forEach(f -> {
            bindingResult.getFieldErrors(f).forEach(fieldError -> {
                log.warn("参数校验失败: {}", fieldError.getField() + ":" + fieldError.getDefaultMessage());
                isSuccess.set(false);
            });
        });
        if (!isSuccess.get()) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * 验证所有参数
     *
     * @param bindingResult bindingResult
     */
    public static void validate(BindingResult bindingResult) {
        boolean isSuccess = bindingResult.getErrorCount() <= 0;
        if (!isSuccess) {
            log.warn("参数校验失败: {}", bindingResult.getAllErrors().toArray());
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    public static void validateExclude(BindingResult bindingResult, String... fields) {
        List<String> strings = Arrays.asList(fields);
        AtomicBoolean isSuccess = new AtomicBoolean(true);
        String[] suppressedFields = bindingResult.getSuppressedFields();
        suppressedFields = Arrays.stream(suppressedFields).filter(item -> !strings.contains(item)).toArray(String[]::new);
        Arrays.stream(suppressedFields).forEach(field -> {
            FieldError error = bindingResult.getFieldError(field);
            log.warn("参数校验失败: {}", error.getObjectName() + ":" + error.getDefaultMessage());
            isSuccess.set(false);
        });
        if (!isSuccess.get()) {
            throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }
}
