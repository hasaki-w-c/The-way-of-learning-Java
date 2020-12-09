package com.hasaki.dayexer;

import com.hasaki.dayexer.Test22Employee;

public class Test22SalariedEmployee extends Test22Employee {
    private double monthlySalary;    //月薪
    private int workingDay;    //实际工作天数
    private int totalDays;    //应该工作天数

    public Test22SalariedEmployee(int number, String name, int year, int month, int day, double monthlySalary, int workingDay, int totalDays) {
        super(number, name, year, month, day);
        this.monthlySalary = monthlySalary;
        this.workingDay = workingDay;
        this.totalDays = totalDays;
    }

    public Test22SalariedEmployee() {
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    //实现父类的抽象方法earnings()，该方法返回月薪*出勤天数/本月总工作日；
    @Override
    public double earnings() {
        return (int)(monthlySalary * workingDay / totalDays);
    }

    @Override
    public String toString() {
        return super.toString() + "com.hasaki.dayexer.Test22SalariedEmployee{" +
                "monthlySalary=" + monthlySalary +
                ", workingDay=" + workingDay +
                ", totalDays=" + totalDays +
                '}';
    }
}
