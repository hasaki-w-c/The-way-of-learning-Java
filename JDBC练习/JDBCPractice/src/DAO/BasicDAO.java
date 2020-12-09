package DAO;

import JDBCUtils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 19:10
 */
public class BasicDAO <T>{

    QueryRunner qr = new QueryRunner();


    /**
     * 通用的增删改方法，针对任何表
     * @param sql 传入的sql语句
     * @param params 占位符的值
     * @return
     */
    public int update(String sql,Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            int update = qr.update(connection, sql, params);
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 查询并返回单个对象，针对于任何表
     * @param sql 传入的sql语句
     * @param clazz 所要查询的字段所对应的类
     * @param params 占位符的值
     * @param <T> 返回值类型
     * @return
     */
    public <T> T querySingle(String sql, Class<T> clazz, Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            //执行查询
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), params);
            return query;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 查询并返回多个对象，针对于任何表
     * @param sql 传入的sql语句
     * @param clazz 所要查询的字段所对应的类
     * @param params 占位符的值
     * @return
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            //执行查询
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
            return query;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 查询单个值，针对于任何表
     * @param sql 传入的sql语句
     * @param params 占位符的值
     * @return
     */
    public <T> Object scalar(String sql, Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            //执行查询
            Object query = qr.query(connection, sql, new ScalarHandler<>(), params);
            return query;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
