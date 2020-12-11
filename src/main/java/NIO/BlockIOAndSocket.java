package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 镜中湖
 * 使用NIO完成通信的三个核心
 * 1 通道 Channel负责连接
 * 2 缓冲区 Buffer 负责数据的存取
 * 3 选择器 selector 是selectableChannel的多路复用器 用于监控selectableChannel的IO状况
 */
public class BlockIOAndSocket {
    public static void main(String[] args) {

    }

    public static void clent() {
        //客户端
        try {
            //获取通道
            SocketChannel open = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            //文件
            FileChannel inChannel = FileChannel.open(Paths.get("ac.txt"), StandardOpenOption.READ);
            //分配指定大小的缓存区
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            //读取本地文件 并发送到服务器
            while (inChannel.read(allocate) != -1) {
                allocate.flip();
                open.write(allocate);
                allocate.clear();
            }
            //关闭通道
            inChannel.close();
            open.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务端
    public static void server() {
        //获取通道
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            FileChannel out = FileChannel.open(Paths.get("aaaa.tx"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            //绑定连接
            channel.bind(new InetSocketAddress(9999));
            //获取客户端连接
            SocketChannel accept = channel.accept();
            //分配指定大小的缓存区
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            //接收客户端数据并且保存到本地
            while (accept.read(allocate) != -1) {
                allocate.flip();
                out.write(allocate);
                allocate.clear();
            }
            //关闭对应的通到
            accept.close();
            out.close();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
