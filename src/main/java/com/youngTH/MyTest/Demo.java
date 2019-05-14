package com.youngTH.MyTest;

import com.youngTH.entity.User;
import org.junit.Test;

/**
 * @author YoungTH
 * @date 2019/2/18
 */
public class Demo {
    @Test
    public void fun1(){
        int i=5;
        while(i>0){
            i--;
            System.out.println(i);
        }
        System.out.println(i);
    }

    @Test
    public void fun2(){
        User user0;
        User user1 = new User();
        user0=user1;
        System.out.println(user0.equals(user1));
    }
    private void setUser(User user){

    }

}
