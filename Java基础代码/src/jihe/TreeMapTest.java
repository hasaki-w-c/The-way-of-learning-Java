package jihe;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
 *因为要按照key进行排序：自然排序，定制排序
 * @author hasaki
 */
public class TreeMapTest {
    /**
     * 自然排序
     */
    @Test
    public void test1() {
        TreeMap map = new TreeMap();
        User u1 = new User("wangcehn",18);
        User u2 = new User("tff",5);
        User u3 = new User("zhangsan",33);
        User u4 = new User("lisi",44);
        User u5 = new User("wangwu",55);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 45);
        map.put(u4, 67);
        map.put(u5, 75);

        //遍历
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 定制排序：按照年龄排序
     */
    @Test
    public void test2() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入的类型不匹配！");
                }
            }
        });
        User u1 = new User("wangcehn",18);
        User u2 = new User("tff",5);
        User u3 = new User("zhangsan",33);
        User u4 = new User("lisi",44);
        User u5 = new User("wangwu",55);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 45);
        map.put(u4, 67);
        map.put(u5, 75);

        //遍历
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
