package SocketCode;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2.客户端发送文件给服务端，服务端将文件保存到本地。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/3 20:27
 */
public class TCPTest2 {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            //1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 1010);

            //2.
            os = socket.getOutputStream();

            //3.
            bis = new BufferedInputStream(new FileInputStream("G:\\Java基础代码\\src\\SocketCode\\试验图片.jpg"));

            //4.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //5.
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;

        try {
            //1.
            ss = new ServerSocket(1010);

            //2.
            socket = ss.accept();

            //3.
            is = socket.getInputStream();

            //4.
            bos = new BufferedOutputStream(new FileOutputStream("TCP试验1.jpg"));

            //5.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
