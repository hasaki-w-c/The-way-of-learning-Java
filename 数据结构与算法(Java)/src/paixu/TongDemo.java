package paixu;

/*
 * 此程序为对数据范围在0~10000以内的整数排序，使用桶排对其排序
 * 该算法的时间复杂度为O（2*（m+n））。m为桶的个数，n为待排序数的个数。
 * 缺点：非常浪费空间。
 */
import java.util.Scanner;

public class TongDemo {
    public static void main(String[] args)
    {
        int[] book = new int[10001];
        int i, j;
        for (i = 0;i < 10000;i ++)
        {
            book [i] = 0;
        }

        Scanner ge = new Scanner(System.in);
        System.out.println("请输入有多少个数要进行排序：");
        int n = ge.nextInt();

        System.out.println("请输入需要排序的数：");
        for (i = 1;i <= n;i ++)
        {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();    //把每一个数读到变量t中
            book[t] ++;    //进行计数，对编号为t的桶放一个标记
        }

        System.out.println("输出排好的数：");
        for (i = 10000;i >= 0;i --)    //依次判断编号10000~0的桶
        {
            for (j = 1;j <= book[i];j ++)
            {
                System.out.println(i);    //出现了几次就将桶的编号打印几次
            }
        }
    }
}
