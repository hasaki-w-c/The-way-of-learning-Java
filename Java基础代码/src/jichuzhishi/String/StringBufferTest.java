package jichuzhishi.String;

import org.junit.jupiter.api.Test;

/*
字符系列：String，StringBuffer，StringBuilder
String类型的对象不可变字符序列。所以又配备了另一个类StringBuffer，他是可变的字符序列。

StringBuffer创建对象必须用new
stringBuffer的拼接不能直接用+，要用append

常用方法：
  1.append系列：用于追加xx
  2.insert系列：插入xx
  3.delete系列：删除xx
  4.reverse系列：

StringBuffer又称为字符串缓冲区，内部用char数组存储的
  数组的长度不可变。
  1.char[]的初始化长度是多少？
    StringBuffer():默认的初始长度是16
    StringBuffer(String str):默认长度是str.length + 16.
    StringBuffer(int capacity):默认长度由capacity指定
  2.char[]如果存满了，怎么办？
    先把value的数组扩大到value.length*2+2,如果还不够，就按实际需要的来。

StringBuilder:JDK1.5增加
    StringBuilder与StringBuffer的API完全兼容，但是StringBuilder不保证同步。
    换句话说：stringBuffer是线程安全的，StringBuilder是线程不安全的。
    即当多线程来共同使用同一个StringBuffer的对象时，是安全的。
    即当多线程来共同使用同一个StringBuilder的对象时，是不安全的。
    此类设计用作简易替换为StringBuffer在正在使用由单个线程字符串缓冲区的地方（如通常是这种情况）。
    在可能的情况下，建议使用这个类别优先于StringBuffer ，因为它在大多数实现中将更快。

 */
public class StringBufferTest {
    @Test
    public void test5() {
        StringBuffer sb = new StringBuffer("Hello");
        sb.reverse();
        System.out.println(sb);
    }
    @Test
    public void test4() {
        StringBuffer sb = new StringBuffer("Heallo");
        sb.delete(2,3);
        System.out.println(sb);
    }
    @Test
    public void test3() {
        StringBuffer sb = new StringBuffer("Hllo");
        sb.insert(1,"e");
        System.out.println(sb);
    }
    @Test
    public void test2() {
        StringBuffer sb = new StringBuffer();
        sb.append(1).append(2).append(3);
        System.out.println(sb);
    }
    @Test
    public void test() {
        String s = "Hello";
        StringBuffer sb = new StringBuffer("Hello");
        change(s, sb);
        System.out.println(s);
        System.out.println(sb);
    }
    public void change(String s,StringBuffer sb) {
        s += " world";
        sb.append(" world");
    }
}
