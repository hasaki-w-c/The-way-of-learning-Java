package lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的四大函数式接口
 *
 * 1.消费型接口 Consumer<T>     void accept(T t)
 * 2.供给型接口 Supplier<T>     T get()
 * 3.函数型接口 Function<T,R>   R apply(T t)
 * 4.断定型接口 Predicate<T>    boolean test(T t)
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/6 17:00
 */
public class LambdaTest2 {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买吃滴花费：" + aDouble);
            }
        });

        System.out.println("****************************");

        happyTime(400,money -> System.out.println("上网花费：" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("天津");
        list.add("南京");
        list.add("东京");
        list.add("西京");
        list.add("普京");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString);
        //[北京, 南京, 东京, 西京, 普京]

        List<String> filterString1 = filterString(list,s -> s.contains("京"));
        System.out.println(filterString1);
        //[北京, 南京, 东京, 西京, 普京]
    }

    /**
     * 根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
     * @param list 传入的集合
     * @param pre 某种规则
     * @return 过滤以后的list
     */
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }
}
