package com.hasaki.dayexer;
/*
给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求 第 20190324 项的最后 4 位数字。
 */
public class Test37 {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 1;
        for(int i = 3; i < 20190324; i ++) {
            int temp = (a + b + c) % 10000;
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(c);
    }
}