package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/6 14:50
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance =(Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("hot dog");
        //I believe I can fly!
        //我喜欢吃hot dog

        System.out.println("**************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}

interface Human{
    /**
     * 获取信仰
     * @return 信仰
     */
    String getBelief();

    /**
     * 吃东西
     * @param food 食物
     */
    void eat(String food);

}
/**
 * 被代理类
 */
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{

    public void method1() {
        System.out.println("***************通用方法一******************");
    }

    public void method2() {
        System.out.println("***************通用方法二******************");
    }
}

/**
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 */
class ProxyFactory{
    /**
     * 调用此方法，返回一个代理类的对象。解决问题一
     * @param obj 被代理类的对象
     * @return 代理类的对象
     */
    public static Object getProxyInstance(Object obj) throws Exception {

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        myInvocationHandler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    //需要使用被代理类的对象进行赋值

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object returnInvoke = method.invoke(obj, args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值
        return returnInvoke;
    }
}
