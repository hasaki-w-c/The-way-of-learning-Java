package com.hasaki.dayexer;/*
模板设计
 */

public class Test23 {
    public static void main(String[] args) {
        //看一下求1-100000的累加和的运行时间
        MyCalTime m = new MyCalTime();
        long time = m.geTime();
        System.out.println("耗时：" + time + "毫秒");
    }
}

abstract class CalTime{
    public long geTime() {
        //获取开始时间start
        long start = System.currentTimeMillis();

        //执行xx代码
        dowork();

        //获取结束时间end
        long end = System.currentTimeMillis();

        //计算时间差
        return end - start;
    }

    protected abstract void dowork();    //代表执行xx代码
}

class MyCalTime extends CalTime {
    @Override
    protected void dowork() {
        //计算1-100000的累加和
        long sum = 0;
        for (int i = 1; i < 100000; i++) {
            sum += i;
        }
        System.out.println("1-100000的累加和：" + sum);
    }
}
