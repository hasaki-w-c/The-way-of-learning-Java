package jichuzhishi;
/*
线程通信的例子：使用两个线程打印1-100.线程一，线程二交替打印

涉及到的三个方法：
wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程，就会唤醒优先级高的那个线程。
notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。

说明：
1.wait(),notify(),notifyAll()这三个方法必须使用在同步代码块或同步方法中。
2.wait(),notify(),notifyAll()这三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
    否则会出现IllegalMonitorStateException异常。
3.wait(),notify(),notifyAll()这三个方法定义在java.lang.Object类中

面试题：sleep()和wait()的异同？
1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
2.不同点：①两个方法声明的位置不一样：Thread类中声明sleep(),Object类中声明wait();
         ②调用的要求不同：sleep()方法可以在任何需要的场景下调用。wait方法必须使用在同步代码块或者同步方法中。
         ③关于是否释放同步监视器的问题：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放同步监视器，wait()会释放同步监视器。
 */

import java.util.Enumeration;

class Number implements Runnable {

    private static int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            synchronized (obj) {

                obj.notifyAll();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }

    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
