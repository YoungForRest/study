package com.youngTH.ExportUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author YoungTH
 * @date 2019/4/2
 */
public class FastJsonUtils {


    public static Object getJsonResult(String jsonString,String format){
        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        Object o = circleGetValue(jsonObject, format);
        return o;
    }



    private static Object  circleGetValue(JSONObject jsonObject, String string){
        Object object=null;
        if(string.contains(".")){
            String[] split = string.split("\\.");
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                int index=0;
                //判断是否含有[]; 则寻找对应下标数组元素
                if(s.contains("[")){
                    String replaceString=s.replace("]","");
                    String[] tempSplit = replaceString.split("\\[");
                    s=tempSplit[0];
                    index=Integer.parseInt(tempSplit[1]);
                }
                if(i!=split.length-1){
                    //通过异常判断是否为json对象还是json数组
                    try{
                        jsonObject=(JSONObject)jsonObject.get(s);
                    }catch (Exception e){
                        JSONArray jsonArray=(JSONArray)jsonObject.get(s);
                        jsonObject = (JSONObject)jsonArray.get(index);
                    }
                }else{
                    object=jsonObject.get(s);
                }
            }
        }else{
            object=jsonObject.get(string);
        }
        return  object;
    }

    @Test
    public void fun1(){
        String jsonResult = (String) getJsonResult(jsonStringTest, "data.map.parameterType");
        System.out.println(jsonResult);
        String jsonResult2 = (String) getJsonResult(jsonStringTest, "data[1].map.parameterType");
        System.out.println(jsonResult2);
    }


    private static String  jsonStringTest="{" +
            "    \"code\": 200," +
            "    \"msg\": \"查询成功\"," +
            "    \"data\": [" +
            "        {" +
            "            \"sysid\": \"NewWMS\"," +
            "            \"map\": {" +
            "                \"isEnable\": \"null\"," +
            "                \"parameterName\": \"更新后的常温6\"," +
            "                \"parameterType\": \"更新后的温控类型6\"," +
            "                \"pkParameter\": \"2\"," +
            "                \"showOrder\": \"12\"," +
            "                \"yn\": \"null\"" +
            "            }" +
            "        }," +
            "        {" +
            "            \"sysid\": \"NewWMS2\"," +
            "            \"map\": {" +
            "                \"isEnable\": \"null\"," +
            "                \"parameterName\": \"更新后的常温62\"," +
            "                \"parameterType\": \"更新后的温控类型62\"," +
            "                \"pkParameter\": \"22\"," +
            "                \"showOrder\": \"122\"," +
            "                \"yn\": \"null\"" +
            "            }" +
            "        }" +
            "    ]" +
            "}";
}
