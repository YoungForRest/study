//package com.youngTH.ExportUtils;
//
//
//import jxl.Workbook;
//import jxl.format.*;
//import jxl.format.Alignment;
//import jxl.write.*;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// *
// *
// *
// * Created by YoungTH on 2018/11/30.
// * 导出Excel  不是用模板  动态勾选列
// */
//
//public class ExcelExport{
//    private  String sheetName = "SheetName";  //默认sheet页名字
//    private  Integer columnWidth=15;          //默认单元格长度
//    private  String title="TemplateTitle";    //默认表名
//    private  Integer sheetMaxSize=100;       //每个sheet页最大条数
//    private  List<ExcelColumn> columns=new ArrayList<>();
//
//
//    public  String getTitle() {
//        return title;
//    }
//
//    public  void setTitle(String title) {
//        this.title = title;
//    }
//
//    public  String getSheetName() {
//        return sheetName;
//    }
//
//    public  void setSheetName(String sheetName) {
//        this.sheetName = sheetName;
//    }
//
//    public void setSheetMaxSize(Integer sheetMaxSize) {
//        this.sheetMaxSize = sheetMaxSize;
//    }
//
//    public Integer getSheetMaxSize() {
//        return sheetMaxSize;
//    }
//
//
//    public  Integer getColumnWidth() {
//        return columnWidth;
//    }
//
//    public  void setColumnWidth(Integer columnWidth) {
//        this.columnWidth = columnWidth;
//    }
//
//    public ExcelExport(String sheetName, Integer columnWidth, String title, Integer sheetMaxSize, List<ExcelColumn> columns) {
//        this.sheetName = sheetName;
//        this.columnWidth = columnWidth;
//        this.title = title;
//        this.sheetMaxSize = sheetMaxSize;
//        this.columns = columns;
//    }
//
//    public ExcelExport() {
//    }
//
//    @SuppressWarnings("unchecked")
//    // 创建excel文件函数
//    public  boolean createExcel(List resultList, OutputStream outputStream,Class T) {
////        ArrayList<String> list = new ArrayList<>();
////        String string = JSON.toJSONString(resultList);
////        List parseArray = JSON.parseArray(string, T.getClass());
////        JSONArray json= JSONArray.fromObject(parseArray);
//        JSONArray json= JSONArray.fromObject(resultList);
//        try {
//
//            Integer totalSheetNum=json.size()/sheetMaxSize;  //商
//            Integer qumo=json.size()%sheetMaxSize;           //取模  余数
//            WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);
//            for (int n = 0; n <= totalSheetNum; n++) {
//                // 新建文件
//                WritableSheet sheet = writableWorkbook.createSheet(sheetName+"第"+(n+1)+"页", n);// 创建新的一页
//                sheet.getSettings().setDefaultColumnWidth(columnWidth);
//
//                WritableFont wf_cell = new WritableFont(WritableFont.ARIAL, 12,
//                        WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
//                        jxl.format.Colour.BLACK);
//
//                WritableCellFormat writableCellFormat = new WritableCellFormat(wf_cell);
//                writableCellFormat.setWrap(true); //自动换行
//                writableCellFormat.setAlignment(jxl.format.Alignment.CENTRE);//居中
//                Label label; // 单元格对象
//
//                /**
//                 * 设置title
//                 */
//                WritableFont wf_title = new WritableFont(WritableFont.ARIAL, 14,
//                        WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
//                        jxl.format.Colour.BLACK); // 定义格式 字体 下划线 斜体 粗体 颜色
//
//                WritableCellFormat titleCellFormat = new WritableCellFormat(wf_title);
//                //titleCellFormat.setBackground(jxl.format.Colour.WHITE); // 设置单元格的背景颜色
//                //titleCellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //设置边框
//                titleCellFormat.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
//                label=new Label(0,0,title,titleCellFormat);
//                sheet.mergeCells(0,0,columns.size()-1,0);
//                sheet.setRowView(0, 500, false); //设置行高
//                sheet.addCell(label);
//
//                /**
//                 * 设置导出时间
//                 */
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                WritableFont wf_exportDate = new WritableFont(WritableFont.ARIAL, 10,
//                        WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
//                        jxl.format.Colour.BLACK); // 定义格式 字体 下划线 斜体 粗体 颜色
//
//                WritableCellFormat exportDateCellFormat = new WritableCellFormat(wf_exportDate);
//                //titleCellFormat.setBackground(jxl.format.Colour.WHITE); // 设置单元格的背景颜色
//                //titleCellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //设置边框
//                exportDateCellFormat.setAlignment(Alignment.CENTRE); // 设置对齐方式
//                label=new Label(0,1,"导出时间："+simpleDateFormat.format(new Date()),exportDateCellFormat);
//                sheet.mergeCells(0,1,columns.size()-1,1);
//                sheet.addCell(label);
//
//                /**
//                 * 设置属性说明信息加到页中。如：姓名、年龄、性别
//                 */
//                for (int i = 0; i < columns.size(); i++) {
//                    label = new Label(i, 2, columns.get(i).getName(), writableCellFormat); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
//                    sheet.addCell(label); // 将单元格加到页
//                }
//
//                /**
//                 * 填充数据
//                 */
//                if(n<totalSheetNum){
//                    //不是最后一页
//                    for (int i = n*sheetMaxSize; i < (n+1)*sheetMaxSize; i++) {
//                        JSONObject jsonObject = json.getJSONObject(i);
//                        for (int j = 0; j < columns.size(); j++) {
//                            label = new Label(j, (i+3),circleGetVlue(jsonObject,columns.get(j).getColumn()).toString(), writableCellFormat); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
//                            sheet.addCell(label); // 将单元格加到页
//                        }
//                    }
//                }else{
//                    //最后一页
//                    for (int i = n*sheetMaxSize; i < qumo; i++) {
//                        JSONObject jsonObject = json.getJSONObject(i);
//                        for (int j = 0; j < columns.size(); j++) {
//                            label = new Label(j, (i+3),circleGetVlue(jsonObject,columns.get(j).getColumn()).toString(), writableCellFormat); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
//                            sheet.addCell(label); // 将单元格加到页
//                        }
//                    }
//                }
//            }
//
//
//            writableWorkbook.write(); // 加入到文件中
//            writableWorkbook.close(); // 关闭文件，释放资源
//        } catch (Exception e) {
//            return false;
//        }
//
//        return true;
//    }
//
//    /**
//     * 添加导出列   添加顺序即为excel展示顺序
//     * @param column   列名     对应name、age等
//     * @param name     对应关系  如  name 为名字   age 为年龄
//     */
//    public  void putColumn(String column,String name){
//        ExcelColumn excelColumn = new ExcelColumn(column,name);
//        columns.add(excelColumn);
//    }
//
//    /**
//     * 对象嵌套对象 获取属性值方法
//     * @param jsonObject  json对象
//     * @param string      试图导航   例如 father.name
//     * @return
//     */
//    private  Object  circleGetVlue(JSONObject jsonObject,String string){
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
//        }else{
//            object=jsonObject.get(string);
//        }
//        return  object;
//    }
//
//}
//
//
////		           <!--导出excel所需依赖-->
////                <dependency>
////                <groupId>net.sf.json-lib</groupId>
////                <artifactId>json-lib</artifactId>
////                <version>2.4</version>
////                <classifier>jdk15</classifier>
////                </dependency>
////                <!-- https://mvnrepository.com/artifact/net.sourceforge.jexcelapi/jxl -->
////                <dependency>
////                <groupId>net.sourceforge.jexcelapi</groupId>
////                <artifactId>jxl</artifactId>
////                <version>2.6.12</version>
////                </dependency>
////                <!--导出excel所需依赖-->