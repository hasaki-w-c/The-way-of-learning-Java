package com.hasaki.dayexer;
/*
使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class Test33 {
}

class Bank {
    private Bank(){}

    private static Bank instance = null;    //Bank就是锁

    public static synchronized Bank getInstance() {
        //方式一：效率稍差
        //synchronized (Bank.class) {
        //    if (instance == null) {
        //        instance = new Bank();
        //    }
        //    return instance;
        //}
        //方式二：效率更高
        if (instance == null) {

            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
                return instance;
            }
        }
        return instance;
    }
}
