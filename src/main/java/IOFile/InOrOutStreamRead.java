package IOFile;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 转换流inputStreamRead字节流转换为字符流
 * outPutStreamRead字符流转换为字节流
 * <p>
 * 1以字符流的形式操作字节流
 * 2指定字符集
 */
public class InOrOutStreamRead {
    public static void main(String[] args) {
        test5();
    }




    public static void test1() {
        BufferedWriter writer = null;
        BufferedReader read = null;
        try {
            read = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String s = "";
            while (!s.equals("exit")) {
                s = read.readLine();//循环读取数据
                writer.write(s);//循环写出
                writer.newLine();//换行
                writer.flush();//刷新缓存空间
            }
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

    public static void test2() {
        InputStream in = null;
        try {
            in = new URL("https://www.cnblogs.com/owenma/p/8609348.html").openStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = in.read(b)) != -1) {
                String s = new String(b, 0, len, "gbk");
                System.out.println(s);

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解决乱码问题
    public static void test3() {
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(new URL("http://www.biqitxt.com/").openStream(), "gbk");

            char[] c = new char[1024];
            int len = -1;
            while ((len = in.read(c)) != -1) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用bufferReader加快效率
    public static void test4() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL("http://www.biqitxt.com/").openStream(), "gbk"));
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
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
        }
    }

    //爬虫后输出
    public static void test5() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL("https://www.cnblogs.com/owenma/p/8609348.html").openStream(), "utf8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.html"), "utf8"));
            String s = null;
            while ((s = reader.readLine()) != null) {
                writer.write(s);
                writer.newLine();
            }
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
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
