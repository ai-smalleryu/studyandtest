package IOFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteOutStreamTest1 {
    public static void main(String[] args) {
        ByteOutStreamTest1 byteOutStreamTest1 =
                new ByteOutStreamTest1();
        byteOutStreamTest1.test2();
    }

    //字节数组输出流
    public void test() {
        byte[] bytes=null;
        //创建流
        ByteArrayOutputStream outputStream=null;
        try{
            outputStream=new ByteArrayOutputStream();
            //写出
            String s="show xds fex";
            byte[] bytes1=s.getBytes();//字符串转换为字节
            outputStream.write(bytes1,0,bytes1.length);
            outputStream.flush();
            //获取数据
            bytes=outputStream.toByteArray();
            System.out.println(new String(bytes,0,outputStream.size()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test2(){
        ByteArrayOutputStream byteout=null;
        try {
            byte[] b=new byte[1024];
            String s="aasdacdwdc sdw";
            byte[] bytes = s.getBytes();
            byteout=new ByteArrayOutputStream();
            byteout.write(bytes,0,bytes.length);
            byteout.flush();
            byte[] bytes1 = byteout.toByteArray();
            System.out.println(new String(bytes1,0,bytes1.length));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
