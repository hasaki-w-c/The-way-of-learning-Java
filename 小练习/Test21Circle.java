/*
圆形
 */

public class Test21Circle extends Test21Graphic{
    private double radius;

    public Test21Circle() {
    }

    public Test21Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
