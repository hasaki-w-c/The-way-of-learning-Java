package fanxing.java1;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
泛型的使用
1.JDK5.0新增的特性

2.在集合中使用泛型：
  总结：
  ①集合接口或集合类在JDK5.0时都修改为带泛型的结构。
  ②在实例化集合类时，可以指明具体的泛型类型
  ③指明完以后，在集合类或者接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化时的泛型类型
    比如add(E e) --->实例化以后：add(Integer e)
  ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据的类型，拿包装类替换
  ⑤如果实例化时，没有指明泛型的类型。，默认类型为java.lang.Object类型。
  @author hasaki
3.如何自定义泛型结构：泛型类、泛型接口、泛型方法。见GenericTest1.java

经验：泛型要么一路用，要么一路都不用。

 注意：静态方法中不能使用泛型。
      异常类不能是泛型的

 */
public class GenericTest {

    //在集合中使用泛型之前的情况;

    @Test
    public void test() {

        List list = new ArrayList();
        //需求：存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
        list.add("Wc");

        for (Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }

    }

    /**
     * 在集合中使用泛型的情况：
     */

    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //编译时，就会进行类型检查，保证数据安全
        //list.add("hasaki");

        //方式一：增强for循环
        for (Integer score : list) {

            //避免了强转操作
            int stuScore = score;

            System.out.println(stuScore);
        }
        System.out.println();

        //方式二：迭代器方式
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    /**
     * 在集合中使用泛型的情况：以HashMap为例
     */
    @Test
    public void test3() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("Tom",87);
        map.put("jack",77);
        map.put("Jerry",97);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---" + value);
        }
    }
}
