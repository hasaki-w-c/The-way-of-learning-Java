package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流（看后缀辨别）
 *      InputStreamReader:将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter:将字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.字符集：
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/1 18:38
 */
public class InputStreamReaderTest {
    @Test
    public void test1() {

        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("G:\\Java基础代码\\src\\IO\\hasaki.txt");
            //无参构造，使用系统默认的字符集，参数二指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            isr = new InputStreamReader(fis, "UTF-8");

            char[] cbuf = new char[10];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.造文件，造流
            File file1 = new File("G:\\Java基础代码\\src\\IO\\hasaki.txt");
            File file2 = new File("G:\\Java基础代码\\src\\IO\\hasaki_GBK.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos,"GBK");

            //2.读写过程
            char[] cubf = new char[10];
            int len;
            while ((len = isr.read(cubf)) != -1) {
                osw.write(cubf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
