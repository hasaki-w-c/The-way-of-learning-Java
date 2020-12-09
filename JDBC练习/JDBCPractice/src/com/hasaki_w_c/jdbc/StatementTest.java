package com.hasaki_w_c.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 *此类用于演示 PreparedStatement 和 statement 的区别(statement)
 *
 * 不建议用此类这种方式进行执行sql语句操作，建议用PreparedStatement方式来执行sql语句,详情见PreparedStatementTest类。
 *
 * 案例：登陆验证
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/12 13:19
 */
public class StatementTest {
    /**
     * 使用Statement实现登陆
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("G:\\JDBC练习\\JDBCPractice\\jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Scanner input = new Scanner(System.in);
        System.out.println("Please input username:");
        String username = input.next();
        System.out.println("Please input password:");
        String mima = input.next();

        //----以下代码为数据库连接步骤----

        //1.注册驱动
        Class.forName(driver);
        //2.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.执行查询
        //这里如果输入一些特殊字符，则也会拼接为sql语句，导致sql服务器崩溃，这就是statement的弊端，而且容易导致Java语法出错
        String sql = "select count(*) from admin where username = '" + username + "' and password = '" + mima + "'";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "Login Success!":"Login Failure!");
        }

        //4.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    //测试类不兼容Scanner键盘输入
    //@Test
    //public void testStatement() throws IOException, ClassNotFoundException, SQLException {
    //
    //    Scanner input = new Scanner(System.in);
    //    System.out.println("Please input username:");
    //    String username = input.next();
    //    System.out.println("Please input password:");
    //    String password = input.next();
    //
    //    //----以下代码为数据库连接步骤----
    //
    //    //1.注册驱动
    //    Class.forName(GetProperties.getDriver());
    //    //2.获取连接
    //    Connection connection = DriverManager.getConnection(GetProperties.getUrl(), GetProperties.getUser(), GetProperties.getPassword());
    //    //3.执行查询
    //    String sql = "select count(*) from admin where username = '" + username + "' and password = '" + password + "'";
    //
    //    Statement statement = connection.createStatement();
    //
    //    ResultSet resultSet = statement.executeQuery(sql);
    //
    //    while (resultSet.next()) {
    //        int count = resultSet.getInt(1);
    //        System.out.println(count > 0 ? "Login Success!":"Login Failure!");
    //    }
    //
    //    //4.关闭资源
    //    resultSet.close();
    //    statement.close();
    //    connection.close();
    //}
}
