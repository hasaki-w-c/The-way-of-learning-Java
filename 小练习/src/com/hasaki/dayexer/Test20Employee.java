package com.hasaki.dayexer;

public class Test20Employee extends Test20Person {
    private double salary;

    public Test20Employee() {
    }

    public Test20Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getInfo() {
        return "姓名:" + getName() + " 年龄:" + getAge() + " 薪资:" + salary;
    }
}
