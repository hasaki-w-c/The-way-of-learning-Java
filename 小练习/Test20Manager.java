package com.hasaki.dayexer;

import com.hasaki.dayexer.Test20Employee;

public class Test20Manager extends Test20Employee {
    private double bonus;

    public Test20Manager() {
    }

    public Test20Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public String getInfo() {
        return "姓名:" + getName() + " 年龄:" + getAge() + " 薪资:" + getSalary() + " 奖金:" + bonus;
    }
}
