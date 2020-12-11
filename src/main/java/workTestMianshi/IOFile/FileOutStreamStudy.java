package workTestMianshi.IOFile;

import java.io.*;

public class FileOutStreamStudy {

    public static void main(String[] args) {
        try (OutputStream outputStream=new FileOutputStream("file",true);
             InputStream in=new FileInputStream("file")){
            outputStream.write("tom".getBytes());
            outputStream.write("jakmzxcv".getBytes(),2,3);
            outputStream.flush();
            byte[] b=new byte[1024];
            in.read(b);
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
