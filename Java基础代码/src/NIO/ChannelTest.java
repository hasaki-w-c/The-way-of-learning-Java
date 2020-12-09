package NIO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Set;

/**
 * 一、通道(Channel)：用于源节点与目标结点的连接。在 Java NIO 中负责缓冲区中数据的传输。
 *      Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 * 二、通道的主要实现类
 *      java.nio.channels.Channel 接口：
 *          |--FileChannel
 *          |--SocketChannel
 *          |--ServerSocketChannel
 *          |--DatagramChannel
 *
 * 三、获取通道
 *  1.Java 针对支持通道的类提供了 getChannel() 方法
 *      本地 IO:
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络 IO:
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *  2.在 JDK 1.7 中的NIO.2 针对各个通道提供了静态方法 open()
 *  3.在 JDK 1.7 中的NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 四、通道之间的数据传输
 *      transferFrom()
 *      transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 *      分散读取(Scattering Reads) ：将通道中的数据分散到多个缓冲区中
 *      聚集写入(Gathering Writes) ：将多个缓冲区中的数据都聚集到通道中
 *
 * 六、字符集：Charset
 *      编码：字符串 -> 字节数组
 *      解码：字节数组 —> 字符串
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/24 16:46
 */
public class ChannelTest {
    /**
     * 1.利用通道完成文件的复制(非直接缓冲区)
     */
    @Test
    public void test1() {
        Instant start = Instant.now();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("test.jpg");
            fos = new FileOutputStream("test4.jpg");

            //1.获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //2.分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3.将通道中的数据存入缓冲区中
            while (inChannel.read(buf) != -1) {
                //4.切换成读数据模式
                buf.flip();
                //5.将缓冲区的数据写入通道
                outChannel.write(buf);
                //6.清空缓冲区
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.关闭资源
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Instant end = Instant.now();
        System.out.println("耗时为：" + Duration.between(start, end).toMillis() + "毫秒");
        //34毫秒
    }

    /**
     * 2.使用直接缓冲区完成文件的复制（内存映射文件）
     * ps：只有 ByteBuffer 支持
     */
    @Test
    public void test2() throws IOException {
        Instant start = Instant.now();

        //1.获取通道
        FileChannel inChannel = FileChannel.open(Paths.get("test.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("test5.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        //2.内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //3.直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        //4.关闭资源
        inChannel.close();
        outChannel.close();

        Instant end = Instant.now();
        System.out.println("耗时为：" + Duration.between(start, end).toMillis() + "毫秒");
        //8毫秒
    }

    /**
     * 3.通道之间的数据传输(直接缓冲区)
     */
    @Test
    public void test3() throws IOException {
        //1.获取通道
        FileChannel inChannel = FileChannel.open(Paths.get("test.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("test5.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        //两效果一样，注意从哪来到哪去
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    /**
     * 分散和聚集
     */
    @Test
    public void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        //1.获取通道
        FileChannel channel1 = raf1.getChannel();

        //2.分配指定大小的缓存区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer bytebuffer :
                bufs) {
            bytebuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("********************");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4.聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("test.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);

        channel1.close();
        channel2.close();
    }

    /**
     * 字符集
     */
    @Test
    public void test5() {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entrySet = map.entrySet();

        for (Map.Entry<String, Charset> entry :
                entrySet) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @Test
    public void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuffer = CharBuffer.allocate(1024);
        cBuffer.put("灰灰吃屁，王琛如意");
        cBuffer.flip();

        //编码
        ByteBuffer bBuffer = ce.encode(cBuffer);

        for (int i = 0; i < 18; i++) {
            System.out.println(bBuffer.get());
        }

        //解码
        bBuffer.flip();
        CharBuffer cbuf = cd.decode(bBuffer);
        System.out.println(cbuf.toString());

        //此种就会出现乱码
        Charset cs2 = Charset.forName("UTF-8");
        bBuffer.flip();
        CharBuffer cbuf0 = cs2.decode(bBuffer);
        System.out.println(cbuf0.toString());
    }
}
