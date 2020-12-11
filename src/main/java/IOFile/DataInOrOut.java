package IOFile;

import java.awt.image.DataBufferInt;
import java.io.*;

/**
 * 数据流
 * 会保留数据类型
 */
public class DataInOrOut {
    public static void main(String[] args) throws IOException {
        test1();
    }
    //DataOutputStream 写出

    /**
     * 数据输出流使应用程序以便携式方式将原始Java数据类型写入输出流。 然后应用程序可以使用数据输入流来读取数据
     * 读取顺序与写出顺序需要一样
     */
    public static void test1() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(out));
        //读出数据
        dataout.writeInt(12);
        dataout.writeShort(11);
        dataout.writeBoolean(false);
        dataout.writeUTF("asa");
        dataout.flush();
        byte[] b = out.toByteArray();
        System.out.println(b.length);
        DataInputStream in = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(b)));
        //写出数据，需要顺序相同
        int i = in.readInt();
        short s = in.readShort();
        boolean bo = in.readBoolean();
        String str = in.readUTF();
        System.out.println(i + "--" + s + "--" + bo + "--" + str);
    }

}
