package com.chao.Utils;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CosineUtilTest {
  static  Map<String,Integer> map = new HashMap<>();
    @BeforeClass
    public static void init(){
        map.put("a",2);
        map.put("b",3);
       // map.put("c",0);
        map.put("d",1);
        CosineUtil.initOrg(map);
    }
    @Test
    public void getOrgVectorLength() {
        double orgVectorLength = CosineUtil.getOrgVectorLength();
        assertEquals(Math.sqrt(4+9+1),orgVectorLength,0.01);
    }
    @Test
    public void getVectorLength() {
        double vectorLength = CosineUtil.getVectorLength(map);
        assertEquals(Math.sqrt(4+9+1),vectorLength,0.01);
        assertEquals(0.00,CosineUtil.getVectorLength(null),0.01);
    }
    @Test
    public void initOrg() {
        double orgVectorLength = CosineUtil.getOrgVectorLength();
        double vectorLength = CosineUtil.getVectorLength(map);
        assertEquals(orgVectorLength,vectorLength,0.01);
    }



    @Test
    public void getDotProduct() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a",0);
        hashMap.put("b",3);
        hashMap.put("c",4);
        hashMap.put("d",1);
        hashMap.put("e",2);
        Integer dotProduct = CosineUtil.getDotProduct(hashMap, map);
        /*  (2,3,0,1,0)
            (0,3,4,1,2)
        * */
        assertNull(CosineUtil.getDotProduct(null));
        assertEquals(10,(long)dotProduct);
        assertEquals(dotProduct,CosineUtil.getDotProduct(hashMap));

    }


}