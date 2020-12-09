package com.hasaki_w_c.jdbc2;

import JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 此类用于演示Blob类型数据的存取
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/13 16:10
 */
public class BlobTest {
    /**
     * 存图片
     */
    @Test
    public void SaveTest() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //2.执行修改语句
            statement = connection.prepareStatement("update beauty set photo=? where id = 1");

            statement.setBlob(1,new FileInputStream("C:\\Users\\Lenovo\\Desktop\\111.jpg"));
            int update = statement.executeUpdate();
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtils.close(null,statement,connection);
        }
    }

    /**
     * 读图片
     */
    @Test
    public void ReadTest() throws IOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //2.执行修改语句
            statement = connection.prepareStatement("select photo from beauty where id = 1");

            ResultSet set = statement.executeQuery();
            if (set.next()) {
                //方式1
                //Blob blob = set.getBlob("photo");
                //InputStream blobBinaryStream = blob.getBinaryStream();

                //方式2
                InputStream inputStream = set.getBinaryStream("photo");
                FileOutputStream fos = new FileOutputStream("G:\\JDBC练习\\JDBCPractice\\src\\com\\hasaki_w_c\\jdbc2\\demo.jpg");

                int len;
                byte[] b = new byte[1024];
                while ((len = inputStream.read(b)) != -1) {
                    fos.write(b,0,len);
                }

                fos.close();
                inputStream.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtils.close(null,statement,connection);
        }
    }
}
