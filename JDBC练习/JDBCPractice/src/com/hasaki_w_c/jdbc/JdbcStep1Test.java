package com.hasaki_w_c.jdbc;

/**
 * 此类用于演示JDBC的使用步骤1：加载驱动
 *
 * 类的加载时机：
 *  1.new对象
 *  2.加载子类
 *  3.调用类中的静态成员
 *  4.通过反射
 *
 * 使用new对象的方式加载类的不足：
 *  1.属于编译期加载，如果编译期间该类不存在，则直接编译错误，也就是依赖性太强
 *  2.导致Driver对象创建了两遍，效率太低
 *
 * 推荐用反射的方式加载类
 *  1.属于运行期加载，大大降低了类的依赖性
 *  2.Driver对象仅仅创建了一遍，效率较高
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/11 22:08
 */
public class JdbcStep1Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //老方式，不推荐，推荐用反射
        //DriverManager.deregisterDriver(new Driver());

        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
