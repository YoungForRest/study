package com.youngTH.ExportUtils;

/**
 * Created by YoungTH on 2018/11/30.
 * 对应导出字段
 */
public class ExcelColumn {
    private String column;
    private String name;

    @Override
    public String toString() {
        return "ExcelColumn{" +
                "column='" + column + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public ExcelColumn(String column, String name) {
        this.column = column;
        this.name = name;
    }

    public ExcelColumn() {

    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
