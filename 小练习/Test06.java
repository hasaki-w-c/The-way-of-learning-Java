/*
获取数组a中元素的和，a中的元素通过键盘输入。
 */

import java.util.Scanner;

public class Test06 {
    public static void main(String[] args)
    {
        int[][] a = new int[3][4];
        Scanner sc = new Scanner(System.in);

        int add = 0;
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a[i].length; j ++)
            {
                a[i][j] = sc.nextInt();
                add = add + a[i][j];
            }
        }
        System.out.println(add);
    }
}