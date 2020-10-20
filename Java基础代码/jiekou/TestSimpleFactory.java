package jiekou;
/*
简单工厂类
作用：生产Java的对象，一般是用来生产某个接口的实现类对象。
好处：把对象的使用者与创建者分离，解耦合（把对象的使用者与具体的实现类解耦合）。
例如：TestSimpleFactory类是对象的使用者
     SimpleFactory类是对象的创建者
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        Car car = SimpleFactory.getCar("bmw");
        car.run();

        Car car1 = SimpleFactory.getCar("audi");
        car1.run();
    }
}
//产品的标准
interface Car{
    void run();
}

//具体的产品类
class BWM implements Car{

    @Override
    public void run() {
        System.out.println("宝马");
    }
}
class Benz implements Car{

    @Override
    public void run() {
        System.out.println("奔驰");
    }
}
class Audi implements Car{

    @Override
    public void run() {
        System.out.println("奥迪");
    }
}
//工厂类
class SimpleFactory{
    public static Car getCar(String type) {
        if ("bmw".equals(type)) {
            return new BWM();
        }else if ("Benz".equals(type)) {
            return new Benz();
        }else {
            return new Audi();
        }
    }
}