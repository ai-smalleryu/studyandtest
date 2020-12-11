package IOFile;

import java.io.*;

public class BufferReadAndBufferWriter {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\oracle_day1,2.txt");
        Reader re = null;
        BufferedReader bufferRed = null;
        try {
            re = new FileReader(file);
            bufferRed = new BufferedReader(re);
            String s = null;
            while ((s = bufferRed.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferRed != null) {
                try {
                    bufferRed.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test2() {
        File file = new File("cd.txt");
        Writer out = null;
        BufferedWriter bufferout = null;
        try {
            out=new FileWriter(file);
            bufferout=new BufferedWriter(out);
            String s="tebywn oo,splqs";
           bufferout.write(s);
           bufferout.newLine();//换行
            bufferout.append("asdsdqwq");
            bufferout.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferout!=null) {
                try {
                    bufferout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
