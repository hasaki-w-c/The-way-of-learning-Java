package jihe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
|---Collection接口：单列集合，用来存储一个一个的对象
        |---List接口：存储有序的、可重复的数据。-->“动态数组”,替换原有的数组
                |---ArrayList：作为List接口的主要实现类，线程不安全的，效率高；底层使用Object[] elementData存储
                |---LinkedList：对于频繁的插入和删除操作，使用此类比ArrayList效率高，底层使用双向链表存储
                |---vector：作为List接口的古老实现类，线程安全的，效率不高，但开发中不常用；底层使用Object[] elementData存储

面试题：Arraylist、LinkedList、vector三者的异同？
  同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
  不同点：ArrayList：作为List接口的主要实现类，线程不安全的，效率高；底层使用Object[] elementData存储
         LinkedList：对于频繁的插入和删除操作，使用此类比ArrayList效率高，底层使用双向链表存储
         vector：作为List接口的古老实现类，线程安全的，效率不高，但开发中不常用；底层使用Object[] elementData存储

建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)


List接口中常用的方法
void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定位置index位置的元素，并返回此元素
Object set(int Index, Object ele):设置指定index位置的元素ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

总结：常用方法
增：add(Object obj)
删：remove(int index) / remove(Object obj)
改：set(int Index, Object ele)
查：get(int index)
插：add(int index, Object ele)
长度：size()
遍历：①Iterator迭代器方式
     ②增强for循环
     ③普通循环
 */
public class ListTest {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add("BB");
        list.add(123);

        System.out.println(list);    //[123, 456, AA, BB, 123]

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(2,789);
        System.out.println(list);    //[123, 456, 789, AA, BB, 123]

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());    //9

        //Object get(int index):获取指定index位置的元素
        Object o = list.get(3);
        System.out.println(o);    //AA

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        int i1 = list.indexOf(123);
        System.out.println(i1);    //0

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        int i2 = list.lastIndexOf(123);
        System.out.println(i2);    //5

        //Object remove(int index):移除指定位置index位置的元素，并返回此元素
        Object remove = list.remove(0);
        System.out.println(remove);    //123

        //Object set(int Index, Object ele):设置指定index位置的元素ele
        list.set(4, "hasaki");
        System.out.println(list);    //[456, 789, AA, BB, hasaki, 1, 2, 3]

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置左闭右开的子集合
        List list2 = list.subList(0, 2);
        System.out.println(list2);    //[456, 789]
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add("BB");

        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        //方式二：增强for循环
        for (Object obj :
                list) {
            System.out.println(obj);
        }

        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
