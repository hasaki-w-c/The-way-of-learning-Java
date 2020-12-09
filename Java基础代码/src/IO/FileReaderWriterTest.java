package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类             节点流(或文件流)                                缓冲流（处理流的一种）
 * InputStream         FileInputStream (read(byte[] buffer))         BufferedInputStream (read(byte[] buffer))
 * OutputStream        FileOutStream (write(byte[] buffer,0,len))    BufferedOutputStream (write(byte[] buffer,0,len)) / flush()
 * Reader              FileReader (read(char[] cubf))                BufferedReader (read(char[] cubf))
 * Writer              FileWriter (write(char[] cubf,0,len))         BufferedWriter (write(char[] cubf,0,len)) / flush()
 *
 *结论：
 * 1.对于文本文件（.txt,.java,.c,.cpp。。。），使用字符流处理Reader，Writer(在内存层面要看的话)
 *                                          要不在内存层面看的话，用字节流复制一份也是可以的。
 *2.对于非文本文件（.jpg,.mp3,.mp4,.avi,.doc,.ppt。。。），使用字节流处理InputStream，outputStream
 *
 * 开发中一般不用节点流，一般用缓冲流提高效率
 *
 * @author hasaki
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hasaki.txt");
        //相较于当前工程
        System.out.println(file.getAbsolutePath());
    }

    /**
     * 将IO module下的hasaki.txt文件内容读入程序中，并输出到控制台
     * <p>
     * 说明点：
     * 1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
     * 2.异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
     * 3.读入的文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("G:\\Java基础代码\\src\\IO\\hasaki.txt");
            //相较于当前module

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭操作
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对read()操作升级：使用read的重载方法
     */
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("G:\\Java基础代码\\src\\IO\\hasaki.txt");

            //2.流的实例化
            fr = new FileReader(file);

            //3.读入具体操作
            //read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1.
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //错误的写法
                //for (int i = 0; i < cbuf.length; i++) {
                //    System.out.print(cbuf[i]);
                //}

                //正确的写法
                //方式一：
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }

                //方式二：
                //String s = new String(cbuf,0,len);
                //System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘的文件里。
     *
     * 说明：
     * 1.输出操作对应的File可以不存在的，并不会报异常。
     * 2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建
     *      如果存在：
     *          如果流使用的构造器是：FileWrite(file, false) / FileWrite(file)：对原有文件的覆盖
     *          如果流使用的构造器是：FileWrite(file, true)：不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);

            //3.写出的具体操作
            fw.write("死亡如风，常伴吾身");
            fw.write("\n面对疾风吧！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     *文件的复制操作
     * 硬盘读入到内存，再从内存写出到硬盘
     */
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1.创建File类的对象，指明读入和写出的文件
            File fileIn = new File("hello.txt");
            File fileOut= new File("G:\\Java基础代码\\src\\IO\\hasaki.txt");

            //2.创建流的对象

            fr = new FileReader(fileIn);
            fw = new FileWriter(fileOut);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;    //记录每次读入到cbuf数组中字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null || fw != null){
                //4.关闭流资源
                try {
                    fw.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}

