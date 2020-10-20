package com.hasaki.dayexer;/*
三角形
 */

import com.hasaki.dayexer.Test21Graphic;

public class Test21Triangle extends Test21Graphic {
    private double b1;    //三条边
    private double b2;
    private double b3;

    public Test21Triangle() {
    }

    public Test21Triangle(double b1, double b2, double b3) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    public double getB1() {
        return b1;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public double getB2() {
        return b2;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public double getB3() {
        return b3;
    }

    public void setB3(double b3) {
        this.b3 = b3;
    }

    @Override
    public double getArea() {
        if (b1 > 0 && b2 > 0 && b3 > 0) {
            if (b1 + b2 > b3 && b2 + b3 > b1 && b3 + b1 > b2)     //任意两边大于第三边
            //海伦公式
            {
                double p = (b1 + b2 + b3) / 2;
                double s = Math.sqrt(p * (p - b1) * (p - b2) * (p - b3));
                return s;
            }
        }
        return 0;
    }
}
