package jichuzhishi;
/*
abstract：抽象的
abstract也是修饰符，可以修饰类（包括内部类和外部类）、方法

1.为什么要使用抽象类和抽象方法
  当我们设计父类时，发现某些方法是无法给出具体的实现，具体的实现应该在子类中实现它。
  那么这样的方法，在父类中就可以设计为“抽象方法”
  包含抽象方法的类必须是一个“抽象类”

2.抽象类，抽象方法的语法格式
  【权限修饰符】 abstract class 类名{
          【权限修饰符】 abstract 返回值类型 方法名(【形参列表】);
  }

3.抽象类的特点
  ①抽象类不能直接new对象
  ②抽象类就是用来被继承的，那么子类继承抽象类后，必须实现抽象类的抽象方法
  ③抽象类的变量可以与子类的对象构成多态引用，执行子类重写的方法
  ④抽象类可以和普通类一样拥有属性，构造器，代码块，非抽象方法等成员。这些可以给子类使用。
  ⑤一个类如果有抽象方法，这个类必须是抽象类，但是一个抽象类也可以没有抽象方法，目的就是不让创建其对象。

4.权限修饰符
  public,protected,缺省,private
  ①private和abstract不能同时修饰方法，因为private的方法在子类中不可见，无法重写。
  ②private和abstract可以同时修饰成员内部类

 */
public class AbstractTest {
    public static void main(String[] args) {
        //Graphic g = new Graphic();    //不能创建抽象类的对象
        Graphic g = new Circle(2);
        double area = g.getArea();
        System.out.println("面积：" + area);
    }
}
abstract class Graphic {
    private String name;

    public Graphic() {
    }

    public Graphic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //在父类中，是无法给出统一实现的。
    public abstract double getArea();

    public abstract double getPrimeter();
}

class Circle extends Graphic {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius *radius;
    }

    @Override
    public double getPrimeter() {
        return 2 * Math.PI * radius;
    }
}
