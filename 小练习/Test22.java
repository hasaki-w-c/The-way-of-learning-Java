package com.hasaki.dayexer;

import java.util.Arrays;
import java.util.Scanner;

public class Test22 {
    public static void main(String[] args) {
        Test22Employee[] arr = new Test22Employee[3];
        arr[0] = new Test22SalariedEmployee(1001, "张三", 1998, 8, 8, 20000, 20, 23);
        arr[1] = new Test22HourlyEmployee(1002, "李四", 1999, 9, 9, 80, 100);
        arr[2] = new Test22SalariedEmployee(1003, "王琛", 2000, 10, 10, 25000, 25, 22);

        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
            System.out.println("实发工资：" +arr[i].earnings());
        }
        System.out.println("-------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("请输入本月的月份：");
        int month = input.nextInt();
        for (int j = 0; j < arr.length; j ++) {
            System.out.println(arr[j]);
            if (arr[j].getBirthday().getMonth() == month) {
                int money = (int) (arr[j].earnings() + 100);
                System.out.println("实发工资：" +money);
                //System.out.println("实发工资：" +arr[j].earnings() + 100);    //不知为何100只会拼接到后边，而不是相加
            }else {
                System.out.println("实发工资：" +arr[j].earnings());
            }
        }
    }
}
