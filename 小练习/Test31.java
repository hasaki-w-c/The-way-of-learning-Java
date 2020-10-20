package com.hasaki.dayexer;
/*
使用同步方法解决实现Runnable接口的线程安全问题。

 */
class window2 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
            }
        }

        private synchronized void show ()  {    //同步监视器就是this

            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":买票号为：" + ticket);
                ticket--;
            }
        }
}
public class Test31 {
    public static void main(String[] args) {
        window2 w = new window2();

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
