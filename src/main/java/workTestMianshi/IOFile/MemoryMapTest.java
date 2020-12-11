package workTestMianshi.IOFile;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.zip.*;


public class MemoryMapTest {
    public static long checksumInputStream(Path filename) throws IOException {
        try (InputStream in = Files.newInputStream(filename)) {
            CRC32 crc = new CRC32();
            int c;
            while ((c = in.read()) != -1)
                crc.update(c);
            return crc.getValue();
        }
    }

    public static long checksumBufferedInputStream(Path filename) throws IOException {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(filename))) {
            CRC32 crc = new CRC32();
            int c;
            while ((c = in.read()) != -1)
                crc.update(c);
            return crc.getValue();
        }
    }

    public static long checksumRandomAccessFile(Path filename) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filename.toFile(), "r")) {
            long length = file.length();
            CRC32 crc = new CRC32();

            for (long p = 0; p < length; p++) {
                file.seek(p);
                int c = file.readByte();
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static long checksumMappedFile(Path filename) throws IOException {
        try (FileChannel channel = FileChannel.open(filename)) {
            //FileChannel表示文件通道，即从硬盘直接读入内存的专属通道
            CRC32 crc = new CRC32();
            int length = (int) channel.size();//求文件大小
            MappedByteBuffer buffer //内存映射文件
                    = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);


            for (int p = 0; p < length; p++) {
                int c = buffer.get(p);  //get从内存映射文件中读取一个字节
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Input Stream:");
        long start = System.currentTimeMillis();//获得当前系统时间，结果是long类型的毫秒
        Path filename = Paths.get("f.png");
        checksumInputStream(filename);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Buffered Input Stream:");
        start = System.currentTimeMillis();
        checksumBufferedInputStream(filename);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Random Access File:");
        start = System.currentTimeMillis();
        checksumRandomAccessFile(filename);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Mapped File:");
        start = System.currentTimeMillis();
        checksumMappedFile(filename);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");
    }
}
