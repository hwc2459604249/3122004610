package com.chao.Utils;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class UtilText {
    @Test
    public void test() {
        String t;
        String a;
        try {
            t = FileUtil.readFile("D:\\桌面\\java_text\\orig.txt");
            a = FileUtil.readFile("D:\\桌面\\java_text\\orig_0.8_add.txt");
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
