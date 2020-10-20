package com.hasaki.dayexer;/*
（1）创建Test10person类的对象，设置该对象的name,age,sex属性，调用study()方法，输出字符串"studying"，调用showage()方法
显示age值，调用addage()方法给对象的age属性增加2岁。
（2）创建第二个对象，执行上述操作，体会一个类的不同对象之间的关系
 */

public class Test10 {
    public static void main(String[] args) {
        Test10person person = new Test10person();
        person.name = "王琛";
        person.age = 20;
        person.sex = "男";

        //person.showage(30);    //对应那个就近原则
        person.showage();
        person.study();
        int age = person.addage(2);
        System.out.println("新的age = " + age);
        System.out.println();

        //再创建一个对象，使用上述同样的方法
        Test10person person1 = new Test10person();
        person1.name = "王小琛";
        person1.age = 25;

        person1.showage();
        int age1 = person1.addage(5);
        System.out.println("新的age1 = " + age1);
    }
}
