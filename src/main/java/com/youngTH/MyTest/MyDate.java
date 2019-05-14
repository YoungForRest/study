package com.youngTH.MyTest;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author YoungTH
 * @date 2019/4/29
 */
public class MyDate {
    @Test
    public void fun1(){
        Date date = new Date();
        System.out.println(date);
        Date truncate = DateUtils.truncate(date, Calendar.DATE);
        System.out.println(truncate);

    }
}
