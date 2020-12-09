package duoxiancheng;

import java.util.concurrent.locks.ReentrantLock;

/**
解决线程安全问题的方式三：Lock锁----JDK5.0新增

1.面试题：synchronized与Lock的异同？
相同：二者都可以解决线程安全问题
不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
     Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）

开发中建议使用顺序：建议优先使用Lock,然后是同步代码块，最后是同步方法

2.面试题：如何解决线程安全问题？有几种方式
  3种，其余两种在littlePractice里的Test29.30.31.32里。
 */
class Window implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    /**
     * 获取Lock的实例
     */
    private final ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            //调用锁定方法lock()
            lock.lock();

            try {
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
                //3.调用解锁方法：unlock()，必须写到finally中，来保证肯定执行
                lock.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

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
