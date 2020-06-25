package paixu;

/*
 * 此程序为冒泡排序
 * 其时间复杂度为O(N^2)。这是一个非常高的时间复杂度
 */
import java.util.Scanner;

public class Maopao {

    public static void main(String[] args) {
        int[] a = new int[100];
        int i, j;
        Scanner ge = new Scanner(System.in);
        System.out.println("请输入有多少个数要进行排序：");
        int n = ge.nextInt();    //输入一个数n，表示接下来有n个数

        System.out.println("请输入需要排序的数字：");
        for (i = 1;i <= n;i ++)    //循环读入n个数到数组a中
        {
            Scanner in = new Scanner(System.in);

            int b = in.nextInt();
            a[i] = b;
        }

        //冒泡核心代码部分
        for (i = 1;i <= n-1;i ++)
        {
            for (j = 1;j <= n-i; j++)
            {
                int t;
                if (a[j] < a[j+1])
                {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        //输出
        System.out.println("输出排序结果：");
        for (i = 1;i <= n;i ++)
        {
            System.out.println(a[i]);
        }
    }
}
