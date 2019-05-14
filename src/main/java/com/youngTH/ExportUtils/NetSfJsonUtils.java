package com.youngTH.ExportUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author YoungTH
 * @date 2019/4/2
 */
public class NetSfJsonUtils {


    public static Object getJsonResult(String jsonString,String format){
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Object o = circleGetValue(jsonObject, format);
        return o;
    }



    private static Object  circleGetValue(JSONObject jsonObject, String string){
        Object object=null;
        if(string.contains(".")){
            String[] split = string.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(i!=split.length-1){
                    try{
                        jsonObject=(JSONObject)jsonObject.get(split[i]);
                    }catch (Exception e){
                        JSONArray jsonArray=(JSONArray)jsonObject.get(split[i]);
                        jsonObject = (JSONObject)jsonArray.get(0);
                    }

                }else{
                    object=jsonObject.get(split[i]);
                }
            }
        }else{
            object=jsonObject.get(string);
        }
        return  object;
    }

    /**
     * 使用样例
     */
    public static void main(String[] args) {

        String jsonResult = (String) getJsonResult(jsonStringTest, "data.map.parameterType");
        System.out.println(jsonResult);

    }

    static String  jsonStringTest="{\n" +
            "    \"code\": 200,\n" +
            "    \"msg\": \"查询成功\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"sysid\": \"NewWMS\",\n" +
            "            \"map\": {\n" +
            "                \"isEnable\": \"null\",\n" +
            "                \"parameterName\": \"更新后的常温6\",\n" +
            "                \"parameterType\": \"更新后的温控类型6\",\n" +
            "                \"pkParameter\": \"2\",\n" +
            "                \"showOrder\": \"12\",\n" +
            "                \"yn\": \"null\"\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";

}
