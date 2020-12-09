package CRUDUtilsTest;

import JDBCUtils.CRUDUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 15:04
 */
public class CRUDUtilsTest {
    /**
     * 增删改测试
     */
    @Test
    public void UpdateTest() {
        //修改操作
        //int update = CRUDUtils.update("update beauty set sex = ? where name = '柳岩'", "男");
        //System.out.println(update > 0 ? "成功！" : "失败！");

        //删除操作
        int update = CRUDUtils.update("delete from admin where id > ?", 10);
        System.out.println(update > 0 ? "成功！" : "失败！");
    }

    /**
     * 查询测试
     */
    @Test
    public void QueryTest() {
        //查询单条语句
        //Boys boys = CRUDUtils.querySingle("select * from boys where id = ?", 2);
        //System.out.println(boys);

        //查询多条语句
        List<Boys> list = CRUDUtils.queryMulti("select * from boys");
        for (Boys b : list) {
            System.out.println(b);
        }
    }
}
