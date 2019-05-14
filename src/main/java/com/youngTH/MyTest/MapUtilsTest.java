package com.youngTH.MyTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author YoungTH
 * @date 2019/4/9
 */
public class MapUtilsTest {
    private static Map<String,String> ssMap=new HashMap();
    static {
        ssMap.put("ak","av");
        ssMap.put("bk","bv");
        ssMap.put("ck","cv");
    }
    @Test
    public void fun1(){

        Iterator iterator = ssMap.entrySet().iterator();

        while(iterator.hasNext()) {
           Map.Entry<String,String> entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
