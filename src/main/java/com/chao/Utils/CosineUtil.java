package com.chao.Utils;

import java.util.Map;

/**
 * @author 黄文超
 * @version 1.0
 * 使用余弦相似度算法计算相似度
 */
public class CosineUtil {
    //原始文件向量
    private static Map<String, Integer> org;
    private static double orgVectorLength;

    //注入原始文件
    public static void initOrg(Map<String, Integer> map) {
        org = map;
        orgVectorLength = getVectorLength(map);
    }

    //获取原始文件向量模
    public static double getOrgVectorLength() {
        return orgVectorLength;
    }

    //获取向量模
    public static double getVectorLength(Map<String, Integer> map) {
        if (map == null) {
            return 0.0;
        }
        double ans = 0.0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans += Math.pow(entry.getValue(), 2);
        }
        return Math.sqrt(ans);
    }

    //获取两向量点积
    public static Integer getDotProduct(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1 == null || map2 == null) {
            return null;
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            Integer i = map2.get(entry.getKey());
            if (i != null) {
                ans += entry.getValue() * i;
            }
        }
        return ans;
    }

    //获得该向量与原始向量的点积
    public static Integer getDotProduct(Map<String, Integer> map) {
        return getDotProduct(org, map);
    }
}
