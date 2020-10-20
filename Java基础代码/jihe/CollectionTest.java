package jihe;

import org.junit.jupiter.api.Test;

import javax.crypto.spec.PSource;
import java.util.*;

/*
一、集合框架的概述

集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）

二、集合框架
      |---Collection接口：单列集合，用来存储一个一个的对象
            |---List接口：存储有序的、可重复的数据。-->“动态数组”
                |---ArrayList、LinkedList、vector
            |---Set接口：存储无序的、不可重复的数据 -->高中讲的“集合”
                |---HashSet、LinkedSet、TreeSet

      |-->Map接口：双列集合，用来存储一对（key--value）一对的数据 --> 高中函数：y = f(x)
        |---HashMap、LinkedHashMap、TreeMap、HashTable、Properties

三、Collection接口中的方法的使用

结论：
向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */
public class CollectionTest {
    @Test
    /*

     */
    public void test1() {
        Collection coll = new ArrayList();

        //1.add(Object e):将元素e添加到集合cool中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);    //自动装箱
        coll.add(new Date());

        //2.size()：获取添加元素的个数
        System.out.println(coll.size());    //4

        //3.addAll(Collection coll1):将coll1集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());    //6
        System.out.println(coll);    //[AA, BB, 123, Thu Oct 15 17:21:57 CST 2020, 456, CC]

        //4.clear():清空集合元素
        coll.clear();

        //5.isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }

    @Test
    /*

     */
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);
        coll.add(new Person("王琛", 20));
        System.out.println(coll);    //[123, 456, hasaki, false, Person{name='王琛', age=20}]

        //6.contains(Object obj)：判断当前集合中是否包含obj.
        //contains()在判断时，会调用obj对象所在类的equals()。通常自定义的类要重写equals方法。
        boolean contains = coll.contains(123);
        System.out.println(contains);    //true
        System.out.println(coll.contains(new String("hasaki")));    //true
        System.out.println(coll.contains(new Person("王琛",20)));    //false --> true需要重写 如下

        //7.containsAll(Collection coll1)：判断形参Coll1中的所有元素是否都存在与当前集合中。
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));    //true
    }

    private class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        //@Override
        //public int hashCode() {
        //    return Objects.hash(name, age);
        //}
    }

    @Test
    public void test3() {
        //7.remove(Object obj)：从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);

        boolean remove = coll.remove(123);
        System.out.println(coll);    //[456, hasaki, false]

        System.out.println(remove);    //true

        //8.removeAll(Collection coll1)：差集：从当前集合中移除coll1中的所有元素

    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);

        //9.retainAll(Collection coll1)：交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);    //[123, 456]

        //10.equals(Object obj)：要想返回true，判断当前集合和形参集合的元素都相同。
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);

        System.out.println(coll.equals(coll2));    //true
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);

        //11.hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());    //702357950

        //12.集合-->数组：toArray()：
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));

        //拓展：数组-->集合：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());    //1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());    //2

        //13.iterator()：返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}

