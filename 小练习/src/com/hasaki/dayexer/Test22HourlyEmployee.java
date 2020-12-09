package com.hasaki.dayexer;

import com.hasaki.dayexer.Test22Employee;

public class Test22HourlyEmployee extends Test22Employee {
    private int hour;
    private double wage;    //每小时多少钱

    public Test22HourlyEmployee(int number, String name, int year, int month, int day, int hour, int wage) {
        super(number, name, year, month, day);
        this.hour = hour;
        this.wage = wage;
    }

    public Test22HourlyEmployee() {
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double earnings() {
        int money = (int) (wage * hour);
        return money;
    }

    @Override
    public String toString() {
        return super.toString() + "com.hasaki.dayexer.Test22HourlyEmployee{" +
                "hour=" + hour +
                ", wage=" + wage +
                '}';
    }
}
