package com.hasaki.dayexer;

import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/*
题目：银行里有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 */
class Counter implements Runnable {

    private static int count = 0;    //账户
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                count += 1000;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存入完毕！" + "账户余额：" + count);
            }
        } finally {
            lock.unlock();
        }
    }
}
public class Test34 {
    public static void main(String[] args) {
        Counter c = new Counter();

        //两个储户
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.setName("储户一");
        t1.start();
        t2.setName("储户二");
        t2.start();

    }
}
