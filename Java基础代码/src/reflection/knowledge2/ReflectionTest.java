package reflection.knowledge2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性，方法、构造器
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/6 13:37
 */
public class ReflectionTest {



    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p= (Person) clazz.getDeclaredConstructor().newInstance();

        //获取指定的属性,此方法的方式需要运行时类中属性声明为public，通常不采用此方法。
        Field id = clazz.getField("id");

        /*
        设置当前属性的值

        set()：参数1：指明设置哪个对象的属性       参数2：将此属性设置为多少
         */

        id.set(p, 1001);

        /*
        获取当前属性的值
        get()：参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
        //1001
    }

    /**
     *如何操作运行时类指定的属性  --需要掌握
     */
    @Test

    public void testField1() throws Exception {
        Class clazz = Person.class;

        //1.创建运行时类的对象
        Person p= (Person) clazz.getDeclaredConstructor().newInstance();

        //2.getDeclaredField(String fieldName)：获取运行时类中指定变量名的属性
        //此方法比较常用
        Field name = clazz.getDeclaredField("name");

        //3.保证属性可访，私有变量只能先写这句才能改
        name.setAccessible(true);

        //4.修改、获取指定对象的此属性值
        name.set(p,"Tom");
        //Tom

        System.out.println(name.get(p));
    }

    /**
     * 如何操作运行时类中指定的方法 --需要掌握
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;

        //获取运行时类的对象
        Person p= (Person) clazz.getDeclaredConstructor().newInstance();

        //1.获取指定的某个方法
        //getDeclaredMethod()：参数1：指明获取方法的名称  参数2：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证方法可访问
        show.setAccessible(true);

        //3.调用方法invoke()：参数1：方法的调用者  参数2：给方法形参复制的实参
        //invoke()的返回值即为对应类中调用方法的返回值。
        show.invoke(p, "China");
        //我的国籍是：China

        System.out.println("*****如何调用静态方法******");

        //public static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        //如果调用的运行时类中的方法没有返回值则此invoke()返回null
        Object invoke = showDesc.invoke(Person.class);

        System.out.println(invoke);
        //我是一个可爱的人
        //null
    }

    /**
     * 如何调用运行时类中指定的构造器
     */
    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;
        //获取运行时类的对象
        Person p= (Person) clazz.getDeclaredConstructor().newInstance();

        //private Person(String name)
        //1.获取指定的构造器
        //getDeclaredConstructor()：参数：指明构造器的参数列表
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person person = (Person) declaredConstructor.newInstance("Tom");
        System.out.println(person);
        //Person{name='Tom', age=0, id=0}
    }
}
