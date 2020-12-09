package com.hasaki.dayexer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：编写一个程序，开启三个线程，者三个线程的ID分别为A，B，C，每个线程将自己的ID在屏幕上打印十遍，
 * 要求输出的结果必须按顺序显示。如：ABCABCABCABC...依次递归
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/20 13:29
 */
public class Test45 {
    public static void main(String[] args) {
        AlternateDemo ad = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    ad.loopA(i);
                }
            }
        },"A").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    ad.loopB(i);
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    ad.loopC(i);

                    System.out.println("---------------------------------");
                }
            }
        },"C").start();
    }
}

class AlternateDemo{
    private int num = 1;
    //当前正在执行线程的标记

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     *
     * @param totalLoop : 循环第几次
     */
    public void loopA(int totalLoop) {

        lock.lock();

        try {
            //1.判断
            if (num != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.打印
//            for (int i = 0; i <= 5; i++) {
//                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
//            }
            System.out.println(Thread.currentThread().getName() + "\t"  + "\t" + totalLoop);
            //3.唤醒
            num = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }

    }

    public void loopB(int totalLoop) {

        lock.lock();

        try {
            //1.判断
            if (num != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.打印
//            for (int i = 0; i <= 15; i++) {
//                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
//            }
            System.out.println(Thread.currentThread().getName() + "\t" + "\t" + totalLoop);
            //3.唤醒
            num = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }

    }

    public void loopC(int totalLoop) {

        lock.lock();

        try {
            //1.判断
            if (num != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.打印
//            for (int i = 0; i <= 20; i++) {
//                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
//            }
            System.out.println(Thread.currentThread().getName() + "\t" + "\t" + totalLoop);
            //3.唤醒
            num = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }

    }
}
