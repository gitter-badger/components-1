/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CommonUtils.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hiylo.components.commons.encrypttools.Encrypt;
import org.hiylo.components.exceptions.CommonsRuntimeException;
import org.hiylo.components.exceptions.Constants;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
@Slf4j
public class CommonUtils {
    private final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();
    private final static String JPG = "jpg";
    private final static String BMP = "bmp";
    private final static String PNG = "png";
    private final static String GIF = "gif";
    private final static String COMMA = ",";

    static {
        getAllFileType(); // 初始化文件类型信息
    }

    public static Map<String, String> getFileTypeMap() {
        return FILE_TYPE_MAP;
    }

    public static String createToken() {
        return UUID.randomUUID().toString().replaceAll("-", "_");
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static boolean isImage(byte[] is) {
        String type = CommonUtils.getFileTypeByStream(is);
        return JPG.equals(type) || BMP.equals(type) || PNG.equals(type) || GIF.equals(type);
    }

    /**
     * Created on 2010-7-1
     * <p>
     * Discription:[getAllFileType,常见文件头信息]
     * </p>
     */
    private static void getAllFileType() {
        // JPEG (jpg)
        FILE_TYPE_MAP.put("jpg", "FFD8FF");
        // PNG (png)
        FILE_TYPE_MAP.put("png", "89504E47");
        // GIF (gif)
        FILE_TYPE_MAP.put("gif", "47494638");
        // TIFF (tif)
        FILE_TYPE_MAP.put("tif", "49492A00");
        // Windows Bitmap (bmp)
        FILE_TYPE_MAP.put("bmp", "424D");
        // CAD (dwg)
        FILE_TYPE_MAP.put("dwg", "41433130");
        // HTML (html)
        FILE_TYPE_MAP.put("html", "68746D6C3E");
        // Rich Text Format (rtf)
        FILE_TYPE_MAP.put("rtf", "7B5C727466");
        FILE_TYPE_MAP.put("xml", "3C3F786D6C");
        FILE_TYPE_MAP.put("zip", "504B0304");
        FILE_TYPE_MAP.put("rar", "52617221");
        // Photoshop (psd)
        FILE_TYPE_MAP.put("psd", "38425053");
        // Email
        FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A");
        // [thorough
        // only]
        // (eml)
        // Outlook Express (dbx)
        FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F");
        // Outlook (pst)
        FILE_TYPE_MAP.put("pst", "2142444E");
        // MS Word
        FILE_TYPE_MAP.put("xls", "D0CF11E0");
        // MS Excel 注意：word 和 excel的文件头一样
        FILE_TYPE_MAP.put("doc", "D0CF11E0");
        // MS Access (mdb)
        FILE_TYPE_MAP.put("mdb", "5374616E64617264204A");
        // WordPerfect (wpd)
        FILE_TYPE_MAP.put("wpd", "FF575043");
        FILE_TYPE_MAP.put("eps", "252150532D41646F6265");
        FILE_TYPE_MAP.put("ps", "252150532D41646F6265");
        // Adobe Acrobat (pdf)
        FILE_TYPE_MAP.put("pdf", "255044462D312E");
        // Quicken (qdf)
        FILE_TYPE_MAP.put("qdf", "AC9EBD8F");
        // Windows Password (pwl)
        FILE_TYPE_MAP.put("pwl", "E3828596");
        // Wave (wav)
        FILE_TYPE_MAP.put("wav", "57415645");
        FILE_TYPE_MAP.put("avi", "41564920");
        // Real Audio (ram)
        FILE_TYPE_MAP.put("ram", "2E7261FD");
        // Real Media (rm)
        FILE_TYPE_MAP.put("rm", "2E524D46");
        //
        FILE_TYPE_MAP.put("mpg", "000001BA");
        // Quicktime (mov)
        FILE_TYPE_MAP.put("mov", "6D6F6F76");
        // Windows Media (asf)
        FILE_TYPE_MAP.put("asf", "3026B2758E66CF11");
        // MIDI (mid)
        FILE_TYPE_MAP.put("mid", "4D546864");
    }

    /**
     * Created on 2010-7-1
     * <p>
     * Discription:[getImageFileType,获取图片文件实际类型,若不是图片则返回null]
     * </p>
     *
     * @param f
     * @return fileType
     */
    public static String getImageFileType(File f) {
        if (isImage(f)) {
            try {
                ImageInputStream iis = ImageIO.createImageInputStream(f);
                Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
                if (!iter.hasNext()) {
                    return null;
                }
                ImageReader reader = iter.next();
                iis.close();
                return reader.getFormatName();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * Created on 2010-7-1
     * <p>
     * Discription:[getFileByFile,获取文件类型,包括图片,若格式不是已配置的,则返回null]
     * </p>
     *
     * @param file
     * @return fileType
     */
    public static String getFileByFile(File file) {
        String filetype = null;
        byte[] b = new byte[50];
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int i = is.read(b);
            if (i != -1) {
                filetype = getFileTypeByStream(b);
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(is)) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filetype;
    }

    /**
     * Created on 2010-7-1
     * <p>
     * Discription:[getFileTypeByStream]
     * </p>
     *
     * @param b
     * @return fileType
     */
    public static String getFileTypeByStream(byte[] b) {
        String filetypeHex = String.valueOf(getFileHexString(b));
        for (Entry<String, String> entry : FILE_TYPE_MAP.entrySet()) {
            String fileTypeHexValue = entry.getValue();
            if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Created on 2010-7-2
     * <p>
     * Discription:[isImage,判断文件是否为图片]
     * </p>
     *
     * @param file
     * @return true 是 | false 否
     */
    public static boolean isImage(File file) {
        boolean flag = false;
        try {
            BufferedImage bufreader = ImageIO.read(file);
            int width = bufreader.getWidth();
            int height = bufreader.getHeight();
            flag = width != 0 && height != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * Created on 2010-7-1
     * <p>
     * Discription:[getFileHexString]
     * </p>
     *
     * @param b
     * @return fileTypeHex
     */
    public static String getFileHexString(byte[] b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (b == null || b.length <= 0) {
            return null;
        }
        for (byte aB : b) {
            int v = aB & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String firstChatToUpcase(String word) {
        String result = word.substring(0, 1).toUpperCase();
        result += word.substring(1);
        return result;
    }

    /**
     * 将数组的字符串格式转换回为数组
     *
     * @param str 格式为"[]"
     * @return
     */
    public static List<Integer> convertStringToList(String str) {
        // 去除空格
        str = str.replace(" ", "").replace("[", "").replace("]", "");
        LinkedList<Integer> list = new LinkedList<>();
        // 判断是否为空
        if (!"".equals(str) && str.length() > 0) {
            if (str.contains(COMMA)) {
                String[] strArr = str.split(",");
                for (String val : strArr) {
                    list.add(Integer.parseInt(val));
                }
            } else {
                list.add(Integer.parseInt(str));
            }
        }
        return list;
    }

    /**
     * 将Json对象转化为XML格式字符串
     *
     * @param jsonObject json对象
     * @return 被转化后的xml字符串
     */
    public static String jsonToXml(JSONObject jsonObject) {
        StringBuilder xmlStr = new StringBuilder();
        for (Object key : jsonObject.keySet()) {
            try {
                JSONObject sonJson = JSONObject.fromObject(jsonObject.get(key));
                xmlStr.append("<").append(key).append(">").append(CommonUtils.jsonToXml(sonJson)).append("</").append(key).append(">");
            } catch (Exception e) {
                xmlStr.append("<").append(key).append(">").append(jsonObject.get(key)).append("</").append(key).append(">");
            }
        }
        return xmlStr.toString();
    }

    /**
     * map转xml字符串(包含<![CDATA[DATA]]>)
     *
     * @param map 被转化对象
     * @return 被转化后的xml字符串
     */
    public static String mapToXml(Map map) {
        StringBuffer xmlBuffer = new StringBuffer();
        mapToXmlCycle(map, xmlBuffer);
        return xmlBuffer.toString();
    }

    /**
     * map转xml字符串内部方法
     *
     * @param map
     * @param xmlBuffer
     */
    private static void mapToXmlCycle(Map map, StringBuffer xmlBuffer) {
        for (Entry e : (Iterable<Entry>) map.entrySet()) {
            String key = e.getKey().toString();
            Object value = e.getValue();
            if (null == value) {
                value = "";
            }
            if (Objects.nonNull(value.getClass().getName()) && value instanceof ArrayList) {
                ArrayList list = (ArrayList) map.get(key);
                xmlBuffer.append("<").append(key).append(">");
                for (Object aList : list) {
                    mapToXmlCycle((Map) aList, xmlBuffer);
                }
                xmlBuffer.append("</").append(key).append(">");

            } else {
                if (value instanceof HashMap) {
                    xmlBuffer.append("<").append(key).append(">");
                    mapToXmlCycle((HashMap) value, xmlBuffer);
                    xmlBuffer.append("</").append(key).append(">");
                } else if (value instanceof TreeMap) {
                    xmlBuffer.append("<").append(key).append(">");
                    mapToXmlCycle((TreeMap) value, xmlBuffer);
                    xmlBuffer.append("</").append(key).append(">");
                } else {
                    xmlBuffer.append("<").append(key).append("><![CDATA[").append(value).append("]]></").append(key).append(">");
                }
            }
        }
    }

    /**
     * xml转化为map
     *
     * @param xmlStr       xml字符串
     * @param baseNodeName 根节点
     * @return 被转化成map格式的对象
     * @throws Exception
     */
    public static Map<String, Map<String, Object>> xml2Map(String xmlStr, String baseNodeName) throws DocumentException, SAXException {
        Document document = null;
        SAXReader reader = new SAXReader();
        String feature = null;
        feature = "http://apache.org/xml/features/disallow-doctype-decl";
        reader.setFeature(feature, true);
        feature = "http://xml.org/sax/features/external-general-entities";
        reader.setFeature(feature, false);
        feature = "http://xml.org/sax/features/external-parameter-entities";
        reader.setFeature(feature, false);
        feature = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
        reader.setFeature(feature, false);
        String encoding = getEncoding(xmlStr);
        InputSource source = new InputSource(new StringReader(xmlStr));
        source.setEncoding(encoding);
        document = reader.read(source);
        HashMap<String, Map<String, Object>> nodeMap = new HashMap<>(0, 0.75F);
        Element rootElement = document.getRootElement();
        if (baseNodeName.equals(rootElement.getName())) {
            nodeMap.put(baseNodeName, CommonUtils.getChildElements(rootElement.elements()));
            return nodeMap;
        } else {
            throw new RuntimeException("wrong baseNodeName");
        }
    }

    private static String getEncoding(String text) {
        String result = null;
        String xml = text.trim();
        if (xml.startsWith("<?xml")) {
            int end = xml.indexOf("?>");
            String sub = xml.substring(0, end);
            StringTokenizer tokens = new StringTokenizer(sub, " =\"\'");
            while (tokens.hasMoreTokens()) {
                String token = tokens.nextToken();
                if ("encoding".equals(token)) {
                    if (tokens.hasMoreTokens()) {
                        result = tokens.nextToken();
                    }
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 将元素集合转化为map格式
     *
     * @param childElements 元素集合
     * @return 被转化后的map对象
     */
    public static Map<String, Object> getChildElements(List<Element> childElements) {
        HashMap<String, Object> nodeMap = new HashMap<>(0, 0.75F);
        for (Element element : childElements) {
            if (element.elements().size() == 0) {
                if (Objects.nonNull(element.attribute("name"))) {
                    nodeMap.put(element.attribute("name").getStringValue(), element.getStringValue());
                } else {
                    nodeMap.put(element.getName(), element.getStringValue());
                }
            } else {
                nodeMap.put(element.getName(), CommonUtils.getChildElements(element.elements()));
            }
        }
        return nodeMap;
    }

    /**
     * 对map参数按照首字母排序进行MD5加密
     *
     * @param paramMap  请求参数Map
     * @param md5Key    加密密钥
     * @param upperCase 结果时候转大写
     * @return 加密字符串结果
     */
    public static String signWithMd5(Map<String, Object> paramMap, String md5Key, Boolean upperCase) throws UnsupportedEncodingException {
        if (Objects.nonNull(upperCase) && upperCase) {
            return Encrypt.Md5.sign(CommonUtils.createSignParam(paramMap), md5Key, "utf-8").toUpperCase();
        } else if (Objects.nonNull(upperCase) && !upperCase) {
            return Encrypt.Md5.sign(CommonUtils.createSignParam(paramMap), md5Key, "utf-8").toLowerCase();
        } else {
            return Encrypt.Md5.sign(CommonUtils.createSignParam(paramMap), md5Key, "utf-8");
        }
    }

    /**
     * 对map参数按照首字母排序进行MD5加密
     *
     * @param paramMap 请求参数Map
     * @param md5Key   加密密钥
     * @return 加密字符串结果
     */
    public static String signWithMd5(Map<String, Object> paramMap, String md5Key) throws UnsupportedEncodingException {
        return signWithMd5(paramMap, md5Key, null);
    }

    public static String sign(Map<String, Object> paramMap, String signType, String key) throws UnsupportedEncodingException {
        if ("MD5".equals(signType)) {
            return signWithMd5(paramMap, key, null);
        } else if ("SHA256".equals(signType)) {
            try {
                return Encrypt.Sha256.hmacSHA256(CommonUtils.createSignParam(paramMap), key);
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
                log.error("签名", e);
            }
        }
        throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL);
    }

    /**
     * 对代签名参数进行排序并组装(空值字段不参与排序)
     *
     * @param paramMap 签名参数map格式
     * @return 组装好的签名字符串
     */
    public static String createSignParam(Map<String, Object> paramMap) throws UnsupportedEncodingException {
        StringBuilder signStr = new StringBuilder();
        Map<String, Object> paramTreeMap = new TreeMap<String, Object>(paramMap);
        for (String key : paramMap.keySet()) {
            if (Objects.nonNull(paramTreeMap.get(key)) && StringUtils.isNotEmpty(paramTreeMap.get(key) + "")) {
                signStr.append(key).append("=").append(URLEncoder.encode(String.valueOf(paramTreeMap.get(key)), "UTF-8")).append("&");
            }
        }
        return signStr.substring(0, signStr.length() - 1);
    }

    /**
     * 去掉字符串最后一位字符
     *
     * @param character 需要操作的字符串
     * @return 操作之后的字符串
     */
    public static String removeLatestCharacter(String character) {
        return character.substring(0, character.length() - 1);
    }

    /**
     * map转成url请求字符串
     *
     * @param map 请求参数
     * @return 转换完成的string
     */
    public static String mapToUriVariables(Map<String, String> map) {
        StringBuilder result = new StringBuilder();
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (Objects.nonNull(map.get(key))) {
                result.append(key).append("=").append(map.get(key)).append("&");
            }
        }
        return removeLatestCharacter(result.toString());
    }

    public static String getNonceStr() {
        String currTime = DateUtils.formatDateToCustom(new Date(), "yyyyMMdd");
        String strTime = currTime.substring(8);
        String strRandom = String.valueOf(buildRandom(4));
        String strReq = strTime + strRandom;
        return strReq;
    }

    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1D) {
            random += 0.1D;
        }
        for (int i = 0; i < length; i++) {
            num *= 10;
        }
        return (int) (random * num);
    }
}
