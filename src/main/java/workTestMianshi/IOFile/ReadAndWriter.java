package workTestMianshi.IOFile;

import java.io.*;

public class ReadAndWriter {
    public static void main(String[] args) {
        try (Reader read=new FileReader("a.txt");
             Writer writer=new FileWriter("a.txt",true)){
            writer.write("njk");
            writer.write("\nasazxc");
            writer.flush();
            char[] c=new char[1024];
            int i=-1;
            while ((i=read.read(c))!=-1){
                System.out.println(new String(c,0,i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
