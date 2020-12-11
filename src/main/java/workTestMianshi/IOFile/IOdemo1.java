package workTestMianshi.IOFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOdemo1 {
    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream("file");
            FileInputStream in = new FileInputStream("file");
            out.write("tim".getBytes());
            out.flush();
            byte[] b=new byte[in.available()];
            in.read(b);
            System.out.println(new String(b));
            in.close();
            out.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
