package jichuzhishi;

import java.util.Arrays;

/*
二维数组的使用：
1.如果数组的元素，又是数组类型的，则构成了多维数组。
 */
public class Shuzu2 {
    public static void main(String[] args)
    {
        //1.二维数组初始化
        //静态初始化：数组的赋值和数组元素的赋值同时进行
        int[][] arr1 = new int[][]{{1,2,3},{4,5},{7,8}};
        //二维数组的输出
        System.out.println(Arrays.deepToString(arr1));
        //动态初始化：数组的初始化和数组元素分开进行
        //动态初始化方式一：
        int[][] arr2 = new int[3][2];
        //动态初始化方式二：
        int[][] arr3 = new int[3][];
        //错误的初始化方式：int[][] arr3 = new int[][3];

        //2.二维数组的调用：使用角标调用数组元素
        System.out.println(arr1[1][0]);

        //3.数组的长度
        System.out.println(arr1.length);    //3
        System.out.println(arr1[1].length);    //2

        //4.二维数组的遍历
        for (int i = 0; i < arr1.length; i ++){
            for (int j = 0; j < arr1[i].length; j ++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
