package com.hang.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidUtil {
    public static Connection getConnection(){
        Properties properties = new Properties();

        Connection connection = null;

        try {
            properties.load(new FileInputStream("D:/ideaCoder/Test/src/com/hang/util/druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
          connection =  DruidDataSourceFactory.createDataSource(properties).getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  connection;
    }
}
