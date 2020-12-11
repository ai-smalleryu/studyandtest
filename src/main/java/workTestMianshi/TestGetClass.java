package workTestMianshi;


import java.io.FileReader;
import java.util.*;

public class TestGetClass extends TestA {
    public static void main(String[] args) {
        testNextInt();
    }

    public void test1() {
        System.out.println(super.getClass().getName() + "aaa");//此时会显示自己的类名
        System.out.println(getClass().getSuperclass().getName());

    }

    public static void test2() {//统计英文文章中的单词个数
        try {
            FileReader fileReader = new FileReader("");
            int sum = 0;
            boolean bool = false;
            int len = -1;
            while ((len = fileReader.read()) != -1) {
                if (len == ' ' || len == '\n' || len == '\t' || len == '\r') {
                    bool = false;
                } else if (!bool) {
                    sum += 1;
                }
            }
            fileReader.close();
            System.out.println(sum + "字母数量");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void day() {
        //判断日期是一年的第几天
        int[][] data = {{}, {}};
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年月日，中间用空格标识");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println(year + "  " + month + "--" + day);
    }

    public static void testNextInt() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String next = scanner.next();


        System.out.println(s);

    }
}

class TestA {
    public void say() {
        System.out.println("aaaaaaaaaaaaa");
    }


    public static void main(String[] args) {
      String s="police_kkkkk_police";
        String s1 = s.replace("police", "aaaaa");
        System.out.println(s1);

    }
}
