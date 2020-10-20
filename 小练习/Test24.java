package com.hasaki.dayexer;/*
1.声明一个枚举类型Status,
 Status（员工状态），可以限定为4个：空闲(Free)，忙碌(Busy)，休假(Vocation)，离职(Left)
2.给Status声明一个属性，String,desc,并在创建常量对象时，为desc赋值为对应的意思，
3.声明一个员工类型Employee,有属性：编号，姓名，状态
4.在测试类中，创建一个员工数组，5个对象，分别初始化为不同的状态，遍历显示
 */

import java.util.Arrays;

public class Test24 {
    public static void main(String[] args) {
        Test24Employee[] all = new Test24Employee[5];

        all[0] = new Test24Employee(1,"张三", Test24Status.BUSY);
        all[1] = new Test24Employee(2,"李四", Test24Status.FREE);
        all[2] = new Test24Employee(3,"王麻子", Test24Status.LEFT);
        all[3] = new Test24Employee(4,"王琛", Test24Status.VOCATION);
        all[4] = new Test24Employee(5,"王小琛", Test24Status.BUSY);

        for (int i = 0; i < all.length; i ++) {
            System.out.println(all[i]);
        }
    }
}
