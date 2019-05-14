package com.youngTH;

import javax.management.monitor.StringMonitor;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by YoungTH on 2018/11/23.
 */
public class LogDeleteDemo {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        List<String> list = new ArrayList<>();

        /**
         *  D:\违法抽取服务\Log
         */
        File logPath = new File("D:\\违法抽取服务\\Log");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        list.add(simpleDateFormat.format(date));
        for (int i = 0; i < 2; i++) {
            calendar.add(Calendar.DATE,-1);
            list.add(simpleDateFormat.format(calendar.getTime()));
        }
        deleteFolder(logPath,list);
    }

    //删除指定文件的3天之前的所有LOG文件 不删除文件夹
    public static void deleteFolder(File folder,List<String> list) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                boolean flag=true;
                for (int i = 0; i < list.size(); i++) {
                    if(f.getName().contains(list.get(i))){
                        flag=false;
                    }
                }
                if (flag) {
                    f.delete();
                }
            }
        }
    }

}
