package IOFile;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.Buffer;

public class BuffferedInputStreamAndBufferout {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\oracle_day1,2.txt");
        InputStream in = null;
        BufferedInputStream bufferIn = null;
        try {
            in = new FileInputStream(file);
            bufferIn = new BufferedInputStream(in);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = bufferIn.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferIn != null) {
                try {
                    bufferIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test2() {
        File file = new File("s.txt");
        OutputStream out = null;
        BufferedOutputStream bufferout = null;
        try {
            out=new FileOutputStream(file);
            bufferout=new BufferedOutputStream(out);
            String s="aqwdcd fwrw";
            byte[] bytes = s.getBytes();
            bufferout.write(bytes);
            bufferout.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void test3() {
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\oracle_day1,2.txt");
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            byte[] b=new byte[1024];
            int len =-1;
            while ((len=in.read(b))!=-1){
                String s = new String(b, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
