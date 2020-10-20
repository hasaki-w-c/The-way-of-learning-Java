package jichuzhishi;

/*
异常：
  程序正常情况可以运行的，只是偶然因为其他的原因，导致“异常情况”。
      例如：用户输入参数问题，用户文件被删除，用户磁盘空间已满，网络中断。。。
  程序的运行过程中遇到了不正常的情况，导致程序暂停或者崩溃。

  Java如何处理异常？Java的异常处理机制是什么样？
  Java程序运行过程中，如果某句代码发生异常，Java会在这句代码处停下来
  Java会创建一个“异常的对象”并且给“抛”出来。
  Java会检测在这句代码的外围是否有“try..catch”可以捕获它,如果可以“捕获”它，那么程序会从这个try..catch后边继续往下运行。
  如果外围没有“try..catch”可以捕获它，那么程序就会先抛给“上级(调用者)”,上级也会检查是否有“try..catch”可以捕获它,如果可以“捕获”它，那么程序会上级的try..catch继续往下运行。
  如果一路上都没有“try..catch”可以“捕获”它，那么程序就“挂了”。

  简单说：Java的异常处理机制用“异常对象”来表示异常情况，如果有try..catch可以捕获就继续，否则就“挂了”。
 */
public class Yichang {
    public static void main(String[] args) {
        System.out.println(getDivide(2,1));
        System.out.println(getDivide(9,3));
        try {
            System.out.println(getDivide(5,0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("...");
    }

    //求两数之商
    public static int getDivide(int a, int b) {
        int shang = 0;
        try {
            shang = a / b;    //发生异常，会在这里停下来
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("计算完毕！");
        return shang;
    }
}
