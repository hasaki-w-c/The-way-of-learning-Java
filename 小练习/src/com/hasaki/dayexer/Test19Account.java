package com.hasaki.dayexer;

public class Test19Account {
    private int id;    //账号
    private double balance;    //余额
    private double annualInterestRate;    //年利率

    public Test19Account(int id, double banlance, double annualInterestRate) {
        this.id = id;
        this.balance = banlance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    //取钱
    public void withdraw(double amout) {
        if (balance >= amout) {
            balance = balance - amout;
            System.out.println("成功取出：" + amout);
        } else {
            System.out.println("余额不足，取钱失败！");
        }
    }

    //存钱
    public void deposit(double amout) {
        if (amout > 0) {
            balance = balance + amout;
            System.out.println("成功存入：" + amout);
        }
    }
}
