package com.hasaki.dayexer;

import java.util.Scanner;

/*
小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到 40 中这样的数包括 1、2、9、10 至
 32、39 和 40，共 28 个，他们的和是 574。 请问，在 1 到 n 中，所有这样的数的和是多少？
【输入格式】
输入一行包含两个整数 n。
【输出格式】
输出一行，包含一个整数，表示满足条件的数的和。
【样例输入】 40
【样例输出】 574
 */
public class Test39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int res = 0;
        for(int i = 1;i <= n;i++) {
            if(isValid(i)) res += i;
        }
        System.out.println(res);
    }
    public static boolean isValid(int num) {
        while(num > 0) {
            int g = num % 10;//获取个位数
            if(g == 2 || g == 0 || g == 1 || g == 9) return true;
            num = num / 10;//去掉个位数
        }
        return false;
    }
}
