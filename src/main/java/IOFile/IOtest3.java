package IOFile;

import java.io.*;

/**
 * 输出流
 */
public class IOtest3 {
    public static void main(String[] args) {
        //创建源
        File file = new File("test.txt");
        //选择流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            //写出
            String s = "asdqcsc fwrfb zz";
            //outputStream.write(1231);
            byte[] bytes = s.getBytes();//转换成字节数组
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
