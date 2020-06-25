package paixu;

import java.util.Scanner;

public class Xuanze {

    public static void main(String[] args) {
        int[] a = new int[100];
        int i, j;
        int p;    //记录角标
        int t;    //交换变量

        System.out.println("请输入有多少个数要进行排序：");
        Scanner ge = new Scanner(System.in);
        int n = ge.nextInt();    //输入一个数n，表示接下来有n个数

        System.out.println("请输入需要排序的数字：");
        for (i = 0;i <= n -1;i ++)    //循环读入n个数到数组a中
        {
            Scanner in = new Scanner(System.in);
            int b = in.nextInt();
            a[i] = b;
        }

        //外层循环控制需要排序的趟数
        for (i = 0; i < n - 1; i ++) {
            //新的趟数、将⻆标重新赋值为0
            p = 0;
            //内层循环控制遍历数组的个数并得到最⼤数的⻆标
            for (j = 0; j < n - i; j ++) {
                if (a[j] > a[p]) {
                    p = j;
                }
            }
            //交换
            t = a[p];
            a[p] = a[n - 1 - i];
            a[n - 1 - i] = t;
        }

        System.out.println("输出排好序的数：");
        for (i = 0;i <= n - 1;i ++)
        {
            System.out.println(a[i]);
        }
    }
}
