package jichuzhishi;
/*
static：静态的

static是一个修饰符

static可以修饰什么？
 1.属性；
 2.方法；
 3.代码块；
 4.内部类。

static修饰属性
 用static修饰的属性，称为静态变量、类变量
 静态变量和非静态的属性：
 1.值的存储位置不同
     非静态：堆
     静态：方法区
     （局部变量）：栈
 2.值的初始化的时机不同
     非静态的属性：创建实例对象时，在<init>()实例初始化方法中完成初始化
     静态变量：类初始化时，在<clinit>()类初始化方法中完成初始化

     静态变量初始化要比非静态的属性早。
 3.共享性不同
   非静态的属性：每一个对象时独立的，各自存了一份
   静态变量：所有该类对象共享同一份
 4.生命周期不同
   非静态的属性：随着对象的创建而存在，当对象被垃圾回收器回收就消失（其生命周期等同于对象的生命周期）
   静态变量：随着类的初始化而初始化，随着类的卸载而卸载（其生命周期等同于类的生命周期）

static修饰的方法
 用static修饰方法，称为静态方法，类方法
 1.可以通过”类名.“调用，可以不通过”对象.“调用，当然也可以。
 2.静态方法中是不允许出现this,super这些关键字。
 3.静态方法中不能直接使用本类的非静态的成员（属性，方法，内部类）（非静态方法可以调用静态的）
 4.静态方法是不能被重写的。

static修饰代码块
1.作用
 代码块的作用：为属性初始化
 代码块是分为非静态代码块和静态代码块
 非静态代码块的作用：为非静态的属性初始化
 静态代码块的作用：为静态的属性，静态变量初始化
 2.执行的特点
 ①无论创建几个对象，静态代码块只执行一次，如果有多个，那么就按顺序执行
 ②静态代码块优先于非静态代码块的执行（因为静态代码块的执行是在类初始化时执行）
 ③子类的初始化时，如果发现父类还没有初始化，会先初始化父类。
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        Chinese c2 = new Chinese();

        c1.name = "张三";
        c2.name = "李四";

        c1.country = "中国";
        c2.country = "中华人民共和国";

        System.out.println(c1.country + c2.country);
        System.out.println(c2.country + c1.country);

        System.out.println(c1.name + c2.name);
        System.out.println(c1.name + c2.name);
    }
}

class Chinese {
    static String country;
    String name;
}
