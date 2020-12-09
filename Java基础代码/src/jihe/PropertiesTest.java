package jihe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties：常用来处理配置文件。key和value都是String类型
 * @author hasaki
 */
public class PropertiesTest {
    public static void main(String[] args){
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();
            fis = new FileInputStream("jdbc.properties");
            //加载流对应的文件
            properties.load(fis);

            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = " + name + ",password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
