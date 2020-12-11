package workTestMianshi.IOFile;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileOutAndInStream {
    public static void main(String[] args) {
        testBuffer();
    }

    private static void test1(String[] args) {
        try (OutputStream out = new FileOutputStream(args[1]);
             InputStream in = new FileInputStream(args[0])) {
            int len = -1;
            byte[] b = new byte[1024];
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public static void testBuffer() {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("ac1.txt"));
             InputStream in = new BufferedInputStream(new FileInputStream("a.txt"))) {
            int len = -1;
            byte[] b = new byte[1024];
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
