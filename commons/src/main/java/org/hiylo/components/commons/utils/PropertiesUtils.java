/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PropertiesUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

/**
 * @author hiylo
 * @date 2019年1月2日 17:11:50
 */
public class PropertiesUtils {
    private static final Logger log = LoggerFactory.getLogger(PropertiesUtils.class);
    private static Properties props;

    {
        loadProps();
    }

    private static void loadProps() {
        props = new Properties();
        URL classPath = PropertiesUtils.class.getClass().getResource("/");
        File root = new File(Objects.requireNonNull(classPath).getFile());
        for (File file : Objects.requireNonNull(root).listFiles()) {
            loadPropsFromFile(file);
        }
    }

    private static void loadPropsFromFile(File file) {
        if (file.isDirectory()) {
            Arrays.stream(file.listFiles()).forEach(item -> loadPropsFromFile(item));
            return;
        } else if (file.getName().endsWith(".properties")) {
            FileInputStream in = null;
            try {
                in = new FileInputStream(file);
                props.load(in);
            } catch (FileNotFoundException e) {
                log.debug("{}文件未找到", file);
            } catch (IOException e) {
                log.debug("出现IOException", e);
            } finally {
                try {
                    if (null != in) {
                        in.close();
                    }
                } catch (IOException e) {
                    log.debug("properties load 出错", e);
                }
            }
        }
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}