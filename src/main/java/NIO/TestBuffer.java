package NIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * 缓存区负责数据的存取。缓存区就是数组。用于存取不同类型的数据
 * 缓存区
 * put 放入
 * get 获取
 * <p>
 * 四个核心属性
 * // Invariants: mark <= position <= limit <= capacity
 * private int mark = -1;
 * private int position = 0; 位置 表示缓存区中正在操作数据到位置
 * private int limit; 界限 表示缓冲区中可以操作的数据大小，limit后的数据不能进行读写
 * private int capacity; 容量 表示缓存区中最大存储的容量，一旦声明不可改变
 *
 * @author 镜中湖
 */
public class TestBuffer {
    public static void main(String[] args) {
        //字符集charset
        //字符集的编码和解码
        try {
   /*         SortedMap<String, Charset> map
                    = Charset.availableCharsets();
            Set<Map.Entry<String, Charset>> entries = map.entrySet();
            //获取所有支持的字符集
            for (Map.Entry<String, Charset> entry : entries) {
                System.out.println(entry.getKey() + "-------------------->" + entry.getValue());
            }*/
            Charset gbk = Charset.forName("GBK");
            //获取编码器和解码器
            CharsetEncoder charsetEncoder = gbk.newEncoder();//编码器
            CharsetDecoder charsetDecoder = gbk.newDecoder();//解码器
            CharBuffer allocate = CharBuffer.allocate(1024);
            allocate.put("---------哈哈哈哈-------------");
            allocate.flip();
            //编码 转换为了字节
            ByteBuffer encode = charsetEncoder.encode(allocate);
            for (int i = 0; i < 30; i++) {
                System.out.println(encode.get()+"char类型的编码");
            }
            //解码
            encode.flip();
            CharBuffer decode = charsetDecoder.decode(encode);
            System.out.println(decode.toString()+"解码后的数据");
            System.out.println("++++++++++++++++++++++");
            //使用UTF-8编码乱码
            Charset charset = StandardCharsets.UTF_8;
            encode.flip();
            CharBuffer decode1 = charset.decode(encode);
            System.out.println(decode1.toString()+"utf8乱码");
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }

    private static void testFileChannel() {
        //直接使用缓存区完成文件的复制（内存映射文件）
        /**
         * 多个参数时候是路径的拼接
         */
        try {
            FileChannel in = FileChannel.open(Paths.get("ac.txt"), StandardOpenOption.READ);
            FileChannel out = FileChannel.open(Paths.get("ac22.txt"),
                    StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
            MappedByteBuffer inmap = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());//内存映射文件
            MappedByteBuffer outmap = out.map(FileChannel.MapMode.READ_WRITE, 0, in.size());//这两个都是直接在内存中操作

            //复制文件 直接对缓存区进行数据的读写操作
            byte[] bytes = new byte[inmap.limit()];
            inmap.get(bytes);
            outmap.put(bytes);

            //关闭通道
            in.close();
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件分散读取和聚集
    private static void testChannel() {
        try {
            RandomAccessFile rw = new RandomAccessFile("ac.txt", "rw");//随机访问流
            //获取通道
            FileChannel channel = rw.getChannel();
            //分配指定大小的缓冲区
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(100);
            //分散读取
            ByteBuffer[] buffer = new ByteBuffer[]{byteBuffer1, byteBuffer2, byteBuffer3};
            long read = channel.read(buffer);
            System.out.println(read + "文件大小");
            for (ByteBuffer byteBuffer : buffer) {
                byteBuffer.flip();
            }
            //读取数据
            System.out.println(new String(buffer[0].array(), 0, buffer[0].limit()));
            System.out.println("==========");
            System.out.println(new String(buffer[1].array(), 0, buffer[1].limit()));
            System.out.println("------------");
            System.out.println(new String(buffer[2].array(), 0, buffer[2].limit()));

            //聚集写入
            RandomAccessFile rw1 = new RandomAccessFile("asc.txt", "rw");
            FileChannel channel1 = rw1.getChannel();
            channel1.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position() + "位置"); //初始位置是0
        System.out.println(byteBuffer.limit() + "界限");
        System.out.println(byteBuffer.capacity() + "容量");
        String s = "qwikmzskdpk";
        byteBuffer.put(s.getBytes());  //存储数据
        System.out.println(byteBuffer.position() + "位置"); //初始位置是0 缓存区有数据后移动到最新的位置
        System.out.println(byteBuffer.limit() + "界限");
        System.out.println(byteBuffer.capacity() + "容量");
        //切换成读取数据模式
        byteBuffer.flip();
        System.out.println(byteBuffer.position() + "位置"); //读取数据时候重置为0
        System.out.println(byteBuffer.limit() + "界限");  //变为存储数据时候的位置值 position
        System.out.println(byteBuffer.capacity() + "容量");
        System.out.println("++++++++++++++++++++++++++");
        //获取到数据 读取缓存区中的数据
        byte[] b = new byte[byteBuffer.limit()];
        byteBuffer.get(b);
        System.out.println(b.toString());
        System.out.println(new String(b, 0, b.length));
        System.out.println("-------");
        System.out.println(byteBuffer.position() + "位置"); //读取数据时候重置为0
        System.out.println(byteBuffer.limit() + "界限");  //变为存储数据时候的位置值 position
        System.out.println(byteBuffer.capacity() + "容量");

        //倒带缓存区 可以重复读
        byteBuffer.rewind();
        System.out.println("-------");
        System.out.println(byteBuffer.position() + "位置"); //读取数据时候重置为0
        System.out.println(byteBuffer.limit() + "界限");  //变为存储数据时候的位置值 position
        System.out.println(byteBuffer.capacity() + "容量");
        //清空缓存区 缓存区中的数据并没有清除，只是处于被遗忘状态
        System.out.println("111111111111111111111111111111111111111");
        //获取到数据 读取缓存区中的数据
        byte[] b1 = new byte[byteBuffer.limit()];
        byteBuffer.get(b1);
        System.out.println(b1.toString());
        System.out.println(new String(b1, 0, b1.length));
        System.out.println("-------");
        System.out.println(byteBuffer.position() + "位置"); //读取数据时候重置为0
        System.out.println(byteBuffer.limit() + "界限");  //变为存储数据时候的位置值 position
        System.out.println(byteBuffer.capacity() + "容量");
    }

}
