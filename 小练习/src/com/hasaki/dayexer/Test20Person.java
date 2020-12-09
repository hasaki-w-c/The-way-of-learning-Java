package com.hasaki.dayexer;

public class Test20Person {
    private String name;
    int age;

    public Test20Person() {
    }

    public Test20Person(String name , int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getInfo() {
        return "姓名:" + name + " 年龄:" + age;
    }
}
