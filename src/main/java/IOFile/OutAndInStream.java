package IOFile;

import java.io.*;

/**
 * 整合输入输出
 */
public class OutAndInStream {
    public static void main(String[] args) {
        OutAndInStream outAndInStream = new OutAndInStream();
        outAndInStream.test3();
    }

    //复制文件
    public void test2() {
        File file = new File("E:\\JavaTest\\untitled\\c.jpg");//输入源
        File file1 = new File("cpc.jpg");//输出源

        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(file1);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字节输入
    public void test1() {
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\oracle_day1,2.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字节输出
    public void test3() {
        File file = new File("t.txt");
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            String s = "qsadedqfemo,xsa";
            byte[] bytes = s.getBytes();
            out.write(bytes,0,bytes.length);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
