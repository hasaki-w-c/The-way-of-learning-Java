package com.hasaki.dayexer;
/*
创建三个窗口买票，总票数为100张,使用实现Runnable接口的方式

1。问题：卖票过程中，出现了重票、错票-->出现了线程安全问题
2.出现的原因：当某个线程操作票时，尚未完成时，其他线程参与进来，也操作车票。
3.如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来。直到此线程操作完ticket的时候，其他线程才可以开始操作ticket。
4.在Java中，我们通过同步机制，来解决线程的安全问题。

  方式一：同步代码块
    synchronized(同步监视器){
        //需要被同步的代码

    }

    说明：1.操作共享数据的代码即为需要同步的代码    -->不能包含代码多了，也不能包含代码少了。
         2.共享数据：多个线程共同操作的变量。比如本问题当中的ticket就是共享数据。
         3.同步监视器：俗称锁。任何一个类的对象都可以充当锁。要求：多个线程必须共用同一把锁。

    补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。

  方式二：同步方法
    如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明成同步的。

    总结：1.同步方法任然涉及到同步监视器，只是不需要我们显示的声明。
         2.非静态的同步方法，同步监视器是this
         3.静态的同步方法，同步监视器是当前类本身
5.同步的方式，解决了线程的安全问题。--好处
  操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。--局限性
 */
class window1 implements Runnable {
    private int ticket = 100;
    Dog1 dog1 = new Dog1();
    @Override
    public void run() {
        //Dog1 dog1 = new Dog1();    //放这里安全问题就解决不了了，三个线程必须共用同一把锁。
        while (true) {
            //synchronized (Dog1) {    方式二
            synchronized (this){    //此时的this：唯一的Window1对象，最方便的方法。
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":买票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class Test30 {
    public static void main(String[] args) {
        window1 w = new window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Dog1 {

}
