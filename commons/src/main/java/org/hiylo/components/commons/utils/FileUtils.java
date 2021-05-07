package org.hiylo.components.commons.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Hsi Chu
 * @date 2021年2月26日 13:56:56
 */
public class FileUtils {

    public static String getTextContent(String path) throws IOException {
        return org.apache.commons.io.FileUtils.readFileToString(new File(path), Charset.defaultCharset());
    }

    public static boolean writeTextContentToFile(String content, String path) throws IOException {
        return writeTextContentToFile(content, path, false);
    }

    public static boolean writeTextContentToFile(String content, String path, boolean append) throws IOException {
        org.apache.commons.io.FileUtils.write(new File(path), content, Charset.defaultCharset(), append);
        return true;
    }


}
