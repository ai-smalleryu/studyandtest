package workTestMianshi.IOFile;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

public class PathStudy {

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
 class Test5 {
    public static void main(String[] args) throws IOException {
        Path fileA = Paths.get("a");
        Path fileB = Paths.get("b");
        Path fileC = Paths.get("d/c");
        Path dirD = Paths.get("d");
        //Java 11: Path p = Path.of("file");
        //Path表示计算机中的一个文件、目录或路径，且这些内容不必真是存在
        if (!Files.exists(fileA)) //如果fileA不存在
            Files.createFile(fileA); //建立新文件

        if (!Files.exists(dirD)) //如果dirD不存在
            Files.createDirectory(dirD); //建立新文件夹

        if (!Files.exists(fileB)) //如果fileB不存在
            Files.copy(fileA, fileB); //拷贝文件

        if (!Files.exists(fileC)) Files.move(fileB, fileC);
        Files.deleteIfExists(fileC);
        Files.deleteIfExists(dirD); //如果dirD存在则将其删除

        InputStream is = Files.newInputStream(fileA);
        OutputStream os = Files.newOutputStream(fileA);
        Files.write(fileA, "hello, world".getBytes());
        System.out.println(new String(Files.readAllBytes(fileA)));

    }
}

