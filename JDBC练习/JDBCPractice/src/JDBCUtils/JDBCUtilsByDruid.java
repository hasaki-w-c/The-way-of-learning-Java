package JDBCUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 14:22
 */
public class JDBCUtilsByDruid {
    static DataSource ds = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("G:\\JDBC练习\\JDBCPractice\\druid.properties"));

            //1.创建一个指定参数的数据库连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取可用的数据库连接池连接对象
     * @return connection连接
     */
    public static Connection getConnection() {
        //2.从数据库连接池中获取可用的连接对象
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
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
    public static void close(ResultSet set, Statement statement, Connection connection) {
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
