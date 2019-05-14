package com.youngTH.poiWord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YoungTH
 * @date 2019/4/28
 */
public class WordTest {
    public static void main(String[] args) throws IOException {

        Map<String, Object> wordDataMap = new HashMap<String, Object>();// 存储报表全部数据
        Map<String, Object> parametersMap = new HashMap<String, Object>();// 存储报表中不循环的数据

        //对应table1
        List<Map<String, Object>> table1 = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1=new HashMap<>();
        map1.put("fileCode", "SNG-CGS-6001");
        map1.put("fileName", "系统说明书");
        map1.put("fileVersion", "0");

        Map<String, Object> map2=new HashMap<>();
        map2.put("fileCode", "SNG-CGS-6002");
        map2.put("fileName", "冷却水说明水");
        map2.put("fileVersion", "6");

        Map<String, Object> map3=new HashMap<>();
        map3.put("fileCode", "SNG-CGS-6003");
        map3.put("fileName", "随便说明书");
        map3.put("fileVersion", "0");

        table1.add(map1);
        table1.add(map2);
        table1.add(map3);



        //对应table2
        List<Map<String, Object>> table2 = new ArrayList<Map<String, Object>>();
        Map<String, Object> map4=new HashMap<>();
        map4.put("fileCode2", "M6_XXX-001");
        map4.put("fileName2", "编不下去了");
        map4.put("fileVersion2", "100");

        Map<String, Object> map5=new HashMap<>();
        map5.put("fileCode2", "MMMM-SSSZZZ001");
        map5.put("fileName2", "单线图");
        map5.put("fileVersion2", "101");

        table2.add(map4);
        table2.add(map5);



        parametersMap.put("author", "YoungTH");
        parametersMap.put("total", "100");
        parametersMap.put("cc1Number", "YoungTH");

        wordDataMap.put("table1", table1);
        wordDataMap.put("table2", table2);

        wordDataMap.put("parametersMap", parametersMap);

        /**
         * 模板文件
         * C:\Users\Administrator\Desktop\wordTemplate.docx
         */
        File file = new File("C:\\Users\\Administrator\\Desktop\\wordTemplate.docx");//改成你本地文件所在目录


        // 读取word模板
        FileInputStream fileInputStream = new FileInputStream(file);
        WordTemplate template = new WordTemplate(fileInputStream);

        // 替换数据
        template.replaceDocument(wordDataMap);


        //生成文件
        File outputFile=new File("C:\\Users\\Administrator\\Desktop\\wordOut.docx");//改成你本地文件所在目录
        FileOutputStream fos  = new FileOutputStream(outputFile);
        template.getDocument().write(fos);

    }

}
