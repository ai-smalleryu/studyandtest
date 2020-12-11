package workTestMianshi.IOFile;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.zip.CRC32;

public class StudyMeory {
    public static long inputStream(Path filename) {

        try (InputStream in = Files.newInputStream(filename);
             OutputStream out = new FileOutputStream("texc.jpg")) {
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = in.read()) != -1) {
                crc32.update(c);
                out.write(c);
            }
            out.flush();
            return crc32.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1L;
    }

    public static long bufferInputStream(Path filename) {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(filename));
             OutputStream out = new BufferedOutputStream(new FileOutputStream("ter.jpg"))) {
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = in.read()) != -1) {
                crc32.update(c);
                out.write(c);
            }
            out.flush();
            return crc32.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1L;
    }

    public static long randomAccessFile(Path file) {
        try (RandomAccessFile in = new RandomAccessFile(file.toFile(), "rw");
             RandomAccessFile out = new RandomAccessFile(new File("th.jpg"),"rw")
      ) {
            long length = in.length();
            CRC32 crc32 = new CRC32();
            for (long i = 0; i < length; i++) {
                in.seek(i);
                int b = in.readByte();
                crc32.update(b);
                in.write(b);
            }

            return crc32.getValue();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1L;
    }

    public static long sumMappedFile(Path file) {
        try (FileChannel fc = FileChannel.open(file)) {
            //管道从硬盘直接读入到内存当中的管道
            CRC32 crc32 = new CRC32();
            //获取文件大小
            long size = fc.size();
            //内存映射文件
            MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_ONLY, 0, size);
            for (long i = 0; i < size; i++) {
                int b = map.get((int) i);//从映射文件中读取一个字节
                crc32.update(b);
            }
            return crc32.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1L;
    }

    public static void main(String[] args) {
        System.out.println("Input Stream:");
        long start = System.currentTimeMillis();//获得当前系统时间，结果是long类型的毫秒
        Path filename = Paths.get("b.jpg");
        inputStream(filename);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Buffered Input Stream:");
        start = System.currentTimeMillis();
        bufferInputStream(filename);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Random Access File:");
        start = System.currentTimeMillis();
        randomAccessFile(filename);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");

        System.out.println("Mapped File:");
        start = System.currentTimeMillis();
        sumMappedFile(filename);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " milliseconds");
    }
}
