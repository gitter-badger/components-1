/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : PasswordUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.encrypttools;

import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author hiylo
 * @date 2018年8月26日 11:45:15
 */
public class PasswordUtils {
    private static final String KEY = "epai";
    private static Logger log = LoggerFactory.getLogger(PasswordUtils.class.getClass());

    private PasswordUtils() {

    }

    public static String generateMd5Password(String password) {
        int end = password.length() > 15 ? 15 : password.length();
        int begin = end > 10 ? 10 : (end <= 5 ? 0 : end - 5);
        return Encrypt.Md5.sign(password.substring(begin, end), KEY, "utf-8");
    }

    public static String generateHmacSHA256Password(String password) {
        try {
            int end = password.length() > 15 ? 15 : password.length();
            int begin = end > 10 ? 10 : (end <= 5 ? 0 : end - 5);
            return Encrypt.Sha256.hmacSHA256(password.substring(begin, end), KEY);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            log.debug("password", e);
        }
        throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_UNKNOWN_ERROR);
    }

    public static String generateSha1Password(String password) {
        int end = password.length() > 15 ? 15 : password.length();
        int begin = end > 10 ? 10 : (end <= 5 ? 0 : end - 5);
        return Encrypt.Sha1.encript(password.substring(begin, end));
    }
}
