/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PoMapper.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author hiylo
 * @data 2018年11月14日 10:13:46
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PoMapper {
    /**
     * @return 映射的po
     */
    String refer();
    Class[] referClasses() default {};

    /**
     * @return 对应po的field
     */
    String referField();

    /**
     * @return 映射目标对象的field
     */
    String to();
}
