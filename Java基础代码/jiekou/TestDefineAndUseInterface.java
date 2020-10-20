package jiekou;
/*
接口和类是同一级别的概念。
Java的数据类型：基本数据类型和引用数据类型
引用数据类型：类，接口，数组，枚举。。。

1.如何声明一个接口
  语法格式：
  【修饰符】 interface 接口名 {
  }

2.接口的成员
  JDK1.8之前：
  (1)全局的静态的常量：public static final
  (2)公共的抽象方法：public abstract

  JDK1.8之后：接口的语法有改动
  增加了两类成员：
  (1)静态方法:public static,static不可以省略
  通过“接口名.方法”来进行调用
  说明：接口的静态方法不会继承到实现类中，不能用接口的实现类的对象来调用。
  ps:为了减少.class文件的数量，减少API的类型数量
  (2)默认方法:public default,default不可以省略
  使用时要载创建一个实现类，因为不是静态方法，要通过对象.才可以调用。
  使用默认方法的场合：当这个接口的某个抽象方法，在很多实现类中的实现代码是一样的，
  那么可以把这个实现挪到接口中，用默认方法进行实现。如果实现对该抽象方法不一样的实现的实现类，
  那么可以对该默认方法进行重写。
  说明：实现类可以对接口的默认方法进行重写，重写时，不需要加default。

  说明：接口是没有构造器，代码块，除了全局的静态的常量以外的普通的属性等。

3.实现接口
  用来被实现的。
  【修饰符】 class 实现类 【extends 父类】 implements 接口们{
  }

4.接口的特点：
  (1)实现类在实现接口时，必须实现接口的所有抽象方法，否则这个实现类就必须是个抽象类。
  (2)一个类可以同时实现多个接口
  (3)接口不能直接创建对象
  (4)接口可以与实现类的对象构成多态引用
  (5)一个类可以同时继承父类，又实现接口，但是要求，继承在前，接口在后。
  (6)接口与接口之间支持多继承
 */
public class TestDefineAndUseInterface {
    public static void main(String[] args) {
        Flyable f = new Bird();
        f.fly();
    }
}

interface Flyable {
    int MAX_VALUE = 7900000;    //最高速度
    int MIN_VALUE = 0;    //静止

    void fly();
}

interface Jumpable {
    void jump();
}

class Bird implements Flyable, Jumpable {

    @Override
    public void fly() {
        System.out.println("起飞！");
    }

    @Override
    public void jump() {
        System.out.println("我跳儿！");
    }
}