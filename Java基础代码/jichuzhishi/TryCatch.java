package jichuzhishi;

/*
异常的处理try...catch
一、语法结构
  try {
      可能发生异常的代码
  }catch(异常的类型1 异常名称) {
      捕获到该异常，要如何处理的代码：（1）什么也不写（2）打印异常（3）其他的处理方式
  }catch(异常的类型2 异常名称) {
      捕获到该异常，要如何处理的代码
  }
  ...

二、执行特点
  1.如果try中的代码没有发生异常，只执行try中的代码，不会执行catch
  2.如果try中的代码发生了异常
    ①有catch可以捕获它，那么哪个可以捕获就进哪个，按顺序找对应的catch，执行一个catch。
    ②所有的catch都无法捕获它，那么自动网上抛。

  说明：多个catch有要求，必须小的在上边，大的类型在上边，如果没有大小关系就随意。这里的大小关系是继承，子类小于父类。
  Integer.parseInt(xx):把xx字符串转成一个整数
 */
public class TryCatch {
    public static void main(String[] args) {
        //从命令行接收两个参数，做除法（命令行参数：是指给main的形参赋值的实参）
        //第一个参数：args[0]
        //第二个参数：args[1]

        try {
            String s1 = args[0];
            String s2 = args[1];
            System.out.println("被除数：" + s1);
            System.out.println("除数：" + s2);
            int b = Integer.parseInt(s1);
            int c = Integer.parseInt(s2);
            int shang = b / c;
            System.out.println("结果：" + shang);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("参数的个数少于两个！");
        } catch (NumberFormatException e) {
            System.out.println("传入的参数不是整数！");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (Exception e) {
            System.out.println("存在异常");    //如果出现以上类型异常，则不会显示这句话
        }
    }
}
