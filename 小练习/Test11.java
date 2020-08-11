/*
设计一个Test11Circle类来计算圆的面积，并在测试类中测试。
 */

import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入圆的半径：");
        double x = sc.nextDouble();
        double S = Test11Circle.mianji(x);
        System.out.println("圆的面积为：" + S);
    }
}
