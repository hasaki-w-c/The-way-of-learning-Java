package com.hasaki_w_c.jdbc;

import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 此类用于演示 PreparedStatement 和 statement 的区别(PreparedStatement)
 *
 *案例：案例：登陆验证
 *
 * 使用PreparedStatement的好处：
 * 1.不再使用+拼接sql语句，减少语法错误，语义性强
 * 2.将模板sql（固定的部分）和参数部分进行了分离，提高维护性
 * 3.有效的解决了sql的注入问题
 * 4.效率高（此方法如果要执行多条sql语句，也只需要编译一遍，大大减少了编译次数）
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/12 13:54
 */
public class PreparedStatementTestByUtils {
    /**
     * 使用Statement实现登陆
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please input username:");
        String username = input.next();
        System.out.println("Please input password:");
        String mima = input.next();

        //----以下代码为数据库连接步骤----
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //2..执行查询
            String sql = "select count(*) from admin where username = ? and password = ?";
            //2-1.获取PreparedStatement命令对象
            statement = connection.prepareStatement(sql);
            //2-2.设置占位符的值
            statement.setString(1,username);
            statement.setString(2,mima);
            //2-3.执行sql命令
            //执行增删改 返回受影响行数
            //int update = statement.executeUpdate();
            //执行查询，返回结果集
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                int count = set.getInt(1);
                System.out.println(count > 0 ? "Login Success!" : "Login Failure!");
            }
        } catch (SQLException throwables) {


        } finally {
            //3.关闭资源
            JDBCUtils.close(null,statement,connection);
        }
    }
}
