package jichuzhishi;

import java.util.Scanner;

public class Diguidemo {    //递归求1到n的和
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int retValue = sum(n);
        System.out.println("和为" + retValue);
    }

    public static int sum(int n) {
        if (n == 1)
            return 1;
        return n + sum(n-1);
    }
}