package com.chao.utils;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class UtilTest {
    @Test
    public void test() {
        String t;
        String a;
        try {
            t = FileUtil.readFile("src/main/resources/orig.txt");
            a = FileUtil.readFile("src/main/resources/orig_0.8_add.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, Integer> map = IKUtil.segment(t);
        Map<String, Integer> map1 = IKUtil.segment(a);
        CosineUtil.initOrg(map);
        double orgVectorLength = CosineUtil.getOrgVectorLength();
        double vectorLength = CosineUtil.getVectorLength(map1);
        Integer dotProduct = CosineUtil.getDotProduct(map1);
        System.out.println(dotProduct / orgVectorLength / vectorLength);
    }
}
