package IOFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取写入写出流
 */
public class RandTest1 {
    public static void main(String[] args) throws IOException {

        test31();
    }
    public static void test1() throws IOException {
        RandomAccessFile read = new RandomAccessFile(new File("E:\\JavaTest\\untitled\\src\\b.txt"), "r");//r代表读取
        read.seek(3);//随机读取的起始位置
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = read.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }
        //关闭流
        read.close();
    }

    public static void test11() throws IOException {
        RandomAccessFile ac = new RandomAccessFile(new File(""), "r");
        ac.seek(45);
        byte[] b = new byte[1024];
        int len =-1;
        while ((len=ac.read(b))!=-1){
            String s = new String(b, 0, len);
            System.out.println(s);
        }
    }

    //指定起始位置读取所有内容
    public static void test2() throws IOException {
        RandomAccessFile read = new RandomAccessFile(new File("E:\\JavaTest\\untitled\\src\\IOFile\\OutAndInStream.java"), "r");//r代表读取
        int begin = 2;//起点
        int leng = 1025;
        read.seek(begin);//从起点开始读取数据
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = read.read(b)) != -1) {
            if (leng > len) {
                System.out.println(new String(b, 0, len));
                leng -= len;//去掉读取的长度
            } else {
                System.out.println(new String(b, 0, leng));//读取剩下的内容
                break;
            }
        }
        //关闭流
        read.close();
    }

    public static void test22() throws IOException{
        RandomAccessFile read=new RandomAccessFile(new File(""),"r");
        int begin=23;
        int length=2034;//设置读取长度
        read.seek(begin);
        byte[] b=new byte[1024];
        int len=-1;
        while ((len=read.read(b))!=-1){
            if (length>len){
                String s = new String(b, 0, len);
                System.out.println(s);
                length-=len;
            }else {
                String s = new String(b, 0, length);
                System.out.println(s);
                break;
            }
        }
        read.close();
    }

    //分块取文件
    public static void test3() throws IOException {
        File file = new File("E:\\JavaTest\\untitled\\src\\IOFile\\OutAndInStream.java");//获取文件
        //文件总长度
        long length = file.length();
        //每块定义大小
        int block = 512;
        //获取块数
        int size = (int) Math.ceil(length * 1.0 / block);
        //起始位置和实际大小
        int beginaddress = 0;
        int actualSize = (int) (block > length ? length : block);//实际位置
        for (int i = 0; i < size; i++) {
            beginaddress = i * block;
            if (i == size - 1) {//最后一块时候
                actualSize = (int) length;
            } else {
                actualSize = block;//可以最大长度
                length -= actualSize;//剩余长度
            }
            System.out.println("第几块" + i + "起点位置" + beginaddress + "实际长度" + actualSize);
            test4( beginaddress, actualSize);
        }
    }

    public static  void test31() throws IOException {
        String url="E:\\JavaTest\\untitled\\src\\IOFile\\oracle_day1,2.txt";
        File file = new File(url);
        long length = file.length();
        int block=1024;
        int size=(int )(length*1.0/block);//获取块数
        //起始位置
        int beginstart=0;
        int actuSize=(int)(block>length?length:block);//实际位置
        for (int i=0;i<size;i++){
            beginstart=i*block;//每次起点位置变化
            if (i==size-1){//最后一块时候
                actuSize=(int)length;

            }else {
                actuSize=block;//读取的长度
                //剩余长度
                length-=actuSize;
            }
         test41(beginstart,actuSize,url);
        }
    }
    public static void test41 (int beginstart,int actusize,String url) throws IOException{
        RandomAccessFile r = new RandomAccessFile(new File(url), "r");
        r.seek(beginstart);
        byte[] b=new byte[1024];
        int len=-1;
        while ((len=r.read(b))!=-1){
            if (actusize>len){
                System.out.println(new String(b,0,len));
                actusize-=len;
            }else {
                System.out.println(new String(b,0,actusize));
                break;
            }
        }
        r.close();
    }

    /**
     * 指定起始位置和第几块和实际长度
     *
     * @throws IOException
     */
    public static void test4( int begin, int actu) throws IOException {
        RandomAccessFile read = new RandomAccessFile(new File("E:\\JavaTest\\untitled\\src\\IOFile\\OutAndInStream.java"), "r");//r代表读取

        read.seek(begin);//从起点开始读取数据
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = read.read(b)) != -1) {
            if (actu > len) {
                System.out.println(new String(b, 0, len));
                actu -= len;//去掉读取的长度
            } else {
                System.out.println(new String(b, 0, actu));//读取剩下的内容
                break;
            }
        }
        //关闭流
        read.close();
    }
}
