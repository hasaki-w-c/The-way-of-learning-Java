package JDBCUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 此类为JDBC工具类
 *
 * 功能1.获取连接
 *    2.释放资源
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/12 14:31
 */
public class JDBCUtils {
    static String user;
    static String password;
    static String driver;
    static String url;

    /**
     * 此段代码也只需要执行一次就行，并不用每次调用都执行
     * 静态代码块只执行一次，效率提高
     */
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("G:\\JDBC练习\\JDBCPractice\\jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");

        //1.注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取可用的连接对象
     * @return 连接
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection(){

        //2.获取连接
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            //转换成运行时异常
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 释放资源
     * @param set
     * @param statement
     * @param connection
     * @throws SQLException
     */
    public static void close(ResultSet set, Statement statement,Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
