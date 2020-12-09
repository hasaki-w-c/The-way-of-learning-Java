package juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1.ReadWriteLock : 读写锁
 *
 * 写写/读写 需要“互斥”
 * 读读 不需要互斥
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/20 13:55
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.write((int)(Math.random() * 101));
            }
        },"write :").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.read();
                }
            }).start();
        }
    }

}

class ReadWriteLockDemo{
    private int num = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读
     */
    public void read() {
        //上锁
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.readLock().unlock();
        }
    }

    /**
     * 写
     * @param num 共享数据num
     */
    public void write(int num) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.num = num;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
