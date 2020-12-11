package IOFile;

import ListMap.HashMapIt;

import java.io.File;
import java.util.HashMap;

/**
 * 创建目录
 * mkdir必须有上级目录
 * mkdirs不存在一同创建
 * list列出下级名称
 * listFiles列出下级对象
 */
public class FileMkdir {
    public static void main(String[] args) {
        HashMap hashMap =
                new HashMap();
        hashMap.put("","");

    }

    public void mkdirFilr() {
        File file = new File("E:/JavaTest/untitled");
        //创建目录
        /*boolean mkdir = file.mkdir();
        System.out.println(mkdir);*/

        String[] list = file.list();

        for (String f : list
        ) {
            System.out.println(f + "name");
        }
        //获取下级对象
        File[] files = file.listFiles();
        for (File f : files
        ) {
            System.out.println(f.getAbsolutePath() + "路径");//返回路径的字符串形式
            System.out.println(f.getAbsoluteFile());//返回路径规范
        }
    }

    public static void printName(File src, int deep) {//层数
        for (int i = 0; i < deep; i++) {
            System.out.println("-");
        }
        if (null == src || !src.exists()) {
            return;
        } else if (src.isDirectory()) {//如果是目录
            for (File listFiel : src.listFiles()) {
                printName(listFiel, deep + 1);
            }
        }
    }
    //统计文件夹的大小

    public static long leng = 0;//方法只是文件大小，文件夹需要遍历。字节

    public static void length(File src) {
        if (src != null && src.exists()) {//文件存在
            leng += src.length();
        } else {
            for (File file : src.listFiles()
            ) {
                length(file);
            }
        }
    }

    /**
     * 适用对象统计文件夹大小
     */
    private static long getLeng = 0;
    public static void lengthFile(File src) {

    }
}
