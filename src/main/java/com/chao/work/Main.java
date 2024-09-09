package com.chao.work;

import com.chao.utils.CosineUtil;
import com.chao.utils.FileUtil;
import com.chao.utils.IKUtil;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length == 3) {
            double make = make(args);
            System.out.println(make);
        }


    }

    public static double make(String[] args) {
        //获取文件路径
        String orgText = args[0];
        String notOrgText = args[1];
        String ansText = args[2];
        //读取文件内容
        try {
            orgText = FileUtil.readFile(orgText);
            notOrgText = FileUtil.readFile(notOrgText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //将文件内容分词成向量
        Map<String, Integer> map = IKUtil.segment(orgText);
        Map<String, Integer> map1 = IKUtil.segment(notOrgText);
        //将某一向量作为源文件
        CosineUtil.initOrg(map);
        //开始计算余弦相似度
        double orgVectorLength = CosineUtil.getOrgVectorLength();
        double vectorLength = CosineUtil.getVectorLength(map1);
        Integer dotProduct = CosineUtil.getDotProduct(map1);
        double ans = dotProduct / orgVectorLength / vectorLength;
        //写入指定文件
        try {
            String context = args[0] + " vs " + args[1] + " : " + String.format("%.2f", ans) + "\n";
            FileUtil.writeFile(ansText, context);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
}
