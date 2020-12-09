package jichuzhishi.String;

import org.junit.jupiter.api.Test;

/**
int length():返回字符串长度
char charAt(int index):返回某索引处的字符
boolean isEmpty():判断是否为空字符串
String toLowerCase():使用默认语言环境，将String中的所有字符转换为小写
String toUpperCase():使用默认语言环境，将String中的所有字符转换为大写
String trim():返回字符串的副本，忽略前导空白和尾部空白
boolean equals(Object obj):比较字符串的内容是否相同
boolean equalsIgnoreCase(String anotherString):与equals方法类似，忽略大小写
String concat(String str):将指定字符串连接到此字符串的结尾。等价于用"+"
int compareTo(String anotherString):比较两个字符串的大小
String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串
String substring(int beginIndex, int endIndex):返回一个字符串，它是此字符串从beginIndex开始截取到endIndex（不包含）的子字符串。
boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
boolean startsWith(String prefix):测试此字符串是否以指定的前缀开始
boolean startsWith(String prefix, int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始
boolean contains(charSequence s):当且仅当此字符串包含指定的char值序列时，返回true
int indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引
int indexOf(String str, int fromIndex):返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引
int lastIndexOf(String str, int fromIndex):返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
注：indexOf和lastIndexOf方法如果未找到都是返回-1

替换：
String replace(char oldChar, char newChar):返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的
String replace(CharSequence target, CharSequence replacement):使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
String replace(String regex, String replacement):使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
String replaceFirst(String regex, String replacement):使用给定的replacement替换此字符串给定的正则表达式的第一个子字符串

匹配：
boolean matches(String regex):告知此字符串是否匹配给定的正则表达式。

切片：
String[] split(String regex):根据给定正则表达式的匹配拆分此字符串。
String[] split(String regex, int limit):根据给定正则表达式的匹配拆分此字符串,最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 * @author hasaki
 */
public class StringMethod {
    @Test
    public void Test () {
        String s1 = "  hello world  ";
        System.out.println(s1.length());
        //15
        System.out.println(s1.charAt(3));
        //e
        System.out.println(s1.isEmpty());
        //false
        System.out.println(s1.toUpperCase());
        //  HELLO WORLD  //这操作也并没有改变s1本身
        System.out.println(s1.trim());
        //hello world
        String s2 = "  HELLO WORLD  ";
        System.out.println(s1.equalsIgnoreCase(s2));
        //true
        String s3 = "!!!";
        System.out.println(s1.concat(s3));
        //  hello world  !!!
        System.out.println(s1.compareTo(s2));
        //32//码值相减得出结果//涉及到字符串排序
        System.out.println(s1.substring(2));
        //hello world
        System.out.println(s1.substring(2, 7));
        //hello//左闭右开
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);
        //true
        boolean b2 = str1.startsWith("He");
        System.out.println(b2);
        //false
        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);
        //true
        String str2 = "张小三";
        String r1 = str2.replace('小', '大');
        System.out.println(r1);
        //张大三
        String str3 = "李四";
        String r2 = str3.replace("李四", "王琛");
        System.out.println(r2);
        //王琛
        String str4 = "1我2是3王4琛5";
        // \\d是数字 +表示不止一个数字 ^,|,$表示开头和结尾
        String s = str4.replaceAll("\\d+", "!");
        System.out.println(s);
        //!我!是!王!琛!
        String str5 = "123546";
        boolean matches = str5.matches("\\d+");
        System.out.println(matches);
        //true
        String str6 = "hello|world|java";
        String[] strs = str6.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + " ");
            //hello world java
        }

    }
}
