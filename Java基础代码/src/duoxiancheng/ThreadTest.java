package duoxiancheng;

/**
 * 多线程的创建
 *  方式一：继承于Thread类
 *    1.创建一个继承于Thread类的子类
 *    2.重写Thread类的run()--->将此线程执行的操作声明在run()中
 *    3.创建Thread子类的对象
 *    4.通过此对象调用start()
 *
 *例子：遍历100以内的偶数
 *
 * PS：解决线程安全问题翻阅littlePractice的Test29，32
 *
 * @author 王琛
 */
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start()：①启动当前线程 ②调用当前线程的run()
        t1.start();
        //t1.run();    //不能通过直接调用run方法启动线程，这里调用run方法调用的就只有main方法，只有一个线程，没有分出多个线程。

        //再启动一个线程，遍历100以内的偶数，此时不可以再去调用已经start()的线程去执行。会报IllegalThreadStateException异常。
        //得重新创建一个Thread类的子类的对象
        MyThread t2 = new MyThread();
        t2.start();

        //如下操作在任然在main线程中执行的，以下遍历可使此程序明显看出是多线程
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.print(Thread.currentThread().getName() +":" + i + " ");
            }
        }
    }
}
/**
 *
 1.创建一个继承于Thread类的子类
 */
class MyThread extends Thread {
    //2.重写run()

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(Thread.currentThread().getName() +":" + i + " ");
            }
        }
    }
}