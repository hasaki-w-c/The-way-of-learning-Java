package jichuzhishi;

import java.util.Arrays;

/*
数组的常用算法：复制，反转，查找
 */
public class Shuzusuanfa {
    public static void main(String[] args){
        String[] a = new String[]{"AA","BB","CC","DD","EE","FF"};

        //复制
        String[] a1 = new String[a.length];
        for (int i = 0; i < a1.length; i ++){
            a1[i] = a[i];
        }
        //错误的复制操作：String[] a1;a1 = a;

        //反转
        /*方法一
        for (int start = 0,end = a.length - 1;start < end; start ++,end --){
            String temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }

        //方法二
        for (int i = 0; i < a.length / 2; i ++){
            String temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        //查看是否反转成功
        System.out.println(Arrays.toString(a));
        */

        //查找
        //方式一：线性查找
        String str = "DD";
        boolean flag = true;
        for (int i = 0; i < a.length; i ++){
            if (a[i].equals(str)){    //字符串比较相等用equals()
                System.out.println("找到了，索引位置为：" + i);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("抱歉，没有找到");
        }

        //方式二：二分法查找（前提：数组要是有序的数组）

    }
}
