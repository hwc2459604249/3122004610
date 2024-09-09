package com.chao.utils;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void readFile() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        String file = FileUtil.readFile("src/test/resources/orgt.txt");
        assertEquals(file, "今天天气晴，我想要找人打乒乓球");

    }
}