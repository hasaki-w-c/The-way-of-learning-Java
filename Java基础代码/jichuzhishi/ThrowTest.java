package jichuzhishi;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/*
异常对象：
  1.JVM自动抛出
  2.程序员手动抛出

  无论怎么抛出，最终都用try...catch处理或者通过throws抛给上级

throw关键字是用于主动抛出异常对象。

语法格式：
  语句：throw 异常对象；

  如果没有try...catch语句，它可以代替return语句，结束当前方法。但是无法返回正常结果，只能带回异常对象。

  需求：
    从键盘输入用户名，密码，校验码。
    当校验码错误的时候，用异常来表示

    Exception:
      1.构造器：可以给message的属性赋值
      new Exception("校验码输入错误")
      2.String getMessage()
      3.printStackTrace()    //打印异常的堆栈信息

  专门打印错误信息的输出：System.err.print();
 */
public class ThrowTest {
    @Test
    public void test1() {
        try {
            throw new RuntimeException("运行时异常");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        System.out.println("其他代码");
    }

    @Test
    public void test2() {
        try {
            login();
            System.out.println("登陆成功！");
        } catch (Exception e) {
            System.out.println("登陆失败！原因是：" + e.getMessage());
        }
    }

    public void login()throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        String code = "123";
        System.out.println("请输入校验码：(" + code + ")");
        String check = input.nextLine();

        if (!code.equals(check)) {
            throw new Exception("校验码输入错误");    //非运行时异常，按编译时异常
            //throw new RuntimeException("校验码输入错误！");
        }

        //做一个假登陆。
        //用户名：admin,密码：123
        if (!("admin".equals(username) && "123".equals(password))) {
            throw new Exception("用户名或密码错误！");
        }
    }
}
