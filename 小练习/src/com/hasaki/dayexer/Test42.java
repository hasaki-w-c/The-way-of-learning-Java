package com.hasaki.dayexer;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 图片的加密与解密
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/1 15:31
 */
public class Test42 {
    /**
     * 加密操作
     */
    @Test
    public void addTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //FileInputStream()括号里可以直接写文件的路径，会自动装箱成文件减
            fis = new FileInputStream("G:\\Java基础代码\\src\\IO\\试验图片.jpg");
            fos = new FileOutputStream("G:\\LittlePractice\\src\\picTest.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //字节数组进行修改

                //错误的方式：buffer数组中的值没有变化
                //for (byte b : buffer) {
                //    b = (byte) (b ^ 5);
                //}

                //正确的写法：
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 解密操作
     */
    @Test
    public void subtractTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //FileInputStream()括号里可以直接写文件的路径，会自动装箱成文件减
            fis = new FileInputStream("G:\\LittlePractice\\src\\picTest.jpg");
            fos = new FileOutputStream("G:\\LittlePractice\\src\\testPic.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //字节数组进行修改

                //错误的方式：buffer数组中的值没有变化
                //for (byte b : buffer) {
                //    b = (byte) (b ^ 5);
                //}

                //正确的写法：
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
