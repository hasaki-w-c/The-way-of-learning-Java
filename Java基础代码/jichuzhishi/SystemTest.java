package jichuzhishi;

import org.junit.jupiter.api.Test;

/*
System有三个常量对象：
System.in:InputStream
System.out:PrintStream
System.err:PrintStream

System.currentTimeMillis():当前时间与协调世界时1970年1月1日午夜之间的时间差（以毫秒为单位测量）。
System.arraycopy(src,srcPost,dest,destPost,int len)
    第一个参数：被复制（移动）数组
    第二个数组：从哪个位置开始复制（移动）
    第三个参数：目标数组
    第四个参数：目标的起始位置
    第五个参数：要复制（移动）元素个数
 */
public class SystemTest {
    @Test
    public void test1() {
        //插入
        String[] arr = new String[5];
        arr[0] = "hello";
        arr[1] = "java";
        arr[2] = "world";
        arr[3] = "string";
        arr[4] = "array";

        //要删除arr[1]
        int index = 1;
        int total = 5;
        System.arraycopy(arr,index + 1, arr, index, total-index-1);
        arr[total - 1] = null;
        total --;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test2() {
        //插入
        String[] arr = new String[5];
        arr[0] = "hello";
        arr[1] = "java";
        arr[2] = "world";
        arr[3] = "string";
        arr[4] = null;

        //要在arr[1]插入"array"
        int index = 1;
        int total = 4;
        System.arraycopy(arr,index, arr, index + 1, total-index);
        arr[index] = "array";
        total ++;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
