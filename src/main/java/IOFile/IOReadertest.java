package IOFile;

import javax.sound.midi.Soundbank;
import java.io.*;

/**
 * 文件字符输入流
 */
public class IOReadertest {
    public static void main(String[] args) {
        IOReadertest ioReadertest = new IOReadertest();
        ioReadertest.test3();
    }

    //文件字符输入流
    public void test1() {
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\oracle_day1,2.txt");
        FileReader read = null;
        try {
            read = new FileReader(file);
            //字符数组使用char
            char[] c = new char[1024];
            int len = -1;
            while ((len = read.read(c)) != -1) {
                String s = new String(c, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        int aq=1;
    }

    //文件字符输出流
    public void test2() {
        File file = new File("s.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            String s = "aaaaa散散心";
            //方法一
           /* char[] chars = s.toCharArray();
            writer.write(chars, 0, chars.length);*/

            //方法二  因为是字符流 所以可以直接输出
            /* writer.write(s);*/

            //方法三append和Stringbuild类似可以不停的追加
            writer.append(s).append("add");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test3() {
        //图片使用字节
        File file = new File("E:\\JavaTest\\untitled\\c.jpg");//输入流
        File file1 = new File("cpoa.txt");//输出流
        Writer writer = null;
        Reader reader = null;
        try {
            reader = new FileReader(file);
            writer = new FileWriter(file1);
            char[] c = new char[1024];
            int len = -1;
            while ((len = reader.read(c)) != -1) {
                writer.write(c,0,len);
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
