package IOFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 分段读取
 */
public class IOtest2 {
    public static void main(String[] args) {
        File file = new File("E:\\JavaTest\\untitled\\src\\b.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[2];//缓冲长度，没几个读取一次
            int len = -1;//接受长度
            while ((len = inputStream.read(bytes)) != -1) {
                //字节数组到字符串
                String s = new String(bytes, 0, len);//读取存放的字节数组
                System.out.print(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                //关闭资源
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
