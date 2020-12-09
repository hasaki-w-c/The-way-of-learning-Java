package reflection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/5 15:25
 */
public class ClassLoaderTest {
    @Test
    public void test1() {

        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);
        //jdk.internal.loader.ClassLoaders$PlatformClassLoader@29b5cd00

        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类记载其主要负责加载Java的核心类库，无法加载自定义类的。
        ClassLoader classLoaderParentParent = classLoaderParent.getParent();
        System.out.println(classLoaderParentParent);
        //null  //获取不到不是没有

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }

    /**
     * Properties：用来读取配置文件。
     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件的方式一：
        //此时的文件位置在工程目录下
        //FileInputStream fis = new FileInputStream("jdbc.properties");
        //pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //配置文件默认识别位：当前module下的src下
        InputStream ras = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(ras);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + "\npassword = " + password);
    }
}
