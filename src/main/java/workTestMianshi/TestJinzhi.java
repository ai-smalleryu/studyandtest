package workTestMianshi;

import java.util.Arrays;
import java.util.Scanner;

public class TestJinzhi {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg+"============");
        }
        double[] d = {1, 23, 45, 12};
        //test1(d);
        //test1(1, 2, 3, 4);
        tets(d);
    }
    private static  void tets(double[] a){
        //Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, 4));
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数");
        int i = scanner.nextInt();
        String s = "";
        while (i != 0) {
            int next = i % 16;
            char v = (next <= 9 && next >= 0) ? (char) (next + '0') : (char) ((next - 10) + 'A');
            s = v + s;
            i = i / 16;
        }
        System.out.println(s);
    }

    private static void test1(double... args) {
        for (double arg : args) {
            System.out.println(arg);
        }
    }
}
