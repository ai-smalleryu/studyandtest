package Stringday1;

import java.io.File;

/*
File测试
 */
public class TestFileDay1 {
    public static void main(String[] args) {
        File file = new File("E:\\JavaTest\\untitled\\src\\a.txt");
        file.renameTo(new File("E:\\JavaTest\\untitled\\src\\b.txt"));//重命名

        System.out.println( System.getProperty("user.dir"));//当前环境
        System.out.println(file.length());//文件大小 getName() getPath//绝对路径getAbsolutePath


    }
}
