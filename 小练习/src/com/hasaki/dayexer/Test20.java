package com.hasaki.dayexer;

/*
继承的测验
 */
public class Test20 {
    public static void main(String[] args) {
        //1.创建person对象
        Test20Person person = new Test20Person("王琛",20);
        System.out.println(person.getInfo());

        //创建employee对象
        Test20Employee employee = new Test20Employee("张三",30,5000);
        System.out.println(employee.getInfo());

        //创建Manager对象
        Test20Manager manager = new Test20Manager("李四",35,8000,500);
        System.out.println(manager.getInfo());
    }
}
