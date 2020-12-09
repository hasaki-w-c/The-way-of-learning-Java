package com.hasaki_w_c.jdbc4;

import CRUDUtilsTest.Boys;
import JDBCUtils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 此类用于演示DBUtils的使用
 *
 * 功能：封装了和数据库存取相关的一些方法
 * 通用的增删改查等
 *
 * QueryRunner类：
 *      update(connection,sql,params) : 执行任何增删改语句
 *      query(connection,sql,ResultSetHandler,params) : 执行任何查询语句
 * ResultSetHandler类
 *      BeanHandler:将结果集的第一行封装成对象，并返回    new BeanHandler(Xxx.class)
 *      BeanListHandler:将结果集中的所有行，封装成对象的集合并返回    new BeanListHandler(Xxx.class)
 *      ScalarHandler:将结果集中的第一行第一列以Object形式返回    new ScalarHandler()
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 16:45
 */
public class DBUtilsTest {
    @Test
    public void updateTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.执行增删改
        QueryRunner qr = new QueryRunner();
        int update = qr.update(connection, "update boys set boyName = ? where id = 4", "疾风剑豪");
        System.out.println(update > 0 ? "成功！" : "失败！");

        //3.关闭连接
        JDBCUtilsByDruid.close(null, null,connection);

    }

    /**
     * 执行查询单条语句
     * @throws SQLException
     */
    @Test
    public void querySingleTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.执行查询单条语句
        QueryRunner qr = new QueryRunner();

        //Admin admin = qr.query(connection, "select * from admin where id = ?", new BeanHandler<>(Admin.class), 4);
        //System.out.println(admin);

        Boys boys = qr.query(connection, "select * from boys where userCP = ?", new BeanHandler<>(Boys.class), 300);
        System.out.println(boys);

        //3.关闭连接
        JDBCUtilsByDruid.close(null,null,connection);
    }

    /**
     * 执行查询多条语句
     * @throws SQLException
     */
    @Test
    public void queryMultiTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.执行查询多条语句
        QueryRunner qr = new QueryRunner();

        //Admin admin = qr.query(connection, "select * from admin where id = ?", new BeanHandler<>(Admin.class), 4);
        //System.out.println(admin);

        List<Admin> adminList = qr.query(connection, "select * from admin", new BeanListHandler<>(Admin.class));
        for (Admin admin : adminList) {
            System.out.println(admin);
        }

        //List<Boys> boysList = qr.query(connection, "select * from boys where userCP > ?", new BeanListHandler<>(Boys.class), 10);
        //for (Boys boys : boysList) {
        //    System.out.println(boys);
        //}

        //3.关闭连接
        JDBCUtilsByDruid.close(null,null,connection);
    }

    /**
     * 执行查询单个值
     * @throws SQLException
     */
    @Test
    public void scalarTest() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.执行查询单个值
        QueryRunner qr = new QueryRunner();

        Object query = qr.query(connection, "select count(*) from beauty", new ScalarHandler<>());
        System.out.println(query);

        //3.关闭资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
