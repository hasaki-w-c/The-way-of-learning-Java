package com.hasaki_w_c.jdbc3;

import JDBCUtils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 此类用于演示druid数据库连接池的使用
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/13 20:30
 */
public class DataSourceByUtilsTest {

    @Test
    public void DataSourceTest() throws Exception{
        //测试类不支持Scanner用法,就不使用键盘输入了
        //Scanner input = new Scanner(System.in);
        //System.out.println("Please input username:");
        //String username = input.next();
        //System.out.println("Please input password:");
        //String password = input.next();

        String username = "john1";
        String password = "0000";

        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.执行查询
        //2-1.获取PreparedStatement命令对象
        PreparedStatement statement = connection.prepareStatement("select count(*) from admin where username = ? and password = ?");
        //2-2.设置占位符的值
        statement.setString(1,username);
        statement.setString(2,password);
        //2-3.执行sql命令，返回结果集
        ResultSet set = statement.executeQuery();

        if (set.next()) {
            int count = set.getInt(1);
            System.out.println(count > 0 ? "登陆成功！" : "登陆失败！" );
        }

        //3.关闭连接
        set.close();
        statement.close();
        connection.close();
    }

}
