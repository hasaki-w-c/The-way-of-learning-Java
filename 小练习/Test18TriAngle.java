package com.hasaki.dayexer;

public class Test18TriAngle {
    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double area(){
        double s = (height * base) / 2;
        return s;
    }
}
