/*
方法的参数传递机制：
如果形参是基本数据类型，则将基本数据变量储存的数据传递给形参
如果形参是引用数据类型，则将引用数据类型变量的地址值赋值给形参。
 */

public class Test14 {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println("m = " + data.m + ",n = " + data.n);

        Test14 jh = new Test14();
        jh.swap(data);

        System.out.println("m = " + data.m + ",n = " + data.n);
    }

    public void swap(Data data){
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data{
    int m = 10;
    int n = 20;
}