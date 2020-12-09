package jichuzhishi;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/*
java中都讲究见名知意

需求：
  从键盘输入用户名，密码，校验码。
  当校验码错误的时候，用异常来表示

  1、Throwable类,只有作为此类（或其一个子类）的实例的对象由Java虚拟机抛出，或者可以由Java throw语句抛出。
  类似地，只有这个类或其子类可以是catch子句中的参数类型。
  对于异常，编译时检查的目的Throwable和任何子类Throwable ，
  是不是也无论是子类RuntimeException或Error被视为检查的异常。

  结论：要想一个类称为“异常类”，必须继承Throwable或它的子类。

  2、自定义异常的对象，只能由Throw语句手动抛出。

  3、建议自定义异常，增加两个构造器
  （1）无参构造精良保留
  （2）有参构造：异常类型（String message），可以为message属性赋值
 */
public class DefineException {
    public static void main(String[] args) throws Exception {
        try {
            login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void login() throws Exception, UsernameOrPasswordError {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        String code = "123";
        System.out.println("请输入校验码：(" + code + ")");
        String check = input.nextLine();

        if (!code.equals(check)) {
            throw new UsernameOrPasswordError("校验码输入错误");    //非运行时异常，按编译时异常
            //throw new RuntimeException("校验码输入错误！");
        }

        //做一个假登陆。
        //用户名：admin,密码：123
        if (!("admin".equals(username) && "123".equals(password))) {
            throw new UsernameOrPasswordError("用户名或密码错误！");
        }
    }
}

class UsernameOrPasswordError extends Exception{
    public UsernameOrPasswordError() {
    }

    public UsernameOrPasswordError(String message) {
        super(message);
    }
}