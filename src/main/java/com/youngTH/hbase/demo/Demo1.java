package com.youngTH.hbase.demo;

import com.youngTH.hbase.Configuration.HbaseClient;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.junit.Test;

import java.io.IOException;

/**
 * @author YoungTH
 * @date 2019/2/25
 */
public class Demo1 {
    private static HBaseAdmin admin;
    static{
        HbaseClient.init();
        admin= (HBaseAdmin) HbaseClient.admin;
    }

    //创建table
    @Test
    public void fun1() throws IOException {
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("people"));
        HColumnDescriptor htd_info = new HColumnDescriptor("info");
        htd.addFamily(htd_info);
        htd.addFamily(new HColumnDescriptor("data"));
        htd_info.setMaxVersions(3);

        admin.createTable(htd);
        HbaseClient.close();
    }

    //获取到数据库所有表信息
    @Test
    public void fun2() throws IOException{
        HTableDescriptor[] allTable = admin.listTables();
        for (HTableDescriptor hTableDescriptor : allTable) {
            System.out.println(hTableDescriptor.getNameAsString());
        }
        HbaseClient.close();
    }
}
