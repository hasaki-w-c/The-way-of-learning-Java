package juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提高了相应的速度。
 *
 * 二、线程池的体系结构：
 *      java.util.concurrent.Executor : 负责线程的使用和调度的根接口
 *          |--**ExecutorService 子接口 ：线程池的主要接口
 *              |--ThreadPoolExecutor : 线程池的实现类
 *              |--ScheduledExecutorService 子接口：负责线程的调度
 *                  |--ScheduledThreadPoolExecutor ：继承了ThreadPoolExecutor，又实现了ScheduledExecutorService
 *
 * 三、工具类 ： Executors
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个的线程池。线程池中只有一个线程
 *
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程池，可以延迟或定时地去执行任务。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/20 15:35
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            ScheduledFuture<Integer> future = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //生成随机数
                    int num = (int) new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }
            }, 2, TimeUnit.SECONDS);

            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
