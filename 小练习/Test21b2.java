package com.hasaki.dayexer;

public class Test21b2 {
    public static void main(String[] args) {
        Test21GraphicTools tools = new Test21GraphicTools();

        Test21Circle c1 = new Test21Circle(1);
        Test21Circle c2 = new Test21Circle(1);

        boolean isEqual = tools.compare(c1, c2);
        System.out.println(isEqual);

        Test21Rectangle r1 = new Test21Rectangle(3,2);
        Test21Rectangle r2 = new Test21Rectangle(4,3);
        System.out.println(tools.compare(r1,r2));

        Test21Triangle t1 = new Test21Triangle(1,2,3);
        Test21Triangle t2 = new Test21Triangle(1,2,3);
        System.out.println(tools.compare(t1,t2));
    }
}
