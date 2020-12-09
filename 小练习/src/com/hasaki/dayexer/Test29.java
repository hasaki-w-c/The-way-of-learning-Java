package com.hasaki.dayexer;

import java.awt.*;
import java.util.concurrent.locks.Lock;

/*
创建三个窗口买票，总票数为100张，使用继承Thread类的方法来做的。

使用同步代码块来解决继承Thread类的方式的线程安全问题

说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器。考虑使用当前类来充当同步监视器。
 */
class window extends Thread {

    private static int ticket = 100;    //加了static以后，就是三个对象共享同一个静态变量
    //private int ticket = 100;    //未加static的时候是每个对象都会分配100张票

    //static Dog2 dog2 = new Dog2();    //还得加static，才可以是共享一个锁

    @Override
    public void run() {

        while (true) {
            //synchronized (dock2) {    //正确的
            synchronized (Window.class) {    //类也是对象，Window2只会加载一次
            //synchronized (this) {    //此时是错误的，this代表的是t1,t2,t3,三个对象
                if (ticket > 0) {
                    System.out.println(getName() + ":买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class Test29 {
    public static void main(String[] args) {
        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
//class Dog2 {}