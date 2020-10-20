package jichuzhishi;
/*
非静态代码块

【修饰符】 class 类名 【extends 父类】{
    {
         非静态代码块
    }
}

执行的特点：
 1.在创建对象时自动执行，没创建一个对象就执行一次。如果有多个非静态代码块，按顺序依次执行。
 2.先于构造器执行
 3.非静态代码块与属性的显示赋值，它两谁在上面谁先执行
 4.如果创建子类的对象，先会执行父类的“非静态代码块、父类属性的显示赋值、父类的构造器”

实例初始化方法<init>(...)
 1..java代码编译为.class时，会把代码重新组装。如果类中有n个构造器，就会重新组装为n个实例初始化方法
 无参构造-><init>()
 有参构造-><init>(形参列表)
 2.实例初始化方法由三部分代码组成
 ①属性的显示赋值语句
 ②非静态代码块的语句
 ③构造器语句
 其中①②是按顺序组装，但是③无论在哪里，都在最后
 3.创建子类对象时，会先调用父类的实例初始化方法
 */
public class NonStaticBlock {
    public static void main(String[] args) {
        Son1 s1 = new Son1();    //调用构造器，创建对象
        Son1 s2= new Son1();
        Son1 s3 = new Son1();
        System.out.println(s1.getNum());
    }
}

class Son1 {
    {
        System.out.println("无参构造");
        num = 3;
    }
    {
        System.out.println("非静态的代码块");
        num = 2;
    }
    private int num = getNumber();    //为num赋值

    public int getNumber() {
        System.out.println("getNumber()");
        return 1;
    }

    public int getNum() {
        return num;
    }
}