package IOFile;

import java.io.*;

/*
对象流
 */
public class ObjectStream {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        //写出文件
        ByteArrayOutputStream byteoutStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.txt")));
            objectOutputStream.writeUTF("adqexfx");
            objectOutputStream.writeInt(12);
            objectOutputStream.flush();
            objectOutputStream.close();
            byte[] bytes = byteoutStream.toByteArray();
            System.out.println(bytes.length);
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\obj.txt")));
            String s = objectInputStream.readUTF();
            int i = objectInputStream.readInt();
            //读取到数据
            System.out.println(s + "信息" + i);
            //数据还原
            Object o = objectInputStream.readObject();
            Object o1 = objectInputStream.readObject();
            if (o instanceof String) System.out.println((String)o);
            if (o1 instanceof Integer) System.out.println((int)o1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
