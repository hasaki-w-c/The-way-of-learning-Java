package com.hasaki.dayexer;

import java.awt.*;

/*
使用同步方法解决实继承Thread类的方式中的线程安全问题。
 */
class window3 extends Thread {

    private static int ticket = 100;    //加了static以后，就是三个对象共享同一个静态变量

    @Override
    public void run() {

        while (true) {
            show1();
            }
    }

    private static synchronized void show1() {    //记得使用静态的方法，同步监视器Window3.class
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class Test32 {
    public static void main(String[] args) {
        window3 w1 = new window3();
        window3 w2 = new window3();
        window3 w3 = new window3();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
