package yichang;

/*
throws:
  用在声明一个方法时，明确声明该方法可能抛出xx异常。说明这些异常在该方法中没有try...catch，由调用者处理。

  语法格式：
  【修饰符】 返回值类型 方法名（【形参列表】）【throws 异常列表】{}

  说明：throws后边可以接多个异常，顺序无所谓，一般如果有父类异常，子类异常就不写了。
 */
public class ThrowsTest {
    public static void main(String[] args) {
        try {
            System.out.println(divide(2,2));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int divide(int a, int b)throws ArithmeticException, Exception{
        return a / b;
    }
}
