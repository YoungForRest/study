package com.youngTH.jvmStudy;

import org.junit.Test;

/**
 * @author YoungTH
 * @date 2019/4/29
 */
public class StringIntern {

    @Test
    public void fun1(){

        String str1 = new String("SEU")+ new String("Calvin");

        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
    }
    @Test
    public void fun2(){

        String str2 = "SEUCalvin";

        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");

    }

}
