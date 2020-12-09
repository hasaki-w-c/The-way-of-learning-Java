package SocketCode;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/3 19:31
 */
public class TCPTest1 {

    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1.创建Socket的对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            //2.获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();

            //3.写出数据操作
            outputStream.write("暗号：死亡如风，常伴吾身！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (outputStream != null) {
                try {
                    outputStream.close();
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

    /**
     * 服务端
     */
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号（默认有了）
            ss = new ServerSocket(8899);

            //2.调用accept()表示接受来自客户端的socket
            socket = ss.accept();

            //3.获取一个输入流
            is = socket.getInputStream();

            //不建议这样写，上边的数据是汉字的话，底下数组太小了就可能会有个别乱码。
            //byte[] buffer = new byte[20];
            //int len;
            //while ((len = is.read(buffer)) != -1) {
            //    String s = new String(buffer, 0, len);
            //    System.out.println(s);
            //}

            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());

            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            if (baos != null) {
                try {
                    baos.close();
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
