package com.hasaki_w_c.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 此类用于演示JDBC的使用步骤2：获取连接
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/11 22:42
 */
public class JdbcStep2Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("G:\\JDBC练习\\JDBCPractice\\src\\com\\hasaki_w_c\\jdbc\\jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1.注册驱动
        Class.forName(driver);

        //2.获取连接
        //不用这种方式
        //DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?user=root&password=wc18329261252");

        //用这种方式更好一些
        DriverManager.getConnection(url, user, password);

        System.out.println("连接成功");
    }
}
