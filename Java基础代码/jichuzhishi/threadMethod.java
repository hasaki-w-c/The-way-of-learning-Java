package jichuzhishi;

/*
测试Thread类中的常用方法：
1.start()：启动当前线程；调用当前线程的run()
2.ran()：通常需要重写Thread类中的此方法，将创建的线程的执行操作声明在此方法中
3.currentThread()：静态方法，返回执行当前代码的线程
4.getName()：获取当前线程的名字
5.setName：设置当前线程的名字
6.yield()：释放当前CPU的执行权
7.join()：在线程a中调用线程b的join()，此时线程a进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
8.stop()：已过时的方法，当执行此方法，强制结束此线程。
9.sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒数。在指定的毫秒内，当前线程是阻塞状态。
10.isAlive()：判断当前线程是否还存活。

线程的优先级：
1.
MAX_PRIORITY: 10  //
MIN_PRIORITY: 1  //
NORM_PRIORITY: 5  //默认的优先级
2.如何获取和设置当前线程的优先级：
  getPriority():获取线程的优先级
  setPriority(int p):设置线程的优先级

  PS:优先级高的线程要抢占低优先级的线程CPU的执行权，但只是概率高，并不意味着只有当高优先级的线程执行完后，低优先级的线程才执行。
 */
public class threadMethod {
    public static void main(String[] args) {
        HeThread h1 = new HeThread("分：hasaki");    //有参构造更改线程名
        //h1.setName("常伴吾身");    //更改线程名
        h1.start();

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        //给主线程命名
        Thread.currentThread().setName("主：死亡如风");

        //设置主线程的优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":"+ i + " ");
            }

            //if (i == 20) {
            //    try {
            //        h1.join();
            //    } catch (InterruptedException e) {
            //        e.printStackTrace();
            //    }
            //}
        }
        System.out.println();
        System.out.println(h1.isAlive());

    }
}

class HeThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                //try {
                //    sleep(1000);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}

                System.out.print(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i + " ");
            }

            //if (i % 20 == 0) {
            //    this.yield();
            //}
        }
    }

    //使用有参构造来 对其命名
    public HeThread(String name) {
        super(name);
    }
}
