package NIO;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 一、缓冲区(Buffer) : 在Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同类型数据的数据
 *      根据数据类型不同(boolean  除外),提供了相应类型的缓冲区：
 *      ByteBuffer
 *      CharBuffer
 *      ShortBuffer
 *      IntBuffer
 *      LongBuffer
 *      FloatBuffer
 *      DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate() 获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put() : 存入数据到缓冲区
 * get() : 获取缓冲区的数据
 *
 * 四、缓冲区的四个核心属性：
 * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 * position : 位置，表示缓冲区中正在操作数据的位置。
 *
 * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到mark的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 五、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
 * 直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。
 * 
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/23 15:57
 */
public class BufferTest {

    @Test
    public void test1() {
        String str = "hasaki";

        //1. 分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("--------------allocation()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //0
        //1024
        //1024

        //2.利用put() 存入数据到缓冲区
        buffer.put(str.getBytes());

        System.out.println("--------------put()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //6
        //1024
        //1024
        
        //3. 切换成读取数据模式
        buffer.flip();

        System.out.println("--------------flip()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //0
        //6
        //1024

        //4. 利用get() 读取缓冲区中的数据
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));

        System.out.println("--------------get()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //6
        //6
        //1024

        //5. rewind() : 可重复读
        buffer.rewind();

        System.out.println("--------------rewind()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //0
        //6
        //1024

        //6. clearO4() : 清空缓冲区,但是缓冲区的数据依然存在，但是处于“被遗忘”状态
        buffer.clear();

        System.out.println("--------------clear()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //0
        //1024
        //1024
    }

    @Test
    public void test2() {
        String str = "hasaki";

        ByteBuffer bb = ByteBuffer.allocate(1024);

        bb.put(str.getBytes());

        bb.flip();

        byte[] dst = new byte[bb.limit()];

        bb.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        //ha

        System.out.println(bb.position());
        //2

        //mark() : 标记
        bb.mark();

        bb.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        //sa
        System.out.println(bb.position());
        //4

        //reset() : 恢复到 mark 的位置
        bb.reset();

        System.out.println(bb.position());
        //2

        //判断缓冲区中是否还有剩余数据
        if (bb.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(bb.remaining());
            //4
        }
    }

    @Test
    public void test3() {
        //分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);

        System.out.println(buf.isDirect());
    }

}
