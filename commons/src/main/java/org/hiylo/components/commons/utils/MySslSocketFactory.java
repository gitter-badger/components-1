/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : MySslSocketFactory.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import org.apache.http.conn.ssl.SSLSocketFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.*;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class MySslSocketFactory extends SSLSocketFactory {
    private static MySslSocketFactory mySslSocketFactory = null;

    public MySslSocketFactory(KeyStore truststore) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        super(truststore);
    }

    private static SSLContext createSContext() {
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sslcontext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, null);
        } catch (KeyManagementException e) {
            e.printStackTrace();
            return null;
        }
        return sslcontext;
    }

}