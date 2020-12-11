package Stringday1;

import java.io.File;

public class TestTreePrint {
    /*
    递归打印目录
     */
    public static void main(String[] args) {
        printFile(new File("F:\\21.【缓冲流、转换流、序列化流、打印流】\\21.【缓冲流、转换流、序列化流、打印流】-笔记"),0);
    }
    static  void printFile(File file,int leve)
    {
        //输出层数
        for (int i = 0; i < leve; i++) {
            System.out.print("-");
        }
        String s=file.getName();
        System.out.println(s+"文件");
        if (file.isDirectory())//判断抽象文件是否是一个目录
        {
            File[] files = file.listFiles();//返回文件目录数组
            for (File temp:files) {
                printFile(temp,leve+1);
            }

        }
    }
}
