package yichang;
/*
异常的处理try...catch...finally
一、语法结构
  try {
      可能发生异常的代码
  }catch(异常的类型1 异常名称) {
      捕获到该异常，要如何处理的代码：（1）什么也不写（2）打印异常（3）其他的处理方式
  }catch(异常的类型2 异常名称) {
      捕获到该异常，要如何处理的代码
  }
  ...
  finally{
      无论try中是否发生异常，也不管catch是否可以捕获异常，都要执行的代码块。
  }
 */
public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int a= 2;
            int b = 0;
            int c = a / b;
            System.out.println("c = " + c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Over!");
        }
    }
}
