package IOFile;

import java.io.*;
import java.util.HashMap;

public class ByteInputStreamTest1 {
    public static void main(String[] args) {
        ByteInputStreamTest1 byteInputStreamTest1 =
                new ByteInputStreamTest1();
        byteInputStreamTest1.testByteInputStream();
    }

    //字节数组输入流

    /**
     * 源头是字节数组（不要太大）
     * 不需要释放资源
     *
     */
    public void testByteInputStream() {
        byte[] b="asdwxeowmke,wsaso".getBytes();
        ByteArrayInputStream byteInStr=null;
        try {
            byteInStr=new ByteArrayInputStream(b);
            byte[] bs=new byte[5];

            int len=-1;
            while ((len=byteInStr.read(bs))!=-1){
                String s=new String(bs,0,len);
                System.out.println(s);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {

        }
    }
}
