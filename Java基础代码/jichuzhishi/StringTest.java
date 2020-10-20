package jichuzhishi;

import org.junit.jupiter.api.Test;

/*

 */
public class StringTest {

    @Test
    /*
    String:字符串，使用一对""来表示。
    1.String声明为final的，不可被继承
    2.String实现了Serializable接口：表示字符串支持序列化的。
                 Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于存储字符串数据
    4.String代表一个不可变的字符序列。简称：不可变性。只要对字符串的内容进行修改的，都是重新造的。
        体现:1.当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值。
            2.当对现有的字符串连接操作时，也需要重新指定内存区域赋值，不能在原有的value上赋值
            3.当调用String的replace()方法修改指定的字符或字符串时，也需要重新指定内存区域赋值，不能在原有的value上赋值
    5.通过字面量的方式（区别与new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池中是不会存储相同内容的字符串的
     */
    public void test1() {
        String s1 = "abc";    //字面量的定义方式
        String s2 = "abc";

        System.out.println(s1 == s2);    //比较s1和s2的地址值

        s1 = "hello";

        System.out.println(s1);    //hello
        System.out.println(s2);    //abc

        System.out.println(s1 == s2);    //比较s1和s2的地址值

        System.out.println("*********************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);    //abcdef

        System.out.println("*********************");

        String s4 = "abc";
        String s5 = s4.replace("a", "m");

        System.out.println(s4);    //abc
        System.out.println(s5);    //mbc

    }
    @Test
    /*
    String的实例化方式：
    方式一：通过字面量定义的方式
    方式二：通过new + 构造器的方式

    面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
          答：两个，一个是堆空间中new结构，第二个是char型数组对应常量池中的数据："abc"
     */
    public void test2 () {
        //通过字面量定义的方式：  此时的s1,s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new + 构造器的方式  此时的s3,s4保存的地址值在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);    //true
        System.out.println(s1 == s3);    //false
        System.out.println(s3 == s4);    //false
    }
    @Test
    /*
    字符串拼接的结论
    1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
    2.只要其中有一个是变量，结果就在堆中
    3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    public void test3 () {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";    //字面量
        String s4 = "javaEE" + "hadoop";    //字面量连接的方式就相当于上边的
        String s5 = s1 + "hadoop";    //只要有变量名参与，都不是在常量池中的，都需要在堆空间中开辟，相当于new
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);    //true
        System.out.println(s3 == s5);    //false
        System.out.println(s3 == s6);    //false
        System.out.println(s3 == s7);    //false
        System.out.println(s5 == s6);    //false
        System.out.println(s5 == s7);    //false
        System.out.println(s6 == s7);    //false

        String s8 = s5.intern();    //返回值得到的s8是使用常量池中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8);    //true
    }
}
