package com.hasaki.dayexer;
/**
把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包 含数字 2 和 4，一共有多少种不同的分解方法？
注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和 1001+1000+18 被视为同一种。
 * @author Lenovo
 */
public class Test38 {
    //首先我们分析组成2019的三个数有哪几类？1.ABC类排列方式为六种（ABC，ACB，BAC，BCA，
    //CAB，CBA），2.AAB类排列方式有三种（AAB，ABA，BAA），3.AAA类排列方式一种。而题目要

    //求把 2019 分解成 3 个各不相同的正整数之和也就是说只保留ABC类的组合方式，j = i + 1，

    public static void main(String[] args) {
        int n = 2019;
        int num = 0;
        for (int i = 1; i < n; i++) {
            if ((i + "").contains("2") || (i + "").contains("4"))
                continue;
            for (int j = i + 1; j < n; j++) {
                if ((j + "").contains("2") || (j + "").contains("4"))
                    continue;
                int k = n - i - j;
                if (i == k || j == k || i == j)
                    continue;
                if (k > 0 && !(k + "").contains("2") && !(k + "").contains("4"))
                    num++;
            }
        }
        System.out.println(num / 3);
    }
}
