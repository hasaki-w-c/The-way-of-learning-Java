package com.hasaki.dayexer;/*
题目：定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素的最大值、最小值、平均值，和，并输出。
要求：所有随机数是两位数：[10,99]

这里会用到一个获取随机数的方法:Math.random() : [0.0,1.0)

要得到题目要求，则需要进行一系列改变
Math.random() * 90 :[0.0,90.0)
(int)(Math.random() * 90) : [0,89]
(int)(Math.random() * 90 + 10) ： [10,99]

所以就得出一个公式：
获取[a,b]内的随机数：(int)(Math.random() * (b - a + 1) + a)
 */

import java.util.Arrays;

public class Test08 {
    public static void main(String[] args){
        int[] a = new int[10];

        //数组的赋值过程
        for (int i = 0; i < a.length; i ++)
        {
            a[i] = (int)(Math.random() * 90 + 10);
        }

        //查看数组元素
            System.out.println("数组元素为" + Arrays.toString(a));

        //求数组的最大值
        int max = a[0];
        for (int i = 1; i < a.length; i ++){
            if (max < a[i]){
                max = a[i];
            }
        }
        System.out.println("最大值为" + max);

        //求数组的最小值
        int min = a[0];
        for (int i = 1; i < a.length; i ++){
            if (min > a[i]){
                min = a[i];
            }
        }
        System.out.println("最小值为" + min);

        //求数组的总和
        int sum = 0;
        for (int i = 1; i < a.length; i ++){
            sum +=a[i];
        }
        System.out.println("总和为" + sum);

        //求数组的平均值
        double avg = (double) sum / a.length;
        System.out.println("平均值为" + avg);
    }
}
