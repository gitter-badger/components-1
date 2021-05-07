/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PropertyMapper.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 用来标记vo对象中将复杂对象内的值赋给另一个对象内的某个值
 * <p>
 * 比如  a包含b 如果拷贝a到c 同时需要将b中的某个值给到c的某个field
 *
 * @author hiylo
 * @date 2018年11月14日 09:58:32
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PropertyMapper {
    /**
     * 复杂对象 内的某属性
     *
     * @return 属性名
     */
    String[] refer() default "";

    Class[] referClasses() default {};

    /**
     * 目标对象的某个Field
     *
     * @return field的值
     */
    String[] to() default "";

    /**
     * 可以用来标记不需要copy的值或者对象
     *
     * @return
     */
    boolean ignore() default false;
}
