package JDBCUtils;

import CRUDUtilsTest.Boys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 此类用于封装通用的增删改查方法
 *
 * 功能：
 * 1.执行增删改
 * 2.执行查询
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 14:51
 */
public class CRUDUtils {
    /**
     *
     * @param sql 传入的sql语句
     * @param params 占位符的值
     * @return 修改影响的行数
     */
    public static int update(String sql,Object...params) {
        try {
            //1.获取连接
            Connection connection = JDBCUtilsByDruid.getConnection();

            //2.执行sql语句
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i+1,params[i]);
            }

            int update = statement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询操作，查询单条，只针对Boys表
     * @param sql 传入sql语句
     * @param params 占位符的值
     * @return
     */
    public static Boys querySingle(String sql,Object...params) {
        Connection connection = null;
        PreparedStatement statement =null;
        ResultSet set = null;

        try {
            //1.获取连接
            connection = JDBCUtilsByDruid.getConnection();

            //2.执行查询
            statement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i+1,params[i]);
            }
            set = statement.executeQuery();

            if (set.next()) {
                int id = set.getInt("id");
                String boyName = set.getString("boyName");
                int userCP = set.getInt("userCP");
                Boys boys = new Boys(id,boyName,userCP);
                return  boys;
            }
            return null;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDruid.close(set,statement,connection);
        }
    }

    /**
     *
     * @param sql 传入sql语句
     * @param params 占位符的值
     * @return
     */
    public static List<Boys> queryMulti(String sql, Object...params) {
        Connection connection = null;
        PreparedStatement statement =null;
        ResultSet set = null;

        try {
            //1.获取连接
            connection = JDBCUtilsByDruid.getConnection();

            //2.执行查询
            statement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i+1,params[i]);
            }
            set = statement.executeQuery();
            List<Boys> list = new ArrayList<>();
            while (set.next()) {
                int id = set.getInt("id");
                String boyName = set.getString("boyName");
                int userCP = set.getInt("userCP");
                Boys boys = new Boys(id,boyName,userCP);
                list.add(boys);
            }
            return list;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDruid.close(set,statement,connection);
        }
    }
}
