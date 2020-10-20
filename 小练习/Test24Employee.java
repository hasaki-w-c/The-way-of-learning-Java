package com.hasaki.dayexer;

import jdk.jshell.Snippet;

public class Test24Employee {
    private int num;
    private String name;
    private Test24Status status;

    public Test24Employee() {
    }

    public Test24Employee(int num, String name, Test24Status status) {
        this.num = num;
        this.name = name;
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test24Status getStatus() {
        return status;
    }

    public void setStatus(Test24Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "com.hasaki.dayexer.Test24Employee{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
