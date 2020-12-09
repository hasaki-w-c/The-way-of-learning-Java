package com.hasaki_w_c.jdbc2;

import JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 此类用于演示JDBC中的事务
 *
 * 使用步骤：
 * 1.开启新事物
 * 取消隐式事务自动提交的功能
 * setAutoCommit(false);
 *
 * 2.编写组成事务的一组sql语句
 *
 * 3.结束事务
 * commit();    //提交
 * rollback();    //回滚
 *
 * 细节：
 * 要求开启事务的连接对象和获取命令的连接对象必须是同一个！否则事务无效
 *
 * 案例：转账案例
 * 王琛给叮叮转5000
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/12 15:26
 */
public class TransactionTest {
    /**
     * 不用事务
     */
    @Test
    public void NoTransactionTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtils.getConnection();

        //2.执行sql语句
        PreparedStatement statement = connection.prepareStatement("update account set balance = ? where `name` = ?");

        //操作1：王琛的钱-5000
        statement.setDouble(1, 5000);
        statement.setString(2, "王琛");

        statement.executeUpdate();

        //模拟异常
        int i = 1 / 0;

        //操作2：叮叮的钱+5000
        statement.setDouble(1, 15000);
        statement.setString(2, "叮叮");

        statement.executeUpdate();

        JDBCUtils.close(null, statement, connection);
    }

    /**
     * 用事务
     */
    @Test
    public void transactionTest() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //①事务的使用步骤一：开启事务
            connection.setAutoCommit(false);

            //②事务的使用步骤二：编写sql语句并执行
            //2.执行sql语句
            statement = connection.prepareStatement("update account set balance = ? where `name` = ?");

            //操作1：王琛的钱-5000
            statement.setDouble(1, 5000);
            statement.setString(2, "王琛");

            statement.executeUpdate();

            //模拟异常
            //int i = 1 / 0;

            //操作2：叮叮的钱+5000
            statement.setDouble(1, 15000);
            statement.setString(2, "叮叮");
            statement.executeUpdate();

            //③事务的使用步骤三：结束事务
            connection.commit();
        } catch (SQLException throwables) {
            try {
                //回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            JDBCUtils.close(null, statement, connection);
        }

    }
}