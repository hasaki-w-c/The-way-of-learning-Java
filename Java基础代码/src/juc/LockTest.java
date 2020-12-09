package juc;

import java.util.concurrent.locks.ReentrantLock;
/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/19 16:02

 解决线程安全问题的方式三：Lock锁----JDK5.0新增

 1.面试题：synchronized与Lock的异同？
 相同：二者都可以解决线程安全问题
 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）

 开发中建议使用顺序：建议优先使用Lock,然后是同步代码块，最后是同步方法

 2.面试题：如何解决线程安全问题？有几种方式
 3种，其余两种在littlePractice里的Test29.30.31.32里。
 */
class GetWindow implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            try {
                //调用锁定方法lock()
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        GetWindow gw = new GetWindow();

        Thread t1 = new Thread(gw);
        Thread t2 = new Thread(gw);
        Thread t3 = new Thread(gw);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
