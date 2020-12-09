package juc;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/19 16:19
 */
public class ProducerAndConsumerTest {

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
class Clerk{
    private int product = 0;

    /**
     * 进货
     */
    public synchronized void getProduct() {
        //为了避免虚假唤醒问题，Wait()应该总是使用在循环中
        while (product >= 1) {
            System.out.println("产品库存以满！无法添加");

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + "库存数量" + ++product);

        this.notifyAll();
    }

    /**
     * 卖货
     */
    public synchronized void saleProduct() {
        while (product <= 0) {
            System.out.println("目前缺货。请稍等！");

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + "库存数量"+ --product);

        this.notifyAll();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
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
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            clerk.saleProduct();
        }
    }
}