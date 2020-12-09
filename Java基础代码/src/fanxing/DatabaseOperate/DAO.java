package fanxing.DatabaseOperate;

import java.util.List;

/**
 * 操作表的共性操作的DAO
 * @author hasaki
 */
public class DAO <T>{

    /**
     * 添加一条记录
     */
    public void add(T t) {

    }
    /**
     * 删除一条记录
     */
    public boolean remove(T t) {

        return false;
    }

    /**
     * 修改一条记录
     */
    public void update(int index, T t) {

    }

    /**
     *查询一条记录
     */
    public T getIndex(int index) {

        return null;
    }

    /**
     * 查询多条记录
     */
    public List<T> getForList(int index) {

        return null;
    }

    /**
     *泛型方法
     *举例：获取表中有多少条记录？获取最大的员工入职时间？操作
     */
    public  <E> E getValue() {

        return null;
    }

}
