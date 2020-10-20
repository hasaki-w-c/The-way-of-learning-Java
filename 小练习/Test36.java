package com.hasaki.dayexer;
/*
一道关于值传递和String的面试题

字符串作为参数传递是需要小心的，函数里修改完以后原字符串还是不会变的。
 */
public class Test36 {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change (String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        Test36 t = new Test36();
        t.change(t.str, t.ch);
        System.out.println(t.str);    //good
        System.out.println(t.ch);    //best
    }
}
