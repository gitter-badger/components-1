/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PasswordUtilsTest.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.encrypttools;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class PasswordUtilsTest {

    @Test
    public void generateMd5Password() {
        log.debug(PasswordUtils.generateMd5Password("1"));
    }

    @Test
    public void generateHmacSHA256Password() {
        log.debug(PasswordUtils.generateHmacSHA256Password("1"));
    }

    @Test
    public void generateSha1Password() {
        log.debug(PasswordUtils.generateSha1Password("1"));
    }
}