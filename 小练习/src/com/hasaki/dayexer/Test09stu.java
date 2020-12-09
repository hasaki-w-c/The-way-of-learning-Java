package com.hasaki.dayexer;

public class Test09stu {
    String name;
    int age;
    String major;
    String interests;
    public static void say()
    {
        Test09stu stu = new Test09stu();
        System.out.println("输出学生的个人信息");
        System.out.println("name: " + stu.name);
        System.out.println("age: " + stu.age);
        System.out.println("major: " + stu.major);
        System.out.println("interests: " + stu.interests);
        System.out.println();
    }
}
