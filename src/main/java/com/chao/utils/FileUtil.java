package com.chao.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
    //读取文件内容转化为字符串
    public static String readFile(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] bytes = fis.readAllBytes();
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    //写入文件
    public static void writeFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        //一般正常的路径不存在也可生成文件
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                boolean mkdirs = file.getParentFile().mkdirs();
                if (!mkdirs) {
                    System.out.println("创建父目录失败");
                    return;
                }
            }
            if (!file.createNewFile()) {
                System.out.println("创建文件失败");
                return;
            }
        }
        //开启追加模式
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(content.getBytes());
            fos.flush();
        }
    }
}
