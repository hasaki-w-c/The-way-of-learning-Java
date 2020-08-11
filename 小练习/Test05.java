/*
从键盘写入学生成绩，找出最高分，并输出学生成绩以及成绩等级。
 */

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {

        //输入学生个数
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生人数：");
        int n = sc.nextInt();

        //输入学生成绩添加到数组
        System.out.println("请输入" + n + "个成绩");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //比较学生成绩找到最大值
        int max = 0;
        for (int j = 0; j < n - 1; j++) {
            if (max < a[j] && max < a[j + 1]) {
                if (a[j] >= a[j + 1]) {
                    max = a[j];
                } else {
                    max = a[j + 1];
                }
            } else {
                break;
            }
        }
        System.out.println("最高分数是：" + max);

        //划分成绩等级进行总输出
        for (int k = 0; k < n; k++) {
            char l = ' ';
            if (a[k] >= max - 10) {
                l = 'A';
            }
            if (a[k] >= max - 20 && a[k] < max - 10) {
                l = 'B';
            }
            if (a[k] >= max - 30 && a[k] < max - 20) {
                l = 'C';
            }
            if (a[k] < max - 30) {
                l = 'D';
            }
            System.out.println("student " + k + " score is " + a[k] + " grade is " + l);
        }
    }
}
