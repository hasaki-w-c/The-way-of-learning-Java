package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/10/31 16:49
 */
public class FileInputOutputStreamTest {
    /**
     * 对FileInputStream和FileOutStream的测试
     * 图片的复制操作
     */
    @Test
    public void testPicture(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //1.创建File类的对象
            File fileIn = new File("G:\\Java基础代码\\src\\IO\\试验图片.jpg");
            File fileOut = new File("G:\\Java基础代码\\test.jpg");

            //2创建流的对象
            fi = new FileInputStream(fileIn);
            fo = new FileOutputStream(fileOut);

            //3.文件的读入和写出操作
            byte[] cubf = new byte[5];
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
}
