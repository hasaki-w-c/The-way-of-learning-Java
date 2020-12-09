package jichuzhishi;
/*
枚举：列举，罗列

枚举是代表这样一系列的类型，这些类型有一个非常明显的特征：它们的对象是有限的几个。
例如week(星期)，我们可以限定Week类型的对象只有七个。

枚举类是JDK1.5之后引入进来的。

枚举类也是类，原来用class声明类，现在用enum来声明枚举。
声明语法格式：
【权限修饰符】 enum 枚举类型名{
    常量对象列表；
}

说明：
 （1）枚举类型的构造器一定是私有的
 （2）枚举类型的常量对象列表必须在枚举类的首行。
     PS:首行：
            1.package
            2.super(),this()
            3.枚举常量对象
 （3）所有枚举类型有一个直接父类java.lang.Enum类型，所以不能再继承其他类。
 （4）switch...case增加了对枚举的支持
     switch...case的表达式的类型：
     1.基本数据类型：byte,short,int,char
     2.引用数据类型：枚举（JDK1.5之后），String(JDK17.之后)
 */
public class Meiju {
    public static void main(String[] args) {
        Week monday = Week.MONDAY;
        System.out.println(monday);

        switch (monday) {
            case MONDAY :
                System.out.println("星期一");
            break;
            case TUESDAY :
                System.out.println("星期二");
            break;
        }
    }
}
enum Week {
    MONDAY("周一","好困啊！"),TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    private String name;
    private String desc;

    Week(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    Week() {
    }
}