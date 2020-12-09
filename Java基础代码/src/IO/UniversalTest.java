package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 通用的指定路径下文件的复制
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/10/31 16:52
 */
public class UniversalTest {
    public void copyFile(String inPath, String outPath) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //1.创建File类的对象
            File fileIn = new File(inPath);
            File fileOut = new File(outPath);

            //2创建流的对象
            fi = new FileInputStream(fileIn);
            fo = new FileOutputStream(fileOut);

            //3.文件的读入和写出操作
            byte[] cubf = new byte[1024];
            //记录每次读入的字节的个数
            int len;
            while ((len = fi.read(cubf)) != -1) {
                fo.write(cubf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fi != null || fo != null){
                //4.关闭流资源
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test() {
        long start = System.currentTimeMillis();

        String intPath = "G:\\Java基础代码\\src\\IO\\试验图片.jpg";
        String outPath = "G:\\Java基础代码\\test1.jpg";
        copyFile(intPath, outPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start) + "ms");
        //20ms
    }
}
