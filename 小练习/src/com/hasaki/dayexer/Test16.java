package com.hasaki.dayexer;/*
体会封装性
 */

public class Test16 {
    public static void main(String[] args) {
        Test16preson b = new Test16preson();

        b.setAge((int)(Math.random() * 131));
        System.out.println(b.getAge());
    }
}
