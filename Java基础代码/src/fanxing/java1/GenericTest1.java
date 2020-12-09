package fanxing.java1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 1.关于自定义泛型类、泛型接口；
 * @author hasaki
 */
public class GenericTest1 {
    @Test
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为次泛型类型为Object类型
        //要求：如果定义的类是泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>("hasaki",666,"死亡如风，常伴吾身");

        //order1.setOrderT("");
    }

    @Test
    public void test2() {
        SubOrder sub1 = new SubOrder();
        //由于子类扎起继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(123);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("Order2...");
    }

    @Test
    public void test3() {


        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

        //泛型不同的引用不能相互赋值。
        //list1 = list2;

        User u1 = null;
        User u2 = null;
        u1 = u2;

    }

    /**
     * 测试泛型方法
     */
    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
