package jichuzhishi;

import java.util.Scanner;
/*
do while 循环体
键盘输入字符与条件所要求字符进行比对，比对成功输出十遍NB，比对失败则只输出一遍NB。
*/
public class Dowhiledemo {

    public static void main(String[] args)
    {
        int x = 0;
        Scanner input=new Scanner(System.in);
        String str=input.next();
        do
        {
            System.out.println("NB!");
            x +=1;
            if(x >= 10) break;
        }while(str.equals("n"));    //输入字符与n相比来决定是否进入循环。
    }
}