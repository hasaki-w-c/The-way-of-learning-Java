package com.hasaki.dayexer;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 自定义类实现对象流序列化与反序列化
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/2 16:02
 */
public class Test44 {
    @Test
    public void objectOutputStreamTest() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("G:\\LittlePractice\\src\\object.dat"));

            oos.writeObject(new String("爱飞飞"));
            oos.flush();

            oos.writeObject(new Person("灰灰",18));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void objectInputStreamTest() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("G:\\LittlePractice\\src\\object.dat"));

            Object o = ois.readObject();
            String s = (String) o;

            Person p = (Person) ois.readObject();

            System.out.println(s);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

/**
 * Person类需要满足如下的要求方可序列化
 * 1.需要实现接口:Serializable(是一个标识接口)
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还需要保证其内部所有属性也必须时可序列化的。
 *      默认情况下，基本数据类型可序列化。
 */
class Person implements Serializable{

    //后边的值随便写一个long类型的序列版本号
    public static final long serialVersionUID = 46_845_315_165_461L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test44Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
