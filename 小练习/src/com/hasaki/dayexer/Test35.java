package com.hasaki.dayexer;
/*
线程通信的应用：经典例题：生产者/消费者问题

生产者（Producer）将产品交给店员（Clerk）,而消费者（Customer）从店员处取走产品，店员一次只能持有固定数量的产品（比如：20），
如果生产者试图生产更多的产品，店员会叫生产者停止生产，等待店中有空位了，再通知生产者继续生产；如果店中没有产品了，店员会告诉
消费者等待一会儿，等待店中有产品了，再通知消费者来取走产品。

分析：
1.是否是多线程问题？    是，生产者线程，消费者线程
2.是否有共享数据？    有，店员（或产品）
3.如何来解决线程安全问题？    同步机制，有三种方法
4.是否涉及到线程通信？    是
 */
class Clerk {

    private int productCount = 0;
    public synchronized void produceProduct() {    //生产产品
        if (productCount < 20) {
            productCount ++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");

            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {    //消费产品
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount --;

            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {    //生产者
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品....");

        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

class Customer implements Runnable {    //消费者

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始消费产品....");

        while (true) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}
public class Test35 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);

        Thread s1 = new Thread(p1);

        s1.setName("生产者1");

        Customer c1 = new Customer(clerk);

        Thread x1 = new Thread(c1);

        x1.setName("消费者1");

        Customer c2 = new Customer(clerk);

        Thread x2 = new Thread(c2);

        x2.setName("消费者2");

        s1.start();
        x1.start();
        x2.start();
    }
}