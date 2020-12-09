package com.hasaki_w_c.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 此类用于演示JDBC的使用步骤3：增删改查操作
 *
 * 将需要的东西写进jdbc.properties文件里,然后我用GetProperties将其封装成一个个的方法，进行调用。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/11 22:42
 */
public class JdbcStep3Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("G:\\JDBC练习\\JDBCPractice\\jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1.注册驱动
        Class.forName(driver);

        //2.获取连接
        //不推荐用这种方式
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?user=root&password=wc18329261252");

        //用这种方式更好一些,确保jdbc.properties里的东西写对

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("连接成功");

        //3.执行增删改查
        String sql = "select id,name,sex from beauty";

        //获取执行sql的命令对象
        Statement statement = connection.createStatement();

        //执行sql语句
        //执行增删改语句，返回受影响的行数
        //int update = statement.executeUpdate(sql);
        //执行查询语句，返回一个表格形式的结果集
        ResultSet set = statement.executeQuery(sql);
        //执行任何sql语句,但是一般不用，返回语句不明显
        //boolean execute = statement.execute(sql);

        while (set.next()) {
            int id = set.getInt(1);
            String name = set.getString(2);
            String sex = set.getString(3);

            System.out.println(id + "   " + name + "   " + sex + "   ");
        }

        //4.关闭连接
        set.close();
        statement.close();
        connection.close();

    }
}