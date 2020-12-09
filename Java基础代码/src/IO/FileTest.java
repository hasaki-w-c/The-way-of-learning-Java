package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称文件夹）
 * 2.File类声明在java.IO包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间，文件大小等方法。
 *      并未涉及到写入或读取文件内容的操作,如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或者写入的“终点”。
 *
 *
 *
 * @author hasaki
 */
public class FileTest {
    /**
     * 1.如何创建File类的实例
     *  File(String filePath)
     *  File(String parentPath, String childPath)
     *  File(File parentFie, String childPath)
     *
     * 2.
     * 相对路径：相较于某个路径下指明的路径。
     * 绝对路径：包含盘符在内的文件或文件目录的一个路径
     *
     * 3.路径分隔符：
     * windows:\\
     * Unix:/
     * 通用写法：File.separator（可以根据操作系统，动态的提供分隔符）
     */
    @Test
    public void test1() {

        //构造器1
        //hello.txt这种写法就是相对路径，相对于当前的module
        File file1 = new File("hello.txt");
        //G:\Java基础代码\src\IO\he.txt这种写法就是绝对路径。
        File file2 = new File("G:\\Java基础代码\\src\\IO\\he.txt");

        System.out.println(file1);
        System.out.println(file2);


        //构造器2
        File file3 = new File("G:\\Java基础代码","src\\IO");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3,"he.txt");
        System.out.println(file4);
    }

    /**
     * public String getAbsolutePath():获取绝对路径
     * public String getPath():获取路径
     * public String getName():获取名称
     * public String getParent():获取上层文件目录路径。若无，返回null
     * public long length():获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified():获取最后一次的修改时间，毫秒值
     */
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("G:\\Java基础代码\\src\\IO\\he.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    /**
     * 如下的两个方法适用于文件目录
     * public String[] list():获取指定目录下的所有文件或者文件目录的名称数组（输出名称）
     * public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组(输出路径)
     */
    @Test
    public void test3() {
        File file1 = new File("C:\\Users\\Lenovo\\Desktop\\java");

        String[] list = file1.list();

        for (String s : list) {
            System.out.println(s);
        }

        File[] listFiles = file1.listFiles();
        for (File f : listFiles) {
            System.out.println(f.toString());
        }
    }

    /**
     * public boolean renameTo(File dest):把文件重命名为指定的路径
     * 比如：file1.renameTo(file2)为例：
     * 要想保证是返回true，需要file1在硬盘中是存在的，且file2是不能在硬盘中存在。
     */
    @Test
    public void test4() {
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\Lenovo\\Desktop\\hasaki.txt");

        boolean rename = file2.renameTo(file1);

        System.out.println(rename);
    }

    /**
     * public boolean isDirectory():判断是否是文件目录
     * public boolean isFile():判断是否是文件
     * public boolean exists():判断是否存在
     * public boolean canRead():判断是否可读
     * public boolean canWrite():判断是否可写
     * public boolean isHidden():判断是否隐藏
     */
    @Test
    public void test5() {
        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    /**
     * 创建硬盘中对应的文件或文件目录
     * public boolean createNewFile():创建文件。若文件存在，则不创建，返回false
     * public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录也不存在，也不创建
     * public boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建
     *
     * 删除硬盘中对应的文件或文件目录
     * public boolean delete():删除文件或者文件夹
     *删除注意事项：
     *      Java中的删除不走回收站。
     */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if (file1.exists()) {
            System.out.println("该目录下已有该文件，删除该文件");
            file1.delete();
            System.out.println("删除成功！");
        }else {
            file1.createNewFile();
            System.out.println("创建成功！");
        }
    }

    /**
     * 文件目录的创建
     */
    @Test
    public void test7() {
        File file = new File("C:\\Users\\Lenovo\\Desktop\\try\\test");
        boolean mkdir = file.mkdir();
        if (!file.exists()) {
            System.out.println("通过mkdir创建文件失败");
        }else {
            System.out.println("通过mkdir创建成功！");
        }

        boolean mkdirs = file.mkdirs();
        if (!file.exists()) {
            System.out.println("通过mkdirs创建文件失败");
        }else {
            System.out.println("通过mkdirs创建成功！");
        }
    }

}
