package SocketCode;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一.网络编程中有两个主要的问题
 * 1.如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2.找到主机后如何可高校地进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 * 三、通讯要素一：IP和端口号
 * 1.IP：唯一的标识Internet上的计算机（通信实体）
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类：IPv4和IPv6；万维网和局域网
 * 4.域名： www.baidu.com   www.mi.com ...
 * 5.本地回路地址：127.0.0.1 对应着localhost
 * 6.如何实例化InetAddress：两个方法：getByName(String host) 、 getLocalHost()
 * 7.端口号：标识正在计算机上运行的进程
 *      要求：不同的进程有不同的端口号
 *      范围：被规定为一个16位的整数0~65535
 *
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/2 19:45
 */
public class InterAddressTest {
    public static void main(String[] args) {

        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.10");
            System.out.println(inet1);
            ///192.168.10.10

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            //www.baidu.com/61.135.185.32

            //获取本地IP
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            //hasaki/192.168.137.1

            //getHostName()
            System.out.println(inet2.getHostName());
            //www.baidu.com

            //getHostAddress()
            System.out.println(inet2.getHostAddress());
            //61.135.185.32
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
