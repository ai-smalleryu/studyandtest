package IOFile;

import java.io.*;

/**
 * 将图片转换为字节数组，字节数组还原为文件
 */
public class IObytesPictureTest {
    public static void main(String[] args) {
        // fileToByte();
       // byteToFile(fileToByte());
        //测试
        test5(test4());
    }

    public static byte[] fileToByte() {//图片到字节数组
        File file = new File("E:\\JavaTest\\untitled\\c.jpg");
        FileInputStream fileInput = null;//文件流必须释放资源
        ByteArrayOutputStream byteout = null;
        try {
            fileInput = new FileInputStream(file);
            byteout = new ByteArrayOutputStream();
            byte[] b = new byte[1024];//图片到达程序这时转换为字节
            int len = -1;
            while ((len = fileInput.read(b)) != -1) {
                byteout.write(b, 0, len);
            }
            byteout.flush();
            // byte[] bytes = byteout.toByteArray();
            return byteout.toByteArray();
            //  System.out.println(new String(bytes, 0, bytes.length));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }

    //文件-->FileInputStream-->程序---->byteArrayoutPutStream --->程序---->byteArrayINputStream--->程序--->FileOutStream---->文件
    public static void byteToFile(byte[] bytes) {
        File file = new File("g.jpg");
        ByteArrayInputStream byin = null;
        OutputStream out = null;
        try {
            byin = new ByteArrayInputStream(bytes);
            out = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = byin.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //释放资源的形式try with catch形式try（）{}catch(){}会在try里直接释放资源
    public static void byteToFile2(byte[] bytes) {
        File file = new File("g.jpg");
        ByteArrayInputStream byin = null;
        //OutputStream out=null;
        try (OutputStream out = new FileOutputStream(file)) {
            byin = new ByteArrayInputStream(bytes);
            //out=new FileOutputStream(file);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = byin.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  byte[] test4(){
        File file = new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\b.jpg");
        InputStream in=null;
        ByteArrayOutputStream outbyte=null;
        try {
            in=new FileInputStream(file);
            outbyte=new ByteArrayOutputStream();
            byte[] bytes=new byte[1024];
            int len=-1;
            while ((len=in.read(bytes))!=-1){
                outbyte.write(bytes,0,len);
            }
            outbyte.flush();
            return outbyte.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }
    public static  void test5(byte[] b){
        File file = new File("testas.jpg");
        OutputStream out=null;
        ByteArrayInputStream inbyte=null;
        try {
            inbyte=new ByteArrayInputStream(b);
            out=new FileOutputStream(file);
            byte[] bs=new byte[1024];
            int len=-1;
            while ((len=inbyte.read(bs))!=-1){
                out.write(bs,0,len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }



}
