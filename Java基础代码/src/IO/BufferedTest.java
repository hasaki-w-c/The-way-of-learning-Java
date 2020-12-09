package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之一，缓冲流的使用
 * <p>
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 作用：提供流的读取、写入的速度
 * 提高读写速度的的原因：内部提供了一个缓冲区
 * <p>
 * 处理流，就是”套接“在已有的流的基础上。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/1 13:38
 */
public class BufferedTest {

    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1 造文件
            File inFile = new File("G:\\Java基础代码\\src\\IO\\试验图片.jpg");
            File outFile = new File("G:\\Java基础代码\\test2.jpg");

            //2 造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3 复制的细节：读取和写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4 资源关闭
            //要求：先关闭外层的流，再关闭内层的
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动进行关闭，对于内层流的关闭，可以省略
            //fos.close();
            //fis.close();
        }
    }

    /**
     * 缓冲流实现文件复制的方法
     */
    public void copyFileWithBuffered(String inPath, String outPath) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1 造文件
            File inFile = new File(inPath);
            File outFile = new File(outPath);

            //2 造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3 复制的细节：读取和写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4 资源关闭
            //要求：先关闭外层的流，再关闭内层的
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动进行关闭，对于内层流的关闭，可以省略
            //fos.close();
            //fis.close();
        }
    }

    /**
     *
     */
    @Test
    public void testFileCopyWithBuffered() {
        long start = System.currentTimeMillis();

        String intPath = "G:\\Java基础代码\\src\\IO\\试验图片.jpg";
        String outPath = "G:\\Java基础代码\\test3.jpg";
        copyFileWithBuffered(intPath, outPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start) + "ms");
        //5ms
    }
}
