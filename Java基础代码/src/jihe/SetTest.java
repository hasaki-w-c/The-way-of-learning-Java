package jihe;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
1.Set接口的框架：
|---Collection接口：单列集合，用来存储一个一个的对象
        |---Set接口：存储无序的、不可重复的数据 -->高中讲的“集合”
                |---HashSet：作为Set接口的主要实现类;线程不安全的；可以存储null值。
                    |---LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历。
                                       对于频繁的遍历操作，LinkedHashSet效率高于HashSet。
                |--- TreeSet：使用红黑树存的；可以按照添加对象的指定属性，进行排序；

说明：Set接口中没有额外定义新的方法，使用的都是collection声明过的方法

要求：向Set当中添加的数据，其所在的类一定要重写hashCode()和equals()
要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码

重写两个方法的小技巧：对象中用作equals()方法比较的Field，都应该用来计算hashCode值。
 * @author hasaki
 */
public class SetTest {
    /*
    一、Set：存储无序的、不可重复的数据
    以HashSet为例说明：
    1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加。而是根据数据的哈希值决定的。

    2.不可重复性：保证添加的元素按照equals方法判断时，不能返回true.即相同的元素只能添加一个。

    二、添加元素的过程：以HashSet为例：
        我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
        此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断数组此位置上是否有元素，
        如果此位置上没有其他元素，则a添加成功，如果此位置有其他元素b（或以链表形式存在的多个元素），
        则比较元素a与元素b的哈希值，如果哈希值不想同，则元素a添加成功，如果哈希值相同，进而需要调用元素a的equals()方法，
        equals()返回true，元素a添加失败，如果返回false，则元素a添加成功。

        对于存放位置有其他元素但添加成功的情况而言：元素a与已经存在指定的索引位置上数据以链表的方式存储。
        JDK7：元素a放到数组中，指向原来的元素。
        JDK8：原来的元素在数组中指向元素a
        总结：七上八下
     */

    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");

        //set的添加操作有返回值的，返回值为boolean类型，set如果有添加的这个元素，则返回false。
        boolean add = set.add(123);
        System.out.println(add);
        //false

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    /**
    LinkedHashSet的使用
    LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet。
     */
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
