package jihe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
JDK 5.0新增了foreach循环，用于遍历集合、数组
 */
public class ForEachTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("hasaki"));
        coll.add(false);

        //for(集合元素的类型 局部变量 ： 集合对象)
        //内部仍然调用的是迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素类型 局部变量 ：数组对象)
        for (int i :
                arr) {
            System.out.println(i);
        }
    }


    @Test
    public void test3() {
        String[] str = new String[]{"h","a","s","a","k","i"};
        for (String s:
             str) {
            System.out.println(s);
        }
    }
}
