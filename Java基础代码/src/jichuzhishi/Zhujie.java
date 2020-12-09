package jichuzhishi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;

/*
注解：
长什么样？ @注解名

注解是什么？
 注解也是注释，是代码级别的注释，用代码给代码注释

注解有三个部分组成
 （1）声明注解，定义注解
     我们开发中，绝大多数都是别人定义好的。
 （2）使用注解（重要）
     我们开发中，主要是这步
 （3）读取注解的信息
     我们把读取注解注解信息的代码称为“注解信息处理流程”
     如果没有这一步，则前边两步都没有意义
     读取注解的信息的代码基本上也是别人写好的
     读取注解信息的代码需要“反射”的知识。

 常见的注解：
 一、系统预定义的三个最最基本的注解
 1.@Override
   这是由JDK的核心库定义，读取它是由编译器，例如Javac.exe。
   作用：注释这个方法是一个重写的方法，让编译器对这个方法的签名进行格式的检查，是否满足重写的要求。

 2.@SuppressWarnings(xxx)
   这是由JDK的核心库定义，读取它是由编译器，例如Javac.exe。
   作用：抑制警告

 3.@Deprecated
   这是由JDK的核心库定义，读取它是由编译器，例如Javac.exe。
   作用：告知编译器和程序员这个方法、属性、类等已过时，不建议再使用，如果使用有问题，自己负责。

 二、用于文档的注解
 */

/**
 * @author 王琛
 * @version jdk14
 * @since jdk1.5

 三、单元测试相关的注解
   1.声明：第三方声明，不是JDK声明的
   2.读取：由JUnit框架来读取
   3.使用
     （1）引入第三方回归测试框架jar（一堆类的class文件）
   目前的IDE都有集成

   项目名上右键->Build Path->Add Library->选择版本->finish
     （2）可以使用的注解（在方法上）
          @Test
          用@Test标记的方法有要求
          （1）这个方法本身必须是public,void,()
          （2）这个方法所在的类也必须是public
          如果没有选择方法，那么当前类的所有的@Test标记的方法都会执行如果选择了其中的一个方法，那么就只运行这一个

   白盒测试：程序自测，需要明确知道测试的代码的编写，功能。。。
   黑盒测试：测试人员，不需要知道功能如何实现，只对着用户的需求文档，性能要求，安全要求进行各种测试

 四、自定义注解：
   （1）声明
   （2）使用
   （3）读取

 1.声明
   格式：
  【权限修饰符】@interface 注解名{

          }
 2.使用
   @注解名
 3.读取
   特别说明，如果需要反射读取某个注解，那么这个注解声明的时候，一定要增加这个元注解@Retention(RetentionPolicy.RUNTIME)
 4.元注解
   元注解：给注解加的注解
   元数据：
   元。。：

   ①@Target(xx)
     用来标记这个注解可以用在xx位置。
     这个位置由ElementType枚举的常量对象来指定。
   ②Retention(xx)
     标记这个注解可以滞留到xx阶段。
     这个生命周期由RetentionPolicy枚举的常量对象来执行。SOURCE（源代码），CLASS（字节码阶段）。RUNTIME（运行时）
   ③@Documented
     标记这个注解是否可以被javadoc.exe读取到API中。
   ④@Inherited
     标记这个注解是否可以被子类继承
   ⑤@Repeatable(xx)
     这个可重复注解在哪个容器中可以使用，这个容器必须是一个注解的类型
     这个可重复的直接必须和容器的target是一样的，或者比容器的target大
 5.配置参数
   (1)如何声明配置参数
   格式：
   【权限修饰符】@interface 注解名{
       数据类型 配置参数名1();
       数据类型 配置参数名2();
   }
   (2)配置参数的赋值
     如果注解声明的配置参数，那么在使用这个注解时，要给这个配置参数赋值
     标准的赋值格式：@注解名(配置参数名1 = 参数值1，配置参数名2 = 参数值2...)
     如果配置参数的个数只有一个，并且名称是value，那么可以省略”配置参数名 =“
     篇日志参数如果有默认值，那么可以不赋值
   (3)配置参数的类型有要求：
     类型只能是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、以上所有类型的数组。
 */
public class Zhujie {
    /**
     * 这是主方法，是Java程序的入口
     * @param args String[] 命令行参数
     */
    public static void main(String[] args) {

    }

    /**
     * 求两个整数的最大值
     * @param a int 其中一个整数
     * @param b int 其中另一个整肃
     * @return int 返回a和b中的较大者
     */
    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    /**
     *求两个整数的商
     * @param a int 被除数
     * @param b int 除数
     * @return int 商，只保留整数部分
     * @throws RuntimeException 当除数为0时，会抛出异常
     */
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("除数不能为0");
        }
        return a / b;
    }

    //单元测试的@Test注解
    @Test
    public void test1(){
        System.out.println("hello Junit");
    }

    //JUnit5新特性
    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        //System.out.println(1 +1);    //测试样例
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }


    @Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE,ElementType.LOCAL_VARIABLE})    //注解位置
    @Retention(RetentionPolicy.RUNTIME)    //生命周期
            //自定义注解
    @interface MyAnnotation{

    }

    @MyAnnotation
    class Myclass{
        @MyAnnotation
        private int i;
        @MyAnnotation
        public void test() {

        }
    }

    @interface A{
        //配置参数
        String info();
    }

    @A(info = "a")
    class B{

    }
}
