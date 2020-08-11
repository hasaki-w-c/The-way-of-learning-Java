/*
使用简单数组
（1）创建一个类，在main方法中声明a1和a2两个变量，他们是int类型的数组。
（2）使用大括号{}，把a1初始化为8个素数；2，3，5，7，11，13，17，19.
（3）显示a1的内容
（4）赋值a2变量等于a1,修改a2中的偶索引元素，打印a1。

思考：a1和a2是什么关系？(为什么修改a2的值，a1的值也改变)
答：不同的变量，但是指向了堆空间中的同一个数组。

拓展：修改题目，实现a2对a1数组的复制

 */

package jichuzhishi;

import java.util.Arrays;

public class shuzucopy {
    public static void main(String[] args){
        //声明
        int[] a1,a2;

        //初始化
        a1 = new int[]{2,3,5,7,11,13,17,19};

        //查看a1内容
        System.out.println(Arrays.toString(a1));    //[2, 3, 5, 7, 11, 13, 17, 19]

        //赋值a2变量等于a1
        a2 = a1;

        /*拓展（实现a2对a1数组的复制）
        a2 = new int[a1.length];
        for (int i = 0; i < a1.length; i ++){
            a2[i] = a1[i];
        }
         */

        //修改a2
        for (int i = 0; i < a1.length; i ++){
            if (i % 2 == 0){
                a2[i] = i;
            }
        }

        //查看a1
        System.out.println(Arrays.toString(a1));    //[0, 3, 2, 7, 4, 13, 6, 19]
    }
}
