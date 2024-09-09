package com.chao.utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;


import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/*
利用IK分词器对中文文档进行分词
 */
public class IKUtil {


    public static Map<String, Integer> segment(String location) {
        Map<String, Integer> map = new HashMap<>();
        try (StringReader reader = new StringReader(location)) {
            IKSegmenter ikSegmenter = new IKSegmenter(reader, true);
            Lexeme lexeme;
            while ((lexeme = ikSegmenter.next()) != null) {
                String lexemeText = lexeme.getLexemeText();
                //使用map存储向量
                if (!map.containsKey(lexemeText)) {
                    map.put(lexemeText, 1);
                } else {
                    map.put(lexemeText, map.get(lexemeText) + 1);
                }
                //System.out.println(lexemeText);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return map;
    }
}
