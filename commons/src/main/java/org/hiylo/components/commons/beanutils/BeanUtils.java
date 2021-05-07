/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : BeanUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.beanutils;

import org.hiylo.components.commons.beanutils.annotation.EnumMapper;
import org.hiylo.components.commons.beanutils.annotation.PropertyMapper;
import org.hiylo.components.commons.utils.DateUtils;
import org.hiylo.components.commons.utils.NumberUtils;
import org.hiylo.components.commons.utils.StringUtils;
import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hiylo
 * @date 2018年10月29日 15:37:49
 */
public class BeanUtils {
    private static final String MARK_ARGS_NOT_BE_EMPTY = "参数不能为空 {}";

    private Logger log = LoggerFactory.getLogger(BeanUtils.class.getName());


    /**
     * 使用Apache 的BeanUtils 首先对对象中的简单值进行拷贝, 之后通过{@link PropertyMapper}注解属性反射再次将复杂对象进行拷贝
     *
     * @param src  源对象
     * @param dest 目标对象
     * @param <T>  目标对象类型
     * @return 拷贝过后的目标对象
     */
    public <T> T convert(Object src, T dest) {
        if (src == null || dest == null) {
            return null;
        }
        copyProperties(src, dest);
        copyEnum(src, dest);
        return convertBeans(src, dest);
    }

    private <T> T copyEnum(Object src, T dest) {
        Field[] declaredFields = src.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            EnumMapper annotation = declaredField.getAnnotation(EnumMapper.class);
            if (Objects.nonNull(annotation)) {
                Object value = getValueFromObject(src, declaredField.getName());
                try {
                    Class enumClazz = Class.forName(annotation.refer());

                    if (annotation.methodReturnObject()) {
                        value = enumClazz.getMethod(annotation.method(), getFieldType(src, declaredField.getName())).invoke(null, value);
                        if (Objects.nonNull(value) || !annotation.ignore()) {
                            if (StringUtils.isNotEmpty(annotation.to())) {
                                this.setFieldValue(dest, annotation.to(), value);
                            } else {
                                this.setFieldValue(dest, declaredField.getName(), value);
                            }
                        }
                    } else {
                        value = this.getFieldValue(value, annotation.referField());
                        if (!annotation.ignore() || Objects.nonNull(value)) {
                            if (StringUtils.isNotEmpty(annotation.to())) {
                                this.setFieldValue(dest, annotation.to(), value);
                            } else {
                                this.setFieldValue(dest, declaredField.getName(), value);
                            }
                        }
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                }
            }
        }
        return dest;
    }

    /**
     * 使用Apache 的BeanUtils 首先对对象中的简单值进行拷贝, 之后通过{@link PropertyMapper}注解属性反射再次将复杂对象进行拷贝
     *
     * @param src  源对象
     * @param dest 目标对象
     * @param <T>  目标对象类型
     * @return 拷贝过后的目标对象
     */
    public <T> T convertExclude(Object src, T dest, String... fieldsArr) {
        if (src == null || dest == null) {
            return null;
        }
        copyPropertiesExclude(src, dest, fieldsArr);
        return convertBeansExclude(src, dest, fieldsArr);
    }

    /**
     * 拷贝属性
     *
     * @param src  源对象
     * @param dest 目标对象
     * @param <T>  目标对象类型
     * @return 拷贝完成的目标对象
     */
    private <T> T copyProperties(Object src, T dest) {
        Field[] declaredFields = src.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!"serialVersionUID".equals(declaredField.getName())) {
                this.copyProperties(src, dest, declaredField);
            }
        }
        return dest;
    }

    private <T> T copyProperties(Object src, T dest, Field declaredField) {
        PropertyMapper annotation = declaredField.getAnnotation(PropertyMapper.class);
        Class<?> fieldType = getFieldType(src, declaredField.getName());
        if (Objects.nonNull(fieldType) && fieldType.getName().startsWith("java.lang.") && (Objects.isNull(annotation) || !annotation.ignore())) {
            try {
                Object value = getValueFromObject(src, declaredField.getName());
                if (Objects.nonNull(value)) {
                    if (!checkFieldExist(dest, declaredField.getName()) &&
                            "java.lang.Double".equals(getFieldType(dest, declaredField.getName()).getName()) &&
                            Objects.nonNull(declaredField.getAnnotation(Column.class))) {
                        if (declaredField.getAnnotation(Column.class).scale() != 0) {
                            double doubleValue = Double.parseDouble(String.valueOf(value));
                            doubleValue = NumberUtils.noRound(doubleValue, declaredField.getAnnotation(Column.class).scale());
                            org.apache.commons.beanutils.BeanUtils.copyProperty(dest, declaredField.getName(), doubleValue);
                        } else {
                            org.apache.commons.beanutils.BeanUtils.copyProperty(dest, declaredField.getName(), value);
                        }
                    } else if (!checkFieldExist(dest, declaredField.getName()) &&
                            "java.sql.Timestamp".equals(getFieldType(dest, declaredField.getName()).getName())) {
                        try {
                            Timestamp timestamp = DateUtils.parseDateStringToTimestamp(String.valueOf(value));
                            setFieldValue(dest, declaredField.getName(), timestamp);
                        } catch (ParseException e) {
                        }
                    } else {
                        org.apache.commons.beanutils.BeanUtils.copyProperty(dest, declaredField.getName(), value);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            }
        } else if (Objects.nonNull(fieldType) && "java.sql.Timestamp".equals(fieldType.getName()) && (Objects.isNull(annotation) ||
                !annotation.ignore())) {
            try {
                Object value = getValueFromObject(src, declaredField.getName());
                if (Objects.nonNull(value)) {
                    if (!checkFieldExist(dest, declaredField.getName())) {
                        String date = DateUtils.formatTimestampToStandardDateString((Timestamp) value);
                        setFieldValue(dest, declaredField.getName(), date);
                    } else {
                        org.apache.commons.beanutils.BeanUtils.copyProperty(dest, declaredField.getName(), value);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            }
        } else if (Objects.nonNull(fieldType) && "java.math.BigDecimal".equals(fieldType.getName()) && (Objects.isNull(annotation) ||
                !annotation.ignore())) {
            try {
                Object value = getValueFromObject(src, declaredField.getName());
                if (Objects.nonNull(value)) {
                    if (!checkFieldExist(dest, declaredField.getName())) {
                        setFieldValue(dest, declaredField.getName(), value);
                    } else {
                        org.apache.commons.beanutils.BeanUtils.copyProperty(dest, declaredField.getName(), value);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            }
        } else if (Objects.nonNull(fieldType) && ("java.time.LocalDateTime".equals(fieldType.getName()) ||
                "java.time.LocalTime".equals(fieldType.getName())) && (Objects.isNull(annotation) ||
                !annotation.ignore())) {
            try {
                Object value = getValueFromObject(src, declaredField.getName());
                if (Objects.nonNull(value)) {
                    if (!checkFieldExist(dest, declaredField.getName())) {
                        setFieldValue(dest, declaredField.getName(), value);
                    } else {
                        org.apache.commons.beanutils.BeanUtils.copyProperty(dest, declaredField.getName(), value);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            }
        }
        return dest;
    }

    /**
     * 拷贝属性
     *
     * @param src  源对象
     * @param dest 目标对象
     * @param <T>  目标对象类型
     * @return 拷贝完成的目标对象
     */
    private <T> T copyPropertiesExclude(Object src, T dest, String... fieldsArr) {
        List<String> fields = Arrays.asList(fieldsArr);
        Field[] declaredFields = src.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!fields.contains(declaredField.getName())) {
                this.copyProperties(src, dest, declaredField);
            }
        }
        return dest;
    }

    /**
     * 使用{@link PropertyMapper} 进行拷贝
     *
     * @param src  源对象
     * @param dest 目标对象
     * @param <T>  目标对象类型
     * @return 拷贝完成的目标对象
     */
    private <T> T convertBeans(Object src, T dest) {
        return convertBeansExclude(src, dest);
    }

    /**
     * 使用{@link PropertyMapper} 进行拷贝
     *
     * @param src  源对象
     * @param dest 目标对象
     * @param <T>  目标对象类型
     * @return 拷贝完成的目标对象
     */
    private <T> T convertBeansExclude(Object src, T dest, String... fieldsArr) {
        List<String> fieldsList = Arrays.asList(fieldsArr);
        Field[] fields = src.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!fieldsList.contains(field.getName())) {
                PropertyMapper annotation = field.getAnnotation(PropertyMapper.class);
                if (Objects.nonNull(annotation) && !annotation.ignore()) {
                    String[] refer = annotation.refer();
                    String[] to = annotation.to();
                    Object o = getValueFromObject(src, field.getName());
                    if (Objects.nonNull(o)) {
                        if (o instanceof List) {

                        } else {
                            for (int i = 0; i < refer.length; i++) {
                                getAndSetValue(o, dest, refer[i], to[i]);
                            }
                        }
                    }
                }
            }
        }
        return dest;
    }

    /**
     * 从源对象中获取某个属性的值然后赋给目标对象的某个field
     *
     * @param src       源对象
     * @param dest      目标对象
     * @param srcField  源对象field
     * @param destFirld 目标对象field
     * @param <T>       目标对象类型
     * @return 拷贝之后的目标对象
     */
    private <T> T getAndSetValue(Object src, T dest, String srcField, String destFirld) {
        Object value = getValueFromObject(src, srcField);
        if (Objects.nonNull(value)) {
            if (!checkFieldExist(dest, destFirld) && "java.sql.Timestamp".equals(getFieldType(dest, destFirld).getName())) {
                try {
                    Timestamp timestamp = DateUtils.parseDateStringToTimestamp(String.valueOf(value));
                    setFieldValue(dest, destFirld, timestamp);
                } catch (ParseException e) {
                }
            } else if ("java.sql.Timestamp".equals(getFieldType(src, srcField).getName())) {
                try {
                    if (Objects.nonNull(value)) {
                        if (!checkFieldExist(dest, destFirld)) {
                            String date = DateUtils.formatTimestampToStandardDateString((Timestamp) value);
                            setFieldValue(dest, destFirld, date);
                        } else {
                            org.apache.commons.beanutils.BeanUtils.copyProperty(dest, destFirld, value);
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
                }
            } else {
                setFieldValue(dest, destFirld, value);
            }

            return dest;
        }
        return dest;
    }

    /**
     * 从对象中取得某个field的值
     *
     * @param src   源对象
     * @param field field
     * @return 获取到的值
     */
    public Object getValueFromObject(Object src, String field) {
        if (src == null) {
            return null;
        }
        if (!field.contains(".")) {
            return getFieldValue(src, field);
        } else {
            String[] childField = field.split("\\.");
            return getValueFromObject(src, childField);
        }
    }

    private Object getValueFromObject(Object src, String[] childFields) {
        try {
            for (String field : childFields) {
                src = getValueFromObject(src, field);
            }
            return src;
        } catch (CommonsRuntimeException e) {
            return null;
        }
    }

    /**
     * 通过get方法获取某个属性的值
     *
     * @param src   从哪个对象获取
     * @param field 需要获取的属性
     * @return 取到的值
     */
    private Object getFieldValue(Object src, String field) {
        try {
            try {
                return src.getClass().getMethod("get" + firstCharToUpperCase(field)).invoke(src);
            } catch (NoSuchMethodException e) {
                return src.getClass().getMethod("get" + secondCharToUpperCase(field)).invoke(src);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * 调用set方法给某个对象设置属性
     *
     * @param src   需要设置的对象
     * @param field 需要给哪个属性设置值
     * @param obj   设置的值
     */
    public void setFieldValue(Object src, String field, Object obj) {
        if (src == null || obj == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        try {
            if (field.contains(".")) {
                List<String> list = new ArrayList<>(Arrays.asList(field.split("\\.")));
                setFieldValue(src, list, obj);
            } else {
                try {
                    src.getClass().getMethod("set" + firstCharToUpperCase(field), obj.getClass()).invoke(src, obj);
                } catch (NoSuchMethodException e) {
                    src.getClass().getMethod("set" + secondCharToUpperCase(field), obj.getClass()).invoke(src, obj);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("{} {} {}", src, field, obj);
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * 调用set方法给某个对象设置属性
     *
     * @param src   需要设置的对象
     * @param field 需要给哪个属性设置值
     * @param obj   设置的值
     */
    public void setFieldValue(Object src, String field, Object obj, Class objClass) {
        if (src == null || obj == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        try {
            if (field.contains(".")) {
                List<String> list = new ArrayList<>(Arrays.asList(field.split("\\.")));
                setFieldValue(src, list, obj);
            } else {
                try {
                    src.getClass().getMethod("set" + firstCharToUpperCase(field), objClass).invoke(src, obj);
                } catch (NoSuchMethodException e) {
                    src.getClass().getMethod("set" + secondCharToUpperCase(field), objClass).invoke(src, obj);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    private void setFieldValue(Object src, List<String> childFields, Object obj) {
        if (src == null || obj == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        if (childFields.size() > 1) {
            Object o = getValueFromObject(src, childFields.get(0));
            if (o == null) {
                o = newInstanceWithEmpteConstruct(getFieldType(src, childFields.get(0)));
            }
            setFieldValue(src, childFields.get(0), o);
            childFields.remove(childFields.get(0));
            setFieldValue(o, childFields, obj);
        } else if (childFields.size() == 1) {
            setFieldValue(src, childFields.get(0), obj);
        }
    }

    /**
     * 根据类型实例化对象 (通过空的构造方法)
     *
     * @param clazz 需要实例化的对象
     * @return 实例化之后的对象
     */
    private Object newInstanceWithEmpteConstruct(Class<?> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * 获取对象Field的类型
     *
     * @param obj   源对象
     * @param field field
     * @return 获取到的类型
     */
    public Class<?> getFieldType(Object obj, String field) {
        if (obj == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        if (!field.contains(".")) {
            try {
                if (!"$$_hibernate_interceptor".equals(field) && !field.startsWith("cachedValue$")) {
                    try {
                        return obj.getClass().getMethod("get" + firstCharToUpperCase(field)).getReturnType();
                    } catch (NoSuchMethodException e) {
                        return obj.getClass().getMethod("get" + secondCharToUpperCase(field)).getReturnType();
                    }
                }
                return null;
            } catch (NoSuchMethodException e) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            }
        } else {
            String[] childField = field.split("\\.");
            return getFieldType(obj, childField);
        }

    }

    private Class<?> getFieldType(Object src, String[] childFields) {
        try {
            for (int i = 0; i < childFields.length; i++) {
                if (i + 1 != childFields.length) {
                    src = getFieldValue(src, childFields[i]);
                } else {
                    src = getFieldType(src, childFields[i]);
                }
            }
            return (Class<?>) src;
        } catch (CommonsRuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串第一个字符转换成大写之后返回
     *
     * @param src 需要转换的字符串
     * @return 转换之后的字符串
     */
    private String firstCharToUpperCase(String src) {
        if (StringUtils.isEmpty(src)) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        switch (src.length()) {
            case 0:
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            case 1:
                return src.toUpperCase();
            // TODO 第二个字母大写的情况
            default:
                return src.substring(0, 1).toUpperCase() + src.
                        substring(1);
        }
    }

    /**
     * 一般情况下比如name这种的set方法是setName, 但是bName则可能为setbName
     *
     * @param src 需要转换的字符串
     * @return 转换之后的字符串
     */
    private String secondCharToUpperCase(String src) {
        if (StringUtils.isEmpty(src)) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        switch (src.length()) {
            case 0:
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            case 1:
                return src;
            default:
                return src.substring(0, 1) + src.substring(1, 2).toUpperCase() + src.
                        substring(2);
        }
    }

    /**
     * 转换列表
     *
     * @param srcs  源对象列表
     * @param clazz 目标对象类型
     * @param <T>   目标对象类型
     * @return 拷贝完成的目标对象列表
     */
    public <T> List<T> convertList(List<?> srcs, Class<T> clazz) {
        if (srcs == null || clazz == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        try {
            List<T> result = new ArrayList<>(srcs.size());
            for (Object src : srcs) {
                Object dest = clazz.newInstance();
                result.add(this.convert(src, (T) dest));
            }
            return result;
        } catch (IllegalAccessException | InstantiationException e) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * 转换列表
     *
     * @param srcs     源对象列表
     * @param clazz    目标对象类型
     * @param <T>      目标对象类型
     * @param consumer 执行一些转换操作
     * @return 拷贝完成的目标对象列表
     */
    public <T> List<T> convertList(List<?> srcs, Class<T> clazz, Function<T, Optional<T>> consumer) {
        if (srcs == null || clazz == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        try {
            List<T> result = new ArrayList<>(srcs.size());
            for (Object src : srcs) {
                Object dest = clazz.newInstance();
                if (Objects.nonNull(consumer)) {
                    T convert = this.convert(src, (T) dest);
                    Optional.ofNullable(convert).ifPresent(t -> result.add(Optional.of(convert).flatMap(consumer).get()));
                } else {
                    result.add(this.convert(src, (T) dest));
                }
            }
            return result;
        } catch (IllegalAccessException | InstantiationException e) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * 转换列表
     *
     * @param srcs  源对象列表
     * @param clazz 目标对象类型
     * @param <T>   目标对象类型
     * @return 拷贝完成的目标对象列表
     */
    public <T> List<T> convertListExclud(List<?> srcs, Class<T> clazz, String... fields) {
        if (srcs == null || clazz == null) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
        try {
            List<T> result = new ArrayList<>(srcs.size());
            for (Object src : srcs) {
                Object dest = clazz.newInstance();
                result.add(this.convertExclude(src, (T) dest, fields));
            }
            return result;
        } catch (IllegalAccessException | InstantiationException e) {
            throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
        }
    }

    /**
     * @return
     */
    public boolean checkFieldExist(Object src, String field) {
        return Arrays.stream(src.getClass().getDeclaredFields()).
                filter(w -> field.equals(w.getName())).count() == 0;
    }

    public List<Field> getFieldsWithAnnotaion(Field[] fields, Class annotation) {
        List<Field> result = new ArrayList<>();
        Arrays.stream(fields).forEach(item -> {
            if (Objects.nonNull(item.getAnnotation(annotation))) {
                result.add(item);
            }
        });
        return result;
    }
}
