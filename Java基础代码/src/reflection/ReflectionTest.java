package reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 疑问：通过直接new对象的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
 *      建议：直接用new的方式。
 * 什么时候用反射的方式：反射的特征：动态性
 *
 * 疑问：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
 *      不矛盾。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/4 16:02
 */
public class ReflectionTest {

    /**
     *反射之前对于Person类的操作
     */
    @Test
    public void test1() {
        //1.创建Person类的对象（Person类的实例化）
        Person p1 = new Person("Tom",12);

        //2.通过对象，调用其内部属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类的外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }

    /**
     * 反射之后，对于Person的操作
     */
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;

        //通过反射，创建Person类的对象
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person p1 = cons.newInstance("Tom",12);
        System.out.println(p1.toString());
        //Person{name='Tom', age=12}

        //2.通过反射，调用对象指定的属性和方法
        //调属性
        Field age = clazz.getDeclaredField("age");
        age.set(p1,10);
        System.out.println(p1.toString());
        //Person{name='Tom', age=10}

        //调方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p1);
        //你好，我是一个人

        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2 = cons1.newInstance("Jerry");
        System.out.println(p2.toString());
        //Person{name='Jerry', age=0}

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"张三");
        System.out.println(p2);
        //Person{name='张三', age=0}

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        String  nation = (String) showNation.invoke(p2, "中国");
        //相当于p1.showNation("中国");
        //我的国籍是：中国
        System.out.println(nation);
        //中国
    }

    /**
     * 关于java.lang.Class类的理解
     *
     * 1.类的加载过程：
     *      程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾）。（编译）
     *      接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称为类的加载
     *      加载到内存中的类，我们就称之为运行时类，此运行时类，就作为Class的一个实例。
     *
     * 2.换句话来说，Class的实例就对应着一个运行时类。
     *
     * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，我们可以通过不同的方式来获取此运行时类。
     *
     * 万事万物皆对象！
     */


    /**
     * 获取Class实例的方式（前三种方式需要掌握）
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> aClass = Person.class;
        System.out.println(aClass);
        //class reflection.Person

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> aClass1 = p1.getClass();
        System.out.println(aClass1);
        //class reflection.Person

        //方式三：调用Class的静态方法：forName(String classPath)  （用的最多）
        Class<?> aClass2 = Class.forName("reflection.Person");
        System.out.println(aClass2);
        //class reflection.Person

        //方式四：使用类的加载器：ClassLoader （了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass3 = classLoader.loadClass("reflection.Person");
        System.out.println(aClass3);
        //class reflection.Person
    }

    /**
     * Class实例可以是哪些结构的说明：
     */
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String.class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> aClass = a.getClass();
        Class<? extends int[]> bClass = b.getClass();
        //只要元素类型和维度一样，就是同一个class
        System.out.println(aClass == bClass);
        //true
    }
}
