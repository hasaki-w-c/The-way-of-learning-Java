package com.hasaki.dayexer;

public class Test13 {
    public static void main(String[] args) {
        Test13 ol = new Test13();
        ol.testOL(2);
        ol.testOL(2,3);
        ol.testOL("王琛");
    }

    public static void testOL(int a){
        System.out.println(a * a);
    }

    public static void testOL(int a , int b){
        System.out.println(a * b);
    }

    public static void testOL(String a){
        System.out.println(a);
    }
}
