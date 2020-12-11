package IOFile;

import java.io.*;

public class CPIOtest4 {
    public static void main(String[] args) {
        File file = new File("E:\\JavaTest\\untitled\\c.jpg");//读取数据源
        File file1 = new File("b.jpg");//输出数据源
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);//得到文件内容
            out = new FileOutputStream(file1);
            //读取输入文件信息
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
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}
