/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : SetUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author hiylo
 * @date 2019年1月2日 17:41:23
 */
public class SetUtils {
    public static <T> T first(Set<T> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        Iterator<T> iterator = set.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    public static <T> T latest(Set<T> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        Object object = null;
        for (T t : set) {
            object = t;
        }
        return (T) object;
    }

    public static boolean isLatest(Set<?> set, Object object) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        Object latest = null;
        for (Object o : set) {
            latest = o;
        }
        return object.hashCode() == Objects.requireNonNull(latest).hashCode();
    }
}
