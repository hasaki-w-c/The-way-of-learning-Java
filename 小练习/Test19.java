package com.hasaki.dayexer;/*
题目：写一个测试程序。要求：
1.创建一个Test19Customer，名字叫王琛，他有一个账号为1，余额为2000元，年利率为1.23%的账户。
2.对王琛进行操作。
存入100；
取出960；
取出2000；
打印出王琛的基本信息。
 */

public class Test19 {
    public static void main(String[] args) {
        Test19Customer customer = new Test19Customer("琛","王");
        Test19Account account = new Test19Account(1,2000,0.0123);
        customer.setAccout(account);

        //存入100
        customer.getAccout().deposit(100);
        //取960
        customer.getAccout().withdraw(960);
        //取2000
        customer.getAccout().withdraw(2000);

        System.out.println("Customer [" + customer.getLastname() + " " + customer.getFirstname()
                + "] has a account : id is " + customer.getAccout().getId()
                + ", annualInterestRate is " + customer.getAccout().getAnnualInterestRate() * 100
                + " %, balance is " + customer.getAccout().getBalance());
    }
}
