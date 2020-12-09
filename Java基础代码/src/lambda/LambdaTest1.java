package lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1.举例：（o1,o2） -> Integer.compare(o1,o2);
 * 2.格式：
 *      ->；Lambda操作符 或 箭头操作符
 *      ->的左边：Lambda的形参列表 （其实接口中的首相方法的形参列表）
 *      ->的右边：Lambda体 （其实就是重写的抽象方法的方法体）
 *
 * 3.关于Lambda表达式的使用：（分为六种情况使用）
 *
 *      总结：
 *          ->左边：Lambda形参列表的参数类型可以省略（类型推断）；如果Lambda形参列表只有一个参数，其一对小括号可以省略
 *          ->右边：Lambda体应该使用大括号进行包裹；如果Lambda体只有一条执行语句（可能时return语句），
 *                 可以省略大括号以及return关键字
 *
 * 4.Lambda表达式的本质：作为函数式接口的实例
 *
 *
 * 5.函数式接口：如果一个接口中只实现了一个抽象方法，则此接口就称为函数式接口
 *             我们可以在一个接口上使用@FunctionalInterface注解，这样就可以检查它是否是一个函数式接口。
 *
 * 6.所有匿名实现类表示的都可以用Lambda表达式来写
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/6 16:11
 */
public class LambdaTest1 {
    /**
     * 语法格式一：无参，无返回值
     */
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

    /**
     * 语法格式二：Lambda需要一个参数，但是没有返回值。
     */
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("用我的双手成就你的梦想");

        System.out.println("*****************************");

        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("一库！");
    }

    /**
     * 语法格式三：数据类型可以省略,因为可由编译器推断得出，称为”类型推断“
     */
    @Test
    public void test3() {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("一库！");
    }

    /**
     * 语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void teat4() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("一库！");
    }

    /**
     * 语法格式五：Lambda需要两个以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test5() {
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com.compare(23, 21));
        //1
    }

    /**
     * 语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
     */
    @Test
    public void test6() {
        Comparator<Integer> com = (o1, o2) -> o1.compareTo(o2);

        System.out.println(com.compare(23, 23));
        //0
    }
}
