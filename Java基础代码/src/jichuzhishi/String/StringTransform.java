package jichuzhishi.String;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
涉及到String类与其他结构之间的转换
 * @author hasaki
 */
public class StringTransform {
    /**
    String 与基本数据类型、包装类之间的转换。
    Sering --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 --> String :调用String重载的valueOf(xxx) 或者用 +"" 也可以
     */
    @Test
    public void test1() {
        String str1 = "123";
        //int num = (int)str1;    //错误的
        int num = Integer.parseInt(str1);
        System.out.println(num);
        //123

        String s = String.valueOf(num);
        //"123"
        System.out.println(s);
        String s1 = num + "";
        //"123"
        // 这样写在堆里,因为有变量参与

        System.out.println(s1);
        System.out.println(str1 == s1);
        //false
    }

    @Test
    /**
    String 与 char[]之间的转换
    String --> char[] : 调用String的toCharArray()
    char[] --> String : 调用String的构造器
     */
    public void test2() {
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();

        System.out.println(Arrays.toString(charArray));

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o' };
        String s = new String(arr);
        System.out.println(s);
    }

    @Test
    /**
    String 与 byte[]之间的转换
    编码 ： String --> byte[] : 调用String的getBytes()
    解码 ： byte --> String : 调用String的构造器
    说明：解码时，要求解码使用的字符集必须与编码时使用的字符集保持一致，否则出现乱码。
     */
    public void test3() throws UnsupportedEncodingException {
        String str = "abc123王琛";
        byte[] bytes = str.getBytes();
        //使用默认的字符集进行转换，UTF-8中一个汉字是三位

        System.out.println(Arrays.toString(bytes));
        //[97, 98, 99, 49, 50, 51, -25, -114, -117, -25, -112, -101]

        //编码： 字符串--> 字节
        //解码： 编码的逆过程，字节-->字符串
        byte[] gbks = str.getBytes("gbk");
        //使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));
        //[97, 98, 99, 49, 50, 51, -51, -11, -24, -95]

        String s = new String(bytes);
        //使用默认的字符集进行转换,进行解码
        System.out.println(s);
        //使用默认的字符集进行转换

        String s1 = new String(gbks);
        System.out.println(s1);
        //出现乱码，原因：编码集与解码集不一致

        String s2 = new String(gbks, "gbk");
        System.out.println(s2);
        //abc123王琛
    }
}
