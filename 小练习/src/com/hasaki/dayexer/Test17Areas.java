package com.hasaki.dayexer;

import java.util.Scanner;

public class Test17Areas {
    public void printAreas(Test17circle c , int time){
        System.out.println("redius" + "\t" + "Area");
        for (int i = 1; i <= time; i ++){
            c.redius = i;
            System.out.println(c.redius + "\t\t" + c.findArea());
        }
    }
}
