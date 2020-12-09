package com.hasaki.dayexer;/*
键盘输入三角形的底和高，调用方法求出其面积。
 */

import java.util.Scanner;

public class Test18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test18TriAngle set = new Test18TriAngle();
        set.setBase(sc.nextDouble());
        set.setHeight(sc.nextDouble());

        System.out.println(set.area());
    }
}
