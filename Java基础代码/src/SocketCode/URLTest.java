package SocketCode;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 网络编程
 * 1.URL：统一资源定位符，对应着互联网上的某一资源地址
 * 2.格式：
 *      https://blog.csdn.net/qq_45456859/article/details/109383584
 *     协议  主机名（域名） （端口号） 资源地址       （参数列表）
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/4 14:58
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d50735fae6cd7b89d4db9a290a2442a7d8330ee0.jpg");

            //public String getProtocol()：获取该URL的协议名
            System.out.println(url.getProtocol());
            //public String getHost()：获取该URL的主机名
            System.out.println(url.getHost());
            //public String getProt()：获取该URL的端口号
            System.out.println(url.getPort());
            //public String getPath()：获取该URL的文件路径
            System.out.println(url.getPath());
            //public String getFile()：获取该URL的文件名
            System.out.println(url.getFile());
            //public String getQuery()：获取该URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
