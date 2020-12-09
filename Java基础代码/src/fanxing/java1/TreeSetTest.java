package fanxing.java1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 泛型化的treeSet测试类
 * @author hasaki
 */
public class TreeSetTest {
    @Test
    /**
    1.向TreeSet中添加的数据，要求是相同类的对象。

    2.两种排序方式：自然排序（实现Comparable接口）和 定制排序（Comparator）

    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0,不再是equals().

    4.定制排序中，比较俩个对象是否相同的标准为：compare()返回0,不再是equals().
     */
    public void test() {
        TreeSet treeSet = new TreeSet();

        //失败，不能添加不同类的对象
        //treeSet.add(123);
        //treeSet.add(456);
        //treeSet.add("AA");
        //treeSet.add("BB");

        //举例一：
        //treeSet.add(12);
        //treeSet.add(34);
        //treeSet.add(78);
        //treeSet.add(5);
        //treeSet.add(-11);

        //举例二：
        treeSet.add(new User("hasaki",12));
        treeSet.add(new User("wangchen",25));
        treeSet.add(new User("zhangsan",45));
        treeSet.add(new User("lisi",32));
        treeSet.add(new User("wangwu",23));
        treeSet.add(new User("tengfeifei",8));
        treeSet.add(new User("tengfeifei",16));
        treeSet.add(new User("tengfeifei",12));


        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };

        TreeSet<User> treeSet = new TreeSet<>(com);
        treeSet.add(new User("hasaki",12));
        treeSet.add(new User("wangchen",25));
        treeSet.add(new User("zhangsan",45));
        treeSet.add(new User("lisi",32));
        treeSet.add(new User("wangwu",23));
        treeSet.add(new User("tengfeifei",8));
        treeSet.add(new User("tengfeifei",16));
        treeSet.add(new User("tengfeifei",12));

        Iterator<User> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
