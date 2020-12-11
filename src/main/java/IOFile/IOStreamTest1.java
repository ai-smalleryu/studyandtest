package IOFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOStreamTest1 {
    public static void main(String[] args) {
        //创建源IOFile/
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\abc.txt");
        FileInputStream fileInputStream=null;
        try {
            fileInputStream= new FileInputStream(file);//字节读取
            int read1 = fileInputStream.read();//第一个字节读取的是字节流所以输出上是编码值，强转回char即可
            System.out.println(read1);
            /**
             * 最后读取不到数据时候read是-1 所以用-1 判断数据是否读取结束
             *
             */
            //释放资源
            int temp;
            while ((temp=fileInputStream.read())!=-1){
                System.out.print((char) temp);
            }
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
