package jichuzhishi;
/*
创建多线程的简单方法实现
 */
public class ThreadTestAchieve {
    public static void main(String[] args) {
        //创建匿名对象，因为其只使用一次，可以使用匿名对象方法
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.print(Thread.currentThread().getName() + ":" + i + " ");
                    }
                }
            }
        }.start();
    }
}
