package jichuzhishi;
/*
一、静态内部类
1.如何声明？
【修饰符】 class 外部类 【extends 父类】 【implements 父接口们】 {

            【修饰符】 static class 内部类 【extends 父类】 【implements 父接口们】 {
            }
}

2.成员
 类的五大成员都可以

3.使用
 （1）在经他哎内部类中不允许使用外部类的非静态成员
 （2）在外部类中，使用静态内部类和使用其他的类一样
 （3）在外部类的外面使用静态内部类，不需要外部类的对象
 （4）在外部类的外面要调用静态内部类的非静态方法，需要静态内部类的对象。
 （5）在外部类的外面要调用静态内部类的静态方法，不需要静态内部类的对象。

4.说明
 静态内部类也有自己的字节码文件
  外部类$静态内部类.class
 */
public class StaticInnerTest {
    public static void main(String[] args) {
        //调用Inner的test()方法
        Outer.Inter obj = new Outer.Inter();    //不需要外部类的对象，但需要内部类的对象，因为内部方法不是静态的
        obj.test();

        //调用Inner的method()方法
        Outer.Inter.method();    //不需要对象，因为内部类的方法是静态的
    }
}
class Outer {
    private static int i;
    private int j;

    static class Inter {
        public void test() {
            System.out.println(i);    //直接使用外部类的私有成员
            //System.out.println(j);    //static的不能直接使用非static的
        }

        public static void method() {
            System.out.println("内部类的静态方法");
        }
    }

    public Inter getInner() {
        Inter in = new Inter();
        return in;
    }
}
