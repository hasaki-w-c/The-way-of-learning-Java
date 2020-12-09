package juc;

/**
 * 题目：判断打印的“one” or “two” ？
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/20 14:31
 *
 * 线程八锁
 *
 * 1.两个普通同步方法，两个线程，标准打印，打印？ //one  two
 * 2.新增Thread.sleep() 给 getOne(),打印？ //one  two
 * 3.新增普通方法getThree(),打印？ //three one two
 * 4.两个普通的同步方法，两个Number对象，打印？ //two  one
 * 5.修改getOne()为静态同步方法，打印？ //two  one
 * 6.修改两个方法均为静态同步方法，一个Number对象？ //one  two
 * 7.一个是静态同步方法一个非静态总部方法，两个Number对象？ //two one
 * 8.两个均为静态同步方法，两个Number对象，打印？ //one two
 *
 * 线程八锁的关键：
 * ①非静态方法的锁默认为 this ，静态方法的锁为对应的 Class 的实例
 * ②某一个时刻内，只能由一个线程持有锁，无论几个方法。
 */
public class Thread8MonitorTest {
    public static void main(String[] args) {
        Number num1 = new Number();
        Number num2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                num1.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                num1.getTwo();
                num2.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                num.getThree();
//            }
//        }).start();
    }
}

class Number{

    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("three");
    }
}
