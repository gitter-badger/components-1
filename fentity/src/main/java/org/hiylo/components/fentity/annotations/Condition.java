/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Condition.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.annotations;

import org.hiylo.components.fentity.enums.ConditionType;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * 用以和 db 中的Dsl合用, 用来自动生成Dsl
 *
 * @author hiylo
 * @date 2019年2月15日 16:33:19
 */
@Target({METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Condition {
    /**
     * 条件类型 {@link ConditionType}
     *
     * @return 条件类型
     */
    ConditionType conditionType() default ConditionType.EQUALS;

    /**
     * 属性
     *
     * @return 属性名 默认使用自身属性名进行匹配
     */
    String field() default "";

    /**
     * 忽略Null
     *
     * @return 是否忽略Null
     */
    boolean ignoreNull() default true;
}
