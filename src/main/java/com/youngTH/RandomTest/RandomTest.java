package com.youngTH.RandomTest;

import org.junit.Test;

import java.util.Random;

/**
 * @author YoungTH
 * @date 2019/4/26
 */
public class RandomTest {

    @Test
    public void fun1(){
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(3));
        }
    }
}
