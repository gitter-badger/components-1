/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : EnumMapper.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author hiylo
 * @date 2018年12月28日 15:45:28
 * 示例 @EnumMapper(refer = "org.hiylo.components.commons.beanutils.ClientType", referField = "description", method = "getClientType", to = "clientType", methodReturnObject = false)
 * 比如说需要枚举类型中的其它字段的话
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnumMapper {
    /**
     * @return 映射的po
     */
    String refer();
    Class[] referClasses() default {};

    /**
     * 方法
     *
     * @return
     */
    String method();

    /**
     * @return 对应po的field
     */
    String referField() default "";

    /**
     * @return 映射目标对象的field
     */
    String to() default "";

    /**
     * 通过method 获取到的对象是否是需要的对象
     *
     * @return 是否直接是需要的对象
     */
    boolean methodReturnObject() default false;

    /**
     * 可以用来标记不需要copy的值或者对象
     *
     * @return
     */
    boolean ignore() default false;
}
