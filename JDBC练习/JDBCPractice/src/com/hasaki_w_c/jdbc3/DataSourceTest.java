package com.hasaki_w_c.jdbc3;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 此类用于演示druid数据库连接池的使用
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/13 20:30
 */
public class DataSourceTest {

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

        Properties properties = new Properties();
        properties.load(new FileInputStream("G:\\JDBC练习\\JDBCPractice\\druid.properties"));

        //1.创建一个指定参数的数据库连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        //2.从数据库连接池中获取可用的连接对象
        Connection connection = ds.getConnection();

        System.out.println("连接成功");

        PreparedStatement statement = connection.prepareStatement("select count(*) from admin where username = ? and password = ?");
        statement.setString(1,username);
        statement.setString(2,password);
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
