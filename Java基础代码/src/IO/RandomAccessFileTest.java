package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile 直接继承与java.lang.Object类，实现了DataInput和DataOutput两个接口
 * 2.RandomAccessFile 既可以作为一个输入流，又可以作为输出流
 * 3.如果RandomAccessFile作为一个输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下从头覆盖）
 * 4.可以通过相关操作，实现RandomAccessFile“插入”数据的效果
 *
 *  构造器
 *      public RandomAccessFile(File file, String mode)
 *      public RandomAccessFile(String name, String mode)
 *
 *  创建RandomAccessFile类实例需要指定一个mode参数，该参数指定RandomAccessFile的访问模式：
 *  >r：以只读方式打开
 *  >rw：打开以便读取和输入
 *  >rwd：打开以便读取和输入；同步文件内容的更新
 *  >rws：打开以便读取和输入：同步文件内容和元数据的更新
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/2 17:17
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {

        RandomAccessFile rafIn = null;
        RandomAccessFile rafOut = null;
        try {
            //1.造流的对象
            rafIn = new RandomAccessFile(new File("G:\\Java基础代码\\src\\IO\\试验图片.jpg"),"r");
            rafOut = new RandomAccessFile(new File("G:\\Java基础代码\\试验图片1.jpg"),"rw");

            //2.读写过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = rafIn.read(buffer)) != -1) {
                rafOut.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (rafOut != null) {
                try {
                    rafOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (rafIn != null) {
                try {
                    rafIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2() {

        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("G:\\Java基础代码\\src\\IO\\hasaki.txt","rw");
            //将指针调到角标为3的位置
            raf1.seek(3);
            raf1.write("hasaki".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用RandomAccessFile实现数据的插入的效果
     */
    @Test
    public void test3() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("G:\\Java基础代码\\src\\IO\\hasaki.txt", "rw");
            raf1.seek(3);
            //保存指针3后边的所有数据到StringBuilder中
            StringBuilder sb = new StringBuilder((int) new File("G:\\Java基础代码\\src\\IO\\hasaki.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                sb.append(new String(buffer,0,len));
            }

            raf1.seek(3);
            raf1.write("xyz".getBytes());

            //将StringBuilder中的数据写入文件里
            raf1.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
