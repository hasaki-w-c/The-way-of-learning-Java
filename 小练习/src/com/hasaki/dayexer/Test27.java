package com.hasaki.dayexer;

/*
获取一个字符串在另一个字符串中出现的次数。
比如：获取"ab"在"abababkkcadkabkebabskksaba"中出现的次数
 */
/*indexOf的用法
public class Main {
    public static void main(String args[]) {
        String string = "aaa456ac";
        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        System.out.println(string.indexOf("b")); // indexOf(String str); 返回结果：-1，"b"不存在

        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(string.indexOf("a",3));//indexOf(String str, int fromIndex); 返回结果：6

        //（与之前的差别：上面的参数是 String 类型，下面的参数是 int 类型）参考数据：a-97,b-98,c-99

        // 从头开始查找是否存在指定的字符
        System.out.println(string.indexOf(99));//indexOf(int ch)；返回结果：7
        System.out.println(string.indexOf('c'));//indexOf(int ch)；返回结果：7

        //从fromIndex查找ch，这个是字符型变量，不是字符串。字符a对应的数字就是97。
        System.out.println(string.indexOf(97,3));//indexOf(int ch, int fromIndex); 返回结果：6
        System.out.println(string.indexOf('a',3));//indexOf(int ch, int fromIndex); 返回结果：6
    }
}
 */
public class Test27 {
    public static void main(String[] args) {
        String src = "abababkkcadkabkebabskksaba";
        String sub = "ab";
        System.out.println(count1(src, sub));
        System.out.println(count2(src, sub));
    }

    /*
    方法一
    查找+截取
     */
    public static int count1(String str, String sub) {
        int count = 0;
        while (str.indexOf(sub) != -1) {
            int index = str.indexOf(sub);
            str = str.substring(index + sub.length());
            count++;
        }
        return count;
    }

    /*
    方法二
    替换
     */
    public static int count2(String str, String sub) {
        int count = 0;
        while (str.contains(sub)) {
            str = str.replaceFirst(sub, "");
            count ++;
        }
        return count;
    }
}