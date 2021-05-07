/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Mapper.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.annotations;

import org.hiylo.components.fentity.enums.DeleteType;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @author hiylo
 * @date 2019年2月16日 13:03:59
 */
@Target({METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Mapper {
    /**
     * Id 字段名称
     *
     * @return
     */
    String idFieldName() default "id";

    /**
     * @return 删除方式
     */
    DeleteType deleteType() default DeleteType.PHYSICAL;

    /**
     * 如果删除方式是逻辑删除, 那么此字段为必填, 不可为空
     *
     * @return 逻辑删除标记
     */
    String logicalDeleteFlag() default "";
}
