package com.qiu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class Utils {
  static   Properties properties=new Properties();
  static DataSource dataSource;

 public    static DataSource getDataSource() {

        try {
            properties.load(Utils.class.getClassLoader().getResourceAsStream("db.properties"));
             dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


}
