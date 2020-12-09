package reflection.knowledge2;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/6 13:08
 */
public class OtherTest {
    /**
     * 获取构造器
     */

    @Test
    public void test1() {
        Class clazz = Person.class;

        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
            //public reflection.knowledge2.Person()
        }
        System.out.println();

        //getDeclaredConstructors()：获取当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
            //reflection.knowledge2.Person(java.lang.String,int)
            //private reflection.knowledge2.Person(java.lang.String)
            //public reflection.knowledge2.Person()
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //class reflection.knowledge2.Creatuer
    }

    /**
     * 获取带泛型的运行时类的父类
     */
    @Test
    public void test3() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        //reflection.knowledge2.Creatuer<java.lang.String>
    }

    /**
     * 获取带泛型的运行时类的父类的泛型
     */
    @Test
    public void test4() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(((Class)actualTypeArguments[0]).getName());
        //java.lang.String
    }

    /**
     * 获取运行时类的接口  （动态代理可能会用到）
     */
    @Test
    public void test5() {
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
            ///interface java.lang.Comparable
            //interface reflection.knowledge2.MyInterface
        }

        System.out.println();

        //获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
            //interface java.io.Serializable
        }
    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test6() {
        Class clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
        //package reflection.knowledge2
    }

    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void test7() {
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
            //@reflection.knowledge2.MyAnnotation("hi")
        }
    }
}
