package com.youngTH;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YoungTH on 2018/11/21.
 */
public class FileDeleteDemo {
    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar1.setTime(date);
        calendar2.setTime(date);

        calendar.add(Calendar.MONTH,-1);
        String previousMonth = simpleDateFormat1.format(calendar.getTime());//201810
        /**
         *  保存15天
         *  D:\\capture\\weifa\\
         *  保存3天
         *  D:\\capture\\discard\\
         */
        String currentDate1 = simpleDateFormat1.format(date);//一级目录201811
        String currentDate2 = simpleDateFormat2.format(date); //二级目录21

        //获取weifa文件夹
        calendar1.add(Calendar.DATE,-15);
        String weifa1 = simpleDateFormat1.format(calendar1.getTime());//一级目录201811
        String weifa2 = simpleDateFormat2.format(calendar1.getTime()); //二级目录06
        String weifaPath1="C:\\capture\\weifa"+"\\"+weifa1;
        String weifaPath2=weifaPath1+"\\"+weifa2;

        if(currentDate1.equals(weifa1)){
            /**减完之后同月
             * 1.删除上个月整个文件夹
             * 2.删除同月这日之前所有文件夹
             */
            File previousMonthFile = new File("C:\\capture\\weifa"+"\\"+previousMonth);
            deleteFolder(previousMonthFile);
            for (int i = 1; i <= Integer.parseInt(weifa2); i++) {
                String temps="";
                if(i<10){
                    temps="0"+i;
                }else{
                    temps=i+"";
                }
                deleteFolder(new File(weifaPath1 + "\\" + temps));
            }
        }else{
            /**减完之后非同月
             * 1.删除上个月这日之前所有的文件夹
             */
            for (int i = 1; i <= Integer.parseInt(weifa2); i++) {
                String temps="";
                if(i<10){
                    temps="0"+i;
                }else{
                    temps=i+"";
                }
                deleteFolder(new File("C:\\capture\\weifa"+"\\"+previousMonth+"\\"+temps));
            }
        }

        //获取discard文件夹
        calendar2.add(Calendar.DATE,-3);
        String discard1 = simpleDateFormat1.format(calendar2.getTime());//一级目录201811
        String discard2 = simpleDateFormat2.format(calendar2.getTime()); //二级目录18
        String discardPath1="C:\\capture\\discard"+"\\"+discard1;
        String discardPath2=discardPath1+"\\"+discard2;


        if(currentDate1.equals(discard1)){
            /**减完之后同月
             * 1.删除上个月整个文件夹
             * 2.删除同月这日之前所有文件夹
             */
            File previousMonthFile = new File("C:\\capture\\discard"+"\\"+previousMonth);
            deleteFolder(previousMonthFile);
            for (int i = 1; i <= Integer.parseInt(discard2); i++) {
                String temps="";
                if(i<10){
                    temps="0"+i;
                }else{
                    temps=i+"";
                }
                deleteFolder(new File(discardPath1 + "\\" + temps));
            }
        }else{
            /**减完之后非同月
             * 1.删除上个月这日之前所有的文件夹
             */
            for (int i = 1; i <= Integer.parseInt(discard2); i++) {
                String temps="";
                if(i<10){
                    temps="0"+i;
                }else{
                    temps=i+"";
                }
                deleteFolder(new File("C:\\capture\\discard"+"\\"+previousMonth+"\\"+temps));
            }
        }


//        File filder1 = new File(weifaPath2);
//        File filder2 = new File(discardPath2);
//
//
//
//        //删除指定文件的所有文件
//        deleteFolder(filder1);
//        deleteFolder(filder2);


    }

    //删除指定文件的所有文件
    public static void deleteFolder(File folder){
        File[] files = folder.listFiles();
        if(files!=null){
            for (File f:files) {
                if(f.isDirectory()){
                    deleteFolder(f);
                }else{
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
