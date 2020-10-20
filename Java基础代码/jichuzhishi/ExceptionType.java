package jichuzhishi;

/*
异常的父类：java.lang.Throwable
Throwable类是Java语言中所有错误和异常的超类。

Throwable:
(1)Error:一个Error是的子类Throwable表示严重的问题，合理的应用程序不应该试图捕获。
  例如：VirtualMachineError：Java虚拟机已损坏或已耗尽资源以使其继续运行。

  面试题：
  编写代码，使得发生VirtualMachineError(StackOverflowError(栈溢出),OutOfMemoryError(堆内存溢出))
  StackOverflowError错误的示例：
  OutOfMemoryError错误的示例：

(2)Exception:
  ①RuntimeException：运行时异常：只有RuntimeException或者是它的子类是属于运行时异常

  常见的运行时异常：
      ArrayIndexOutOfBoundsException数组下标越界异常    //面试尽量不写这种异常
      NullPointerException空指针异常
      ClassCastException类型转换异常
      ArithmeticException算数异常    //面试尽量不写这种异常

  ②编译时异常：除了运行时异常，其他的都是编译时异常。

  常见的编译时异常：
      InterruptedException线程中断异常
      FileNotFoundException文件找不到

  如何区分属于哪种异常：
    凡是运行时异常，编译器不会要求必须加“try..catch”或者是“throws”
    凡是编译时异常，编译器强制要求加“try..catch”或者是“throws”之一，否则编译不通过

  面试题：
      列出你开发中常见的异常类型（至少五个）
      列出几种运行时异常
      列出几种编译时异常
 */
public class ExceptionType {
    /*@Test
    public void testStackOverflowError() {
        testStackOverflowError();
    }

     */

    /*@Test
    public void testOutOfMemoryError() {
        Object[] arr = new Object[Integer.MAX_VALUE];    //Integer.MAX_VALUE整数的最大值
    }

     */

    /*@Test
    public void testRuntimeException() {
        int arr[] = new int[5];
        //System.out.println(arr[6]);    //ArrayIndexOutOfBoundsException数组下标越界异常

        String str = null;
        System.out.println(str.length());    //NullPointerException空指针异常
    }

     */

    /*@Test
    public void test() {
        Thread.sleep(1000);
    }

     */

    /*@Test
    public void test() {
        FileInputStream fis = new FileInputStream("");
    }

     */

}
