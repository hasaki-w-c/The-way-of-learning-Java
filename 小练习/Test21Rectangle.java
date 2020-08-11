/*
矩形
 */

public class Test21Rectangle extends Test21Graphic {
    private double length;
    private  double width;

    public Test21Rectangle() {
    }

    public Test21Rectangle(double length , double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
