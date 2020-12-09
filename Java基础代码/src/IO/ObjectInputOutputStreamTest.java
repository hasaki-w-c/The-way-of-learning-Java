package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用；用于存储和读取基本数据类型数据或对象的处理流。
 *        它的强大之处就是可以把Java中的对象还原回来
 * 3.序列化与反序列化
 *
 * 4.要想一个Java对象时可序列化的需要满足相应的要求。见littlePractice的Test44.java
 *          自定义类需要实现接口:Serializable(是一个标识接口)
 *          还需要给一个属性 static final long serialVersionUID = 42L;（后边的序列号随便写一个long类型的）
 *          serialVersionUID用来表明类的不同版本间的兼容性，简言之就是，以序列化对象进行版本控制，
 *          有关各版本反序列化时是否兼容，建议显示声明。有默认声明，但是如果序列化以后类发生变化，
 *          那么反序列化的时候，就会报异常。
 *
 *  补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/2 15:37
 */
public class ObjectInputOutputStreamTest {
    /**
     * 序列化过程：
     * 将内存中的Java对象保存在磁盘中或者通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void objectOutputStreamTest() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("G:\\Java基础代码\\object.dat"));

            oos.writeObject(new String("爱飞飞"));

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


    /**
     * 反序列化过程：
     * 将磁盘中的对象还原为内存中的Java对象
     * 使用ObjectInputStream来实现
     */
    @Test
    public void objectInputStreamTest() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("G:\\Java基础代码\\object.dat"));

            Object o = ois.readObject();
            String s = (String) o;
            System.out.println(s);
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
