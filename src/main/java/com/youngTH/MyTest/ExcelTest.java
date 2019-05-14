//package com.youngTH.MyTest;
//
//import com.youngTH.ExportUtils.ExcelExport;
//import com.youngTH.entity.Father;
//import com.youngTH.entity.Friend;
//import com.youngTH.entity.User;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by YoungTH on 2018/11/30.
// */
//public class ExcelTest {
//    @Test
//    public void fun1() throws FileNotFoundException {
//        List<User> users = new ArrayList<>();
//        Father father1 = new Father("1","fatherName1",38);
//        User user1 = new User("111","user1",18,father1);
//        List<Friend> friends1 = new ArrayList<>();
//        Friend friend1=new Friend("f1",10);
//        Friend friend2=new Friend("f2",11);
//        friends1.add(friend1);
//        friends1.add(friend2);
//        user1.setFriends(friends1);
//
//
//        Father father2 = new Father("2","fatherName2",48);
//        User user2 = new User("222","user2",28,father2);
//        List<Friend> friends2 = new ArrayList<>();
//        user2.setFriends(friends2);
//
//        Father father3 = new Father("3","fatherName3",58);
//        User user3 = new User("333","user3",38,father3);
//
//        Father father4 = new Father("4","fatherName4",68);
//        User user4 = new User("444","user4",48,father4);
//
//        Father father5 = new Father("5","fatherName5",78);
//        User user5 = new User("555","user5",58,father5);
//
//        Father father6 = new Father("6","fatherName6",88);
//        User user6 = new User("666","user6",68,father6);
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        users.add(user5);
//        users.add(user6);
//
//
//
//        JSONArray json= JSONArray.fromObject(users);
//        for (int i = 0; i < json.size(); i++) {
//            JSONObject jsonObject = json.getJSONObject(i);
//            System.out.println(jsonObject);
//        }
//
//
//        ExcelExport excelExport = new ExcelExport();
//
//
//        excelExport.setSheetName("测试sheet");                                //设置sheet名字
//        excelExport.setColumnWidth(20);                                      //设置列宽
//        excelExport.setTitle("测试导出变化列");                                //设置标题 title
//
//        excelExport.putColumn("id","用户主键");                 //设置动态导出列
//        excelExport.putColumn("userName","用户姓名");           //设置动态导出列
//        excelExport.putColumn("father.fatherName","父亲名字");  //设置动态导出列
//
//        /**
//         * 输出流  项目中使用 response  的输出流
//         */
//        FileOutputStream outputStream = new FileOutputStream(new File("E:\\test.xls"));
//        /**
//         *
//         */
//        excelExport.createExcel(users,outputStream,User.class);
//        System.out.println(excelExport.getSheetName());
//
//
//    }
//
//    private Object  circleGetVlue(JSONObject jsonObject,String string){
//        Object object=null;
//        if(string.contains(".")){
//            String[] split = string.split("\\.");
//            for (int i = 0; i < split.length; i++) {
//                if(i!=split.length-1){
//                    jsonObject=(JSONObject)jsonObject.get(split[i]);
//                }else{
//                    object=jsonObject.get(split[i]);
//                }
//            }
//        }
//        return  object;
//    }
//}
