package org.hiylo.components.commons.rar;

import com.github.junrar.Junrar;
import com.github.junrar.exception.RarException;

import java.io.IOException;

/**
 * @author Hsi Chu
 * @date 2021年2月27日 16:33:29
 */
public class Rar {
    public static void unrar(String rarFile, String outputFolder) throws IOException, RarException {
        Junrar.extract(rarFile, outputFolder);
    }
}
