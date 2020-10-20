package jichuzhishi;
/*
创建多线程方法二：实现Runnable接口
1.创建一个实现了Runnable接口的类
2.实现类去实现Runnable中的抽象方法：run()
3.创建实现类的对象
4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
5.通过Thread类的对象调用start()

比较创建线程的两种方式。
开发中：优先选择实现runnable接口的方式
原因：1.实现的方式没有类的单继承的局限性
     2.实现的方式更适合处理多个线程共享数据的情况。

联系：public class Thread implements Runnable
相同点：都需要重写run(),将线程要执行的逻辑声明在run()中。

PS：解决线程安全问题翻阅littlePractice的Test30，31

 */
//1.创建一个实现了Runnable接口的类
class MThread implements Runnable {
    //2.实现类去实现Runnable中的抽象方法：run()

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread m1 = new MThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        //5.通过Thread类的对象调用start()
        t1.setName("线程一");
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(m1);
        t2.setName("线程二");
        t2.start();
    }
}
