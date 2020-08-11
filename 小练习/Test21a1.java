/*
多态的应用

需求：
1.超类：图形Test21Graph里边有一个getArea()
2.子类：圆
3.子类：矩形
4.要用一个数组，来装各种图形的对象，并且遍历这些图形，打印它们的面积
 */

public class Test21a1 {
    public static void main(String[] args) {
        //Circle[] arr1 = new Circle[3];    //只能装圆的对象
        //Rectangle[] arr2 = new Rectangle[3];    //只能装矩形的对象

        Test21Graphic[] arr3 = new Test21Graphic[3];    //创建数组对象
        arr3[0] = new Test21Circle(1.2);    //左边的arr3[0]的类型是Test21Graphic,右边赋值的是Circle的对象，这就是一个多态引用。
        arr3[1] = new Test21Circle(3.0);
        arr3[2] = new Test21Rectangle(3,4);

        for (int i = 0; i < arr3.length; i ++) {
            System.out.println(arr3[i].getArea());
        }
    }
}
