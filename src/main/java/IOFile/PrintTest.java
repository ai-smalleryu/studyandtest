package IOFile;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
打印流
 */
public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException {
        test1();
    }

    public static void test1() throws FileNotFoundException {
        //打印流
        PrintStream ps = System.out;
        ps.println("psa");
        ps.println("数据信息ssssss");
        ps.println(true);
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.txt")));//输出数据位置
        ps.println("打印数据信息");
        ps.println("maimsoasoal");
        ps.println(true);

        //输出重定向，让输入信息到文档当中
        System.setOut(ps);
        System.out.println("masiamsa");//信息不会出现在控制台上，会直接到达到文档当中那个
        ps.flush();//需要刷新
        // ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("test.txt")),ture);这样和刷新一样结果

    }
}
