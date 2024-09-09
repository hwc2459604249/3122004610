package com.chao.work;

import org.junit.Test;

public class MainTest {

    @Test
    public void make() {
        String[] strings = {"src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
                "src/test/resources/ans.txt"};
        String[] strings1 = {"src/main/resources/orig.txt",
                "src/main/resources/orig_0.8_add.txt",
                "src/test/resources/ans.txt/ss"};
        String[] strings2 = {"src/main/resources/orig.txt",
                "src/main/resources/orig.txt",
                "src/test/resources/ans/ans.txt"};

        Main.make(strings);
        Main.make(strings1);
        Main.make(strings2);
    }
}