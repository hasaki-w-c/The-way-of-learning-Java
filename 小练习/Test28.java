package com.hasaki.dayexer;
/*
创建两个分线程，一个线程遍历100以内的偶数，另一个遍历100以内的奇数。
 */
public class  Test28 {
    public static void main(String[] args) {
        //MyThread1 t1 = new MyThread1();
        //t1.start();
        //MyThread2 t2 = new MyThread2();
        //t2.start();

        //对象只使用一次就使用匿名对象方法
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0) {
                        System.out.print(Thread.currentThread().getName() + ":" + i + " ");

                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0) {
                        System.out.print(Thread.currentThread().getName() + ":" + i + " ");

                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(Thread.currentThread().getName() + ":" + i + " ");
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0) {
                System.out.print(Thread.currentThread().getName() + ":" + i + " ");

            }
        }
    }
}