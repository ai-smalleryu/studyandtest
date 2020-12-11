package workTestMianshi.IOFile;

import java.io.*;

public class Datafile {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try (DataOutputStream out=new DataOutputStream(new FileOutputStream("dataout.dat"));
             DataInputStream in=new DataInputStream(new FileInputStream("dataout.dat"))){
            out.writeBoolean(true);
            out.writeInt(3);
           // out.writeUTF("tomds");
            out.writeBytes("ajsoask");

            System.out.println(in.readBoolean());
            System.out.println(in.readInt());
            //System.out.println(in.readUTF());
            System.out.println(Byte.valueOf(in.readByte()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void test2(){
        try (DataOutputStream out=new DataOutputStream(new FileOutputStream("dataout.dat"));
             DataInputStream in=new DataInputStream(new FileInputStream("dataout.dat"))){
            out.writeDouble(3.14);
            out.writeLong(1L);
            out.writeBoolean(true);

            System.out.println(in.readDouble());
            System.out.println(in.readLong());
            System.out.println(in.readBoolean());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
