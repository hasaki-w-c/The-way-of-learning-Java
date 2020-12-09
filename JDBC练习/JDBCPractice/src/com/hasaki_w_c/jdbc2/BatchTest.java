package com.hasaki_w_c.jdbc2;

import JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 此类用于演示批处理的使用
 *
 * 案例：向admin表中插入50000行数据
 *
 * 相关API：
 * addBatch()
 * executeBatch()
 * clearBatch()
 *
 * 说明：批处理往往和 PreparedStatement 一起搭配使用，可以即减少编译次数又减少运行次数，所以效率大大提高
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/13 15:36
 */
public class BatchTest {
    /**
     * 没有使用批处理
     */
    @Test
    public void NoBatchTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtils.getConnection();

        //2.执行插入
        PreparedStatement statement = connection.prepareStatement("insert into admin values(null,?,?)");

        for (int i = 0; i <= 50000; i++) {
            statement.setString(1,"john"+i);
            statement.setString(2,"0000");

            //执行
            statement.executeUpdate();
        }

        //3释放资源
        JDBCUtils.close(null,statement,connection);
    }

    /**
     * 使用批处理
     */
    @Test
    public void BatchTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtils.getConnection();

        //2.执行插入
        PreparedStatement statement = connection.prepareStatement("insert into admin values(null,?,?)");

        for (int i = 0; i <= 50000; i++) {
            statement.setString(1,"john"+i);
            statement.setString(2,"0000");

            //添加sql语句到批处理包中
            statement.addBatch();
            if (i % 1000 == 0) {
                //执行批处理包的sql语句
                statement.executeBatch();
                //清空批处理包中的sql语句
                statement.clearBatch();
            }
        }

        //3释放资源
        JDBCUtils.close(null,statement,connection);
    }
}
