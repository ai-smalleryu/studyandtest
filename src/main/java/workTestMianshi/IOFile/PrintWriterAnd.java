package workTestMianshi.IOFile;

import java.io.*;
import java.util.Scanner;

public class PrintWriterAnd {
    public static void main(String[] args) {
        //打印流
        PrintStream printWriter = System.out;
        printWriter.printf("ttgj\n");
        printWriter.println(1234);
        printWriter.println("aaaaaaaaxzxz");
        try {
            printWriter = new PrintStream(new BufferedOutputStream(new FileOutputStream("tr.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(printWriter);
        printWriter.flush();
    }

    private static void testPrint() {
        try {
            PrintWriter printWriter = new PrintWriter("print2.txt");//写入文件
            Scanner scanner = new Scanner(new FileReader("print2.txt"));//读取文件
            printWriter.println("tom");
            printWriter.println("asazxa");
            printWriter.println(1234);
            printWriter.flush();
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
