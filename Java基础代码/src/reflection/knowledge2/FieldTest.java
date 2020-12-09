package reflection.knowledge2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前类运行时类的属性结构
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/5 21:18
 */
public class FieldTest {
    @Test
    public void test1() {

        Class clazz = Person.class;

        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
            //public int reflection.knowledge2.Person.id
            //public double reflection.knowledge2.Creatuer.weight
        }
        System.out.println();

        //getDeclaredFields()：获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
            //private java.lang.String reflection.knowledge2.Person.name
            //int reflection.knowledge2.Person.age
            //public int reflection.knowledge2.Person.id
        }
    }

    /**
     * 权限修饰符  数据类型  变量名
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //private
            //(默认的就不翻译了)
            //public

            //2.变量的数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");
            //java.lang.String
            //int
            //int

            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
            //name
            //age
            //id

            System.out.println();
        }
        }
}
