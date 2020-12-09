package SocketCode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议的网络编程
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/4 14:39
 */
public class UDPTest {

    /**
     * 发送端
     */
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String s = "我是UDP方式发送的导弹";
        byte[] data = s.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,0,data.length, inet, 9090);

        socket.send(packet);;

        socket.close();
    }

    /**
     * 接收端
     */
    @Test public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();
    }
}
