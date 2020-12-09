package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/19 16:19
 */
public class ProducerAndConsumerByLockTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(producer, "生产者 A").start();
        new Thread(consumer, "消费者 B").start();
        new Thread(producer, "生产者 C").start();
        new Thread(consumer, "消费者 D").start();
    }
}

/**
 * 店员
 */
class Clerk1{
    private int product = 0;

    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    /**
     * 进货
     */
    public void getProduct() {
        lock.lock();

        try {
            //为了避免虚假唤醒问题，Wait()应该总是使用在循环中
            while (product >= 1) {
                System.out.println("产品库存以满！无法添加");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + "库存数量" + ++product);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 卖货
     */
    public void saleProduct() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("目前缺货。请稍等！");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + "库存数量"+ --product);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 生产者
 */
class Producer1 implements Runnable{
    private Clerk clerk;

    public Producer1(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.getProduct();
        }
    }
}

/**
 * 消费者
 */
class Consumer1 implements Runnable{
    private Clerk clerk;

    public Consumer1(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            clerk.saleProduct();
        }
    }
}