/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Encrypt.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.encrypttools;

import org.apache.commons.codec.digest.DigestUtils;
import org.hiylo.components.commons.utils.StringUtils;
import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;
import java.util.Optional;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class Encrypt {
    private final static String DEFAULT_ENCODING = "UTF-8";
    private static Logger log = LoggerFactory.getLogger(Encrypt.class.getName());

    public enum SignType {
        /**
         * MD5方式
         */
        MD5,
        /**
         * SHA256
         */
        HMACSHA256,
        /**
         * SHA1
         */
        SHA1;

        SignType() {
        }
    }

    public static class Md5 {
        /**
         * 签名字符串
         *
         * @param text    需要签名的字符串
         * @param key     密钥
         * @param charset 编码格式
         * @return 签名结果
         */
        public static String sign(String text, String key, String charset) {
            text = text + key;
            return DigestUtils.md5Hex(getContentBytes(text, charset));
        }

        /**
         * 签名字符串
         *
         * @param text    需要签名的字符串
         * @param sign    签名结果
         * @param key     密钥
         * @param charset 编码格式
         * @return 签名结果
         */
        public static boolean verify(String text, String sign, String key, String charset) {
            text = text + key;
            String mysign = DigestUtils.md5Hex(getContentBytes(text, charset));
            return mysign.equals(sign);
        }

        /**
         * 将字符串转成指定字符集的Byte数组
         *
         * @param content 需要转换的内容
         * @param charset 指定字符集
         * @return 转换之后的byte数组
         */
        private static byte[] getContentBytes(String content, String charset) {
            if (charset == null || "".equals(charset)) {
                try {
                    return content.getBytes(DEFAULT_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    log.debug("encrypt", e);
                }
            }
            try {
                return content.getBytes(Objects.requireNonNull(charset));
            } catch (UnsupportedEncodingException e) {
                throw CommonsRuntimeException.<CommonsRuntimeException>buildException(Constants.EXCEPTION_CODE_EINVAL);
            }
        }
    }

    /**
     * @author hiylo
     * @date 2017年10月19日 08:09:34
     */
    public static class Rsa {

        public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

        /**
         * RSA签名
         *
         * @param content    待签名数据
         * @param privateKey 商户私钥
         * @param charset    编码格式
         * @return 签名值
         */
        public static String signWithPrivateKey(String content, String privateKey, String charset) {
            try {
                PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
                KeyFactory keyf = KeyFactory.getInstance("RSA");
                PrivateKey priKey = keyf.generatePrivate(priPKCS8);
                java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

                signature.initSign(priKey);
                signature.update(content.getBytes(charset));

                byte[] signed = signature.sign();

                return Base64.encode(signed);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * TODO plainBytes.getBytes() 需要修改
         *
         * @param plainBytes
         * @param publicKey
         * @param reserveSize
         * @param cipherAlgorithm
         * @return
         * @throws Exception
         */
        public static byte[] encrypt(String plainBytes, String publicKey, int reserveSize, String cipherAlgorithm) {
            int keyByteSize = publicKey.length() / 8;
            int encryptBlockSize = keyByteSize - reserveSize;
            int nBlock = plainBytes.getBytes().length / encryptBlockSize;
            if ((plainBytes.getBytes().length % encryptBlockSize) != 0) {
                nBlock += 1;
            }
            ByteArrayOutputStream outbuf = null;
            try {
                Cipher cipher = Cipher.getInstance(cipherAlgorithm);
                cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));

                outbuf = new ByteArrayOutputStream(nBlock * keyByteSize);
                for (int offset = 0; offset < plainBytes.getBytes().length; offset += encryptBlockSize) {
                    int inputLen = plainBytes.getBytes().length - offset;
                    if (inputLen > encryptBlockSize) {
                        inputLen = encryptBlockSize;
                    }
                    byte[] encryptedBlock = cipher.doFinal(plainBytes.getBytes(), offset, inputLen);
                    outbuf.write(encryptedBlock);
                }
                outbuf.flush();
                return outbuf.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException("ENCRYPT ERROR:", e);
            } finally {
                Optional.ofNullable(outbuf).ifPresent(byteArrayOutputStream -> {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException("CLOSE ByteArrayOutputStream ERROR:", e);
                    }
                });
                outbuf = null;
            }
        }

        /**
         * RSA签名
         *
         * @param content   待签名数据
         * @param publicKey 商户私钥
         * @param charset   编码格式
         * @return 签名值
         */
        public static String signWithPublicKey(String content, String publicKey, String charset) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(getPublicKey(publicKey).getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pk = keyFactory.generatePublic(x509EncodedKeySpec);
            //初始化加密
            //Cipher类为加密和解密提供密码功能，通过getinstance实例化对象
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pk);
            //加密字符串
            byte[] result = cipher.doFinal(content.getBytes());
            return Base64.encode(result);
        }

        /**
         * RSA验签名检查
         *
         * @param content   待签名数据
         * @param sign      签名值
         * @param publicKey 支付宝公钥
         * @param charset   编码格式
         * @return 布尔值
         */
        public static boolean verify(String content, String sign, String publicKey, String charset) {
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                byte[] encodedKey = Base64.decode(publicKey);
                PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

                java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

                signature.initVerify(pubKey);
                signature.update(content.getBytes(charset));
                boolean bverify = signature.verify(Base64.decode(sign));
                return bverify;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
         * 解密
         *
         * @param content    密文
         * @param privateKey 商户私钥
         * @param charset    编码格式
         * @return 解密后的字符串
         */
        public static String decrypt(String content, String privateKey, String charset) throws Exception {
            PrivateKey prikey = getPrivateKey(privateKey);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, prikey);

            InputStream ins = new ByteArrayInputStream(Base64.decode(content));
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            // rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
            byte[] buf = new byte[128];
            int bufl;

            while ((bufl = ins.read(buf)) != -1) {
                byte[] block = null;

                if (buf.length == bufl) {
                    block = buf;
                } else {
                    block = new byte[bufl];
                    for (int i = 0; i < bufl; i++) {
                        block[i] = buf[i];
                    }
                }

                writer.write(cipher.doFinal(block));
            }

            return new String(writer.toByteArray(), charset);
        }

        /**
         * 得到私钥
         *
         * @param key 密钥字符串（经过base64编码）
         * @throws Exception
         */
        public static PrivateKey getPrivateKey(String key) throws Exception {
            byte[] keyBytes;
            keyBytes = Base64.decode(key);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
        }

        public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
            byte[] keyBytes = Base64.decode(publicKey);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) keyFactory.generatePublic(spec);
        }
    }

    public static class Sha1 {
        public static String encript(String decript) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                try {
                    digest.update(decript.getBytes(DEFAULT_ENCODING));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] messageDigest = digest.digest();
                // Create Hex String
                StringBuffer hexString = new StringBuffer();
                // 字节数组转换为 十六进制 数
                for (int i = 0; i < messageDigest.length; i++) {
                    String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                    if (shaHex.length() < 2) {
                        hexString.append(0);
                    }
                    hexString.append(shaHex);
                }
                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return "";
        }

        public static String encript(String decript, String charset) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                try {
                    if (StringUtils.isNotEmpty(charset)) {
                        digest.update(decript.getBytes(charset));
                    } else {
                        digest.update(decript.getBytes(DEFAULT_ENCODING));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] messageDigest = digest.digest();
                // Create Hex String
                StringBuffer hexString = new StringBuffer();
                // 字节数组转换为 十六进制 数
                for (int i = 0; i < messageDigest.length; i++) {
                    String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                    if (shaHex.length() < 2) {
                        hexString.append(0);
                    }
                    hexString.append(shaHex);
                }
                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static class Sha256 {
        public static String hmacSHA256(String data, String key) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(DEFAULT_ENCODING), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] array = sha256_HMAC.doFinal(data.getBytes(DEFAULT_ENCODING));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString().toUpperCase();
        }

        public static String sha256(String sortedParams) throws NoSuchAlgorithmException {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(sortedParams.getBytes());
            byte byteBuffer[] = messageDigest.digest();
            StringBuffer strHexString = new StringBuffer();
            for (int i = 0; i < byteBuffer.length; i++) {
                String hex = Integer.toHexString(0xff & byteBuffer[i]);
                if (hex.length() == 1) {
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }
            // 得到返回結果
            return strHexString.toString();
        }
    }
}
