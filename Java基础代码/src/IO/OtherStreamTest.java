package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入输出流
 * 2.打印流
 * 3.数据流
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/1 20:01
 */
public class OtherStreamTest {
    /**
     * 1.标准的输入输出流
     * 1.1
     * System.in:标准的输入流，默认从键盘输入
     * System.out:标准的输出流，默认从控制台输出
     * 1.2
     * System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。
     * 1.3练习：
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至输入"e"或者"exit"时，退出程序
     *
     * 方法一：使用Scanner实现，调用next（）返回一个字符串
     * 方法二：使用System.in实现。System.in --> 转换流 --> BufferedReader的readLine()
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束！");
                    break;
                }

                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     *2.打印流：printStream和printWriter
     *
     * 2.1 提供了一系列重载的print()和println()
     */
    @Test
    public void printTest() {

    }
    /**
     * 3.数据流
     * 3.1 DataInputStream和DataOutputStream
     * 3.2 作用：为了方便操作Java语言的基本数据类型和String的数据，可以使用数据流。
     * 3.3 练习”将内存中的字符串基本数据类型的变量写出到文件中
     */
    @Test
    public void test2() {
        DataOutputStream dos= null;
        try {
            dos = new DataOutputStream(new FileOutputStream("hello.txt"));

            dos.writeUTF("张三");
            //刷新操作，一旦执行。将内存中的数据写入文件
            dos.flush();
            dos.writeInt(250);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 将文件中存储的基本数据类型变量和字符串读取到内存中，保存到变量中。
     * 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致。
     */
    @Test
    public void test3() {
        DataInputStream dis = null;
        try {
            //1.
            dis = new DataInputStream(new FileInputStream("hello.txt"));
            //2.
            String s = dis.readUTF();
            int i = dis.readInt();
            boolean b = dis.readBoolean();

            System.out.println("name = " + s);
            System.out.println("age = " + i);
            System.out.println("isMale = " + b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                //3.
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
