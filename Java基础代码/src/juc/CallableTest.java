package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
创建多线程的方式三：实现Callable接口。----JDK5.0新增

如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程强大？
1.call()可以有返回值。
2.call()可以抛出异常，被外面的操作捕获，获取异常信息。
3.Callable支持泛型。

 执行 Callable 方式，需要 FutureTask 实现类的支持，用于接受运算结果 。
 FutureTask 是 Future 接口的实现类

 扩展：FutureTask 也可用于闭锁
 */

//1.创建一个实现Callable接口的实现类
class NumThread implements Callable<Integer> {
    //2.实现call方法，将此线程需要执行的操作声明在call方法中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask<Integer> futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.如果对call方法中的返回值感兴趣的话，获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call方法的返回值。
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
