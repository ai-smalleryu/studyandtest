package IOFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 大小
 */
public class CommonsIO {
    public static void main(String[] args) throws IOException {
        testcop();
    }

    public static void testCommons() {
        //文件的大小
        long l = FileUtils.sizeOf(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\b.jpg"));
        System.out.println(l);
        //目录大小
        long ld = FileUtils.sizeOf(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest"));
        System.out.println(ld);
    }

    //列出子孙集
    public static void test() {
        Collection<File> files = FileUtils.listFiles(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest"),
                EmptyFileFilter.NOT_EMPTY, null);//默认操作一层，只显示有文件内容的NOT_EMPTY  如果是empty戴白哦只显示空文件
        for (File file : files
        ) {
            System.out.println(file.getName() + "aa" + file.getAbsolutePath());
        }
        System.out.println("--------------------------");
        Collection<File> files1 = FileUtils.listFiles(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest"),
                EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);//操作子孙集
        for (File file : files1
        ) {
            System.out.println(file.getName() + "aa" + file.getAbsolutePath());
        }
        System.out.println("-------------------");
        Collection<File> files2 = FileUtils.listFiles(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest"),
                new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);//文件后缀只能时Java的
        for (File file : files2
        ) {
            System.out.println(file);
        }

        System.out.println("++++++++++++++++++++++++");
        Collection<File> files3 = FileUtils.listFiles(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest"),
                FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
        //文件后缀只能时Java的和class的FileFilterUtils里可多次拼接
        for (File file : files3
        ) {
            System.out.println(file);
        }


    }

    //读取文件
    public static void test1() throws IOException {
        String string = FileUtils.readFileToString(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\test.txt"), "utf8");
        System.out.println(string);

        List<String> utf8 = FileUtils.readLines(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\test.txt"), "utf8");//逐行读取返回的是集合
        System.out.println(utf8.size() + "长度");
        for (String s : utf8) {
            System.out.println(s);

        }
        byte[] bytes = FileUtils.readFileToByteArray(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\test.txt"));
        //迭代读取
        LineIterator utf81 = FileUtils.lineIterator(new File("C:\\Users\\镜中湖\\IdeaProjects\\JavaTest\\test.txt"), "utf8");
        while (utf81.hasNext()) {
            System.out.println(utf81.nextLine());
        }
    }

    //写出内容
    public static void test2() throws IOException {
        //第一个参数写出路径，第二个参数写出内容，第三个参数字符编码形式，第四个是否追加内容
        FileUtils.write(new File("at.txt"), "snaimas", "utf8", true);
        FileUtils.writeStringToFile(new File("at.txt"), "snaimas", "utf8", true);//两个方法一样
        //字节输入
        FileUtils.writeByteArrayToFile(new File("at.txt"), "asas".getBytes("utf8"), true);//子啊getbytes方法中设置编码格式

        //细微处列表
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("asas");
        objects.add("asazx");
        objects.add("qwe");
        objects.add("哈哈");
        //写出路径，，写出列表，，，写出两个列表之间的连接符，，，是否追加写入
        FileUtils.writeLines(new File("at.txt"), objects, "---", true);

    }

    public static void testcop() throws IOException {
        //复制文件
       // FileUtils.copyFile(new File(""),new File(""));
        //复制文件到目录
       // FileUtils.copyFileToDirectory(new File(""),new File(""));
        //复制目录到目录,作为子目录
      //  FileUtils.copyDirectoryToDirectory(new File("E:\\JavaTest\\untitled\\src\\workTestMianshi"),new File("ts"));
        //复制目录
       // FileUtils.copyDirectory(new File(""),new File(""));
        //复制内容url
        FileUtils.copyURLToFile(new URL("https://home.firefoxchina.cn/"),new File("a.txt"));
//读取
        String string = IOUtils.toString(new URL(""), "gbk");
    }
}
