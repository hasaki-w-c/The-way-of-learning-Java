package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/5 15:53
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<Person> clazz = Person.class;

        //clazz.newInstance();    //这里的newInstance()已过时,用如下方法进行替换
        //newInstance()：调用此方法，创建运行时类的对象。内部调用了运行时类的空参的构造器
        //              要想此方法正常的创建运行时类的对象，要求：
        //              1.运行时类必须提供空参的构造器
        //              2.要求空参的构造器访问权限得够。通常设置为public

        //在javabean中要求提供一个public的空参构造器。原因：
        //1.便于通过反射创建运行时类的对象
        //2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

        Person person = clazz.getDeclaredConstructor().newInstance();

        System.out.println(person);

    }

    /**
     * 通过代码体会反射的动态性
     */
    @Test
    public void test2() {

        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            //0,1,2

            String classPath = "";
            switch (num) {
                case  0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "reflection.Person";
                    break;
                default:
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 创建一个指定类的对象。
     * @param classPath 指定类的全类名
     * @return 运行时类的对象
     * @throws Exception 可能会有异常出现
     */
    public Object getInstance(String classPath) throws Exception {
        Class aClass = Class.forName(classPath);
        return aClass.getDeclaredConstructor().newInstance();
    }

}
