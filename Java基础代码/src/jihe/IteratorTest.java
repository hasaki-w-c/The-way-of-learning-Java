package jihe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
集合元素的遍历，使用迭代器iterator接口
1.iterator仅用于遍历集合
2.内部的方法：hasNext()和next()
3.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认的游标都在集合的第一个元素之前。
4.内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同与集合直接调用remove。

 */
public class IteratorTest {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式一
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());    //几个元素用几个，不然报异常NoSuchElementException

        //方式二：不推荐
        //for (int i = 0; i < coll.size(); i++) {
        //    System.out.println(iterator.next());
        //}

        //方式三：推荐
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    /**
     * 测试迭代器Iterator中的remove()
     */
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        while (iterator.hasNext()) {
            Object o = iterator.next();
            if ("hasaki".equals(o)) {
                iterator.remove();
            }
        }

        iterator = coll.iterator();

        while (iterator.hasNext());
        System.out.println(iterator.next());
    }
}
