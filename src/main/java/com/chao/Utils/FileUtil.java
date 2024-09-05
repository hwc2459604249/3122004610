package com.chao.Utils;

import java.io.FileInputStream;
import java.io.IOException;

public class FileUtil {
    public static String readFile(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] bytes = fis.readAllBytes();
            return new String(bytes);
        }
    }
}
