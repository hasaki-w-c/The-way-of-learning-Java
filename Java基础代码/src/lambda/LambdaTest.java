package lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 *
 * 方法引用的使用
 *      1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *      2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用也是函数式接口的实例
 *      3.使用格式： 类（或对象） :: 方法名
 *      4.具体分三种情况：
 *          对象 :: 非静态方法
 *          类 :: 静态方法
 *          类 :: 非静态方法
 *      5.方法引用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值都得相同。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/6 15:56
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("死亡如风");
            }
        };

        r1.run();

        System.out.println("*********************");

        //Lambda表达式的例子
        Runnable r2 = () -> System.out.println("常伴吾身");

        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        //-1

        System.out.println("**************************");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(23, 21);
        System.out.println(compare2);
        //1

        System.out.println("**************************");

        //方法引用
        Comparator<Integer> com3 = Integer::compare;

        int compare3 = com2.compare(21, 21);
        System.out.println(compare3);
        //0

    }
}
