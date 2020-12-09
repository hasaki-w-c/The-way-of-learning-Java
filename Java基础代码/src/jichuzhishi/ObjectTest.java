package jichuzhishi;

import java.util.Arrays;
/*
java.lang.Object;
 类Object是类层次的根类。每个类都使用Object作为超类。
 所有对象（包括数组）都实现这个类的方法。

 Object是根父类，如何理解？
 1.从继承
 ①所有类都继承它，如果一个类没有声明它的父类，那么它的父类就是Object
 ②说明所有类，所有对象都拥有Object类中的方法
 ③每一个类的构造器，往上追踪都会调到Object类中的无参构造
super()
 2.从多态
 ①Object的变量（包括形参）可以接收任意类型的对象
 ②Object的数组，可以储存任意类型的对象

数组也是引用数据类型，数组对象也拥有Object类的方法。
 */
public class ObjectTest {
    public ObjectTest() {    //调用的是Object的无参构造器
    }

    public static void main(String[] args) {
        ObjectTest test = new ObjectTest();

        Object obj1 = "hello";
        Object obj2 = new ObjectTest();

        Object[] arr = new Object[5];
        arr[0] = "hello";
        arr[2] = 1;
        arr[3] = new ObjectTest();
        System.out.println(Arrays.toString(arr));

        int[] nums = new int[5];
    }
}
