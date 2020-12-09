package com.hasaki.dayexer;

import java.util.Arrays;
import java.util.Scanner;

/*
设置args在运行->编辑配置
从命令行接收一个整数，作为int[]数组的长度
再从键盘输入几个整数，为数组的元素赋值
找出最大值
给带码加上try...catch，看看可能发生什么异常。
 */
public class Test25TryCatch1 {
    public static void main(String[] args) {
        try {
            System.out.println("数组的长度为：" + args[0]);
            int l = Integer.parseInt(args[0]);

            int arr[] = new int[l];
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(Arrays.toString(arr));

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    int t;
                    if (arr[j] < arr[j + 1]) {
                        t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
                }
            }

            System.out.println("最大值为：" + arr[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("参数的整数不能为0！");
        } catch (NumberFormatException e) {
            System.out.println("传入的参数不是整数！");
        } catch (ArithmeticException e) {
            System.out.println("数学运算错误！");
        }catch (NegativeArraySizeException e) {
            System.out.println("参数不能是负数！");
        }catch (Exception e) {
            System.out.println("存在异常！");
        }
    }
}
