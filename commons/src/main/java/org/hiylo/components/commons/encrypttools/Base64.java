/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Base64.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.encrypttools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public final class Base64 {
    private static final int BASELENGTH = 128;
    private static final int LOOKUPLENGTH = 64;
    private static final int TWENTYFOURBITGROUP = 24;
    private static final int EIGHTBIT = 8;
    private static final int SIXTEENBIT = 16;
    private static final int FOURBYTE = 4;
    private static final int SIGN = -128;
    private static final char PAD = '=';
    private static final byte[] BASE64_ALPHABET = new byte[BASELENGTH];
    private static final char[] LOOK_UP_BASE64_ALPHABET = new char[LOOKUPLENGTH];
    private static Logger log = LoggerFactory.getLogger(Base64.class.getClass().getName());

    static {
        for (int i = 0; i < BASELENGTH; ++i) {
            BASE64_ALPHABET[i] = -1;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - 'a' + 26);
        }

        for (int i = '9'; i >= '0'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - '0' + 52);
        }

        BASE64_ALPHABET['+'] = 62;
        BASE64_ALPHABET['/'] = 63;

        for (int i = 0; i <= 25; i++) {
            LOOK_UP_BASE64_ALPHABET[i] = (char) ('A' + i);
        }

        for (int i = 26, j = 0; i <= 51; i++, j++) {
            LOOK_UP_BASE64_ALPHABET[i] = (char) ('a' + j);
        }

        for (int i = 52, j = 0; i <= 61; i++, j++) {
            LOOK_UP_BASE64_ALPHABET[i] = (char) ('0' + j);
        }
        LOOK_UP_BASE64_ALPHABET[62] = '+';
        LOOK_UP_BASE64_ALPHABET[63] = '/';

    }

    private Base64() {

    }

    private static boolean isWhiteSpace(char octect) {
        return (octect == 0x20 || octect == 0xd || octect == 0xa || octect == 0x9);
    }

    private static boolean isPad(char octect) {
        return (octect == PAD);
    }

    private static boolean isData(char octect) {
        return (octect < BASELENGTH && BASE64_ALPHABET[octect] != -1);
    }

    /**
     * Encodes hex octects into Base64
     *
     * @param binaryData Array containing binaryData
     * @return Encoded Base64 array
     */
    public static String encode(byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }
        int lengthDataBits = binaryData.length * EIGHTBIT;
        if (lengthDataBits == 0) {
            return "";
        }
        int fewerThan24bits = lengthDataBits % TWENTYFOURBITGROUP;
        int numberTriplets = lengthDataBits / TWENTYFOURBITGROUP;
        int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1 : numberTriplets;
        char[] encodedData = null;
        encodedData = new char[numberQuartet * 4];
        byte k = 0, l = 0, b1 = 0, b2 = 0, b3 = 0;
        int encodedIndex = 0;
        int dataIndex = 0;
        log.debug("number of triplets = {}", numberTriplets);
        for (int i = 0; i < numberTriplets; i++) {
            b1 = binaryData[dataIndex++];
            b2 = binaryData[dataIndex++];
            b3 = binaryData[dataIndex++];
            log.debug("b1={}, b2= {}, b3= {}", b1, b2, b3);
            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);
            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
            byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) : (byte) ((b2) >> 4 ^ 0xf0);
            byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6) : (byte) ((b3) >> 6 ^ 0xfc);
            log.debug("val2 = {}", val2);
            log.debug("k4   = {}", (k << 4));
            log.debug("vak  = {}", (val2 | (k << 4)));
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[val1];
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[val2 | (k << 4)];
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[(l << 2) | val3];
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[b3 & 0x3f];
        }

        // form integral number of 6-bit groups
        if (fewerThan24bits == EIGHTBIT) {
            b1 = binaryData[dataIndex];
            k = (byte) (b1 & 0x03);
            log.debug("b1 = {}", b1);
            log.debug("b1<<2 = {}", (b1 >> 2));
            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[val1];
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[k << 4];
            encodedData[encodedIndex++] = PAD;
            encodedData[encodedIndex++] = PAD;
        } else if (fewerThan24bits == SIXTEENBIT) {
            b1 = binaryData[dataIndex];
            b2 = binaryData[dataIndex + 1];
            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
            byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) : (byte) ((b2) >> 4 ^ 0xf0);

            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[val1];
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[val2 | (k << 4)];
            encodedData[encodedIndex++] = LOOK_UP_BASE64_ALPHABET[l << 2];
            encodedData[encodedIndex++] = PAD;
        }

        return new String(encodedData);
    }

    /**
     * Decodes Base64 data into octects
     *
     * @param encoded string containing Base64 data
     * @return Array containind decoded data.
     */
    public static byte[] decode(String encoded) {
        if (encoded == null) {
            return null;
        }
        char[] base64Data = encoded.toCharArray();
        int len = removeWhiteSpace(base64Data);
        if (len % FOURBYTE != 0) {
            // should be divisible by four
            return null;
        }
        int numberQuadruple = (len / FOURBYTE);
        if (numberQuadruple == 0) {
            return new byte[0];
        }
        byte[] decodedData = null;
        byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
        char d1 = 0, d2 = 0, d3 = 0, d4 = 0;
        int i = 0;
        int encodedIndex = 0;
        int dataIndex = 0;
        decodedData = new byte[(numberQuadruple) * 3];
        for (; i < numberQuadruple - 1; i++) {
            if (!isData((d1 = base64Data[dataIndex++])) || !isData((d2 = base64Data[dataIndex++]))
                    || !isData((d3 = base64Data[dataIndex++])) || !isData((d4 = base64Data[dataIndex++]))) {
                return null;
            }
            b1 = BASE64_ALPHABET[d1];
            b2 = BASE64_ALPHABET[d2];
            b3 = BASE64_ALPHABET[d3];
            b4 = BASE64_ALPHABET[d4];

            decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
            decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
            decodedData[encodedIndex++] = (byte) (b3 << 6 | b4);
        }
        if (!isData((d1 = base64Data[dataIndex++])) || !isData((d2 = base64Data[dataIndex++]))) {
            return null;
        }
        b1 = BASE64_ALPHABET[d1];
        b2 = BASE64_ALPHABET[d2];
        d3 = base64Data[dataIndex++];
        d4 = base64Data[dataIndex++];
        if (!isData((d3)) || !isData((d4))) {
            if (isPad(d3) && isPad(d4)) {
                if ((b2 & 0xf) != 0) {
                    return null;
                }
                byte[] tmp = new byte[i * 3 + 1];
                System.arraycopy(decodedData, 0, tmp, 0, i * 3);
                tmp[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                return tmp;
            } else if (!isPad(d3) && isPad(d4)) {
                b3 = BASE64_ALPHABET[d3];
                if ((b3 & 0x3) != 0) {
                    return null;
                }
                byte[] tmp = new byte[i * 3 + 2];
                System.arraycopy(decodedData, 0, tmp, 0, i * 3);
                tmp[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
                tmp[encodedIndex] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
                return tmp;
            } else {
                return null;
            }
        } else { // No PAD e.g 3cQl
            b3 = BASE64_ALPHABET[d3];
            b4 = BASE64_ALPHABET[d4];
            decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
            decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
            decodedData[encodedIndex++] = (byte) (b3 << 6 | b4);
        }

        return decodedData;
    }

    /**
     * remove WhiteSpace from MIME containing encoded Base64 data.
     *
     * @param data the byte array of base64 data (with WS)
     * @return the new length
     */
    private static int removeWhiteSpace(char[] data) {
        if (data == null) {
            return 0;
        }

        // count characters that's not whitespace
        int newSize = 0;
        int len = data.length;
        for (int i = 0; i < len; i++) {
            if (!isWhiteSpace(data[i])) {
                data[newSize++] = data[i];
            }
        }
        return newSize;
    }
}
