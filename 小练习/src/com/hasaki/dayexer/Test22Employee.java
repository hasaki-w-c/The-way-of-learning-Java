package com.hasaki.dayexer;

public abstract class Test22Employee {
    private int number;
    private String name;
    private Test22Mydate birthday;

    public Test22Employee() {
    }

    public Test22Employee(int number, String name, int year, int month, int day) {    //此种构造方法让使用者更方便
        this.number = number;
        this.name = name;
        this.birthday = new Test22Mydate(year, month, day);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test22Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Test22Mydate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "com.hasaki.dayexer.Test22Employee{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", birthday=" + birthday.toDateString() +
                '}';
    }

    public abstract double earnings();
}
