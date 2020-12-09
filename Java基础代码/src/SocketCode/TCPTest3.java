package SocketCode;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地，并返回“发送成功”给客户端。并关闭相应连接。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/4 13:58
 */
public class TCPTest3 {
    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;
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

            //关闭数据的输出
            socket.shutdownOutput();

            //5.接受来自于服务器端的数据并显示到控制台上
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer0 = new byte[20];
            int len0;
            while ((len0 = is.read(buffer0)) != -1) {
                baos.write(buffer0, 0, len0);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
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
        }


    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;

        OutputStream os = null;
        try {
            //1.
            ss = new ServerSocket(1010);

            //2.
            socket = ss.accept();

            //3.
            is = socket.getInputStream();

            //4.
            bos = new BufferedOutputStream(new FileOutputStream("TCP试验2.jpg"));

            //5.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            System.out.println("图片传输完成");

            //6.服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("文件已收到！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            //7.
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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
