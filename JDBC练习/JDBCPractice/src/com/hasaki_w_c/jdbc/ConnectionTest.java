package com.hasaki_w_c.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/11 19:17
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        //1.加载驱动
        DriverManager.registerDriver(new Driver());

        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls","root","wc18329261252");

        System.out.println("连接成功");

        //3.执行增删改查

        //3-1.编写sql语句
        //删除
        //String sql = "delete from beauty where id = 9";
        //更新
        String sql = "update beauty set name='灰灰' where id = 7";
        //增加
        //String sql = "insert into beauty values(null,'小龙女','女','1998-1-1','111',null,3)";
        //3-2.获取执行sql语句的命令对象
        Statement statement = connection.createStatement();

        //3-3.使用命令对象执行sql语句
        int update = statement.executeUpdate(sql);

        //3-4.处理执行结果
        System.out.println(update > 0?"success":"failure");

        //4.关闭连接
        statement.close();
        connection.close();

    }
}
