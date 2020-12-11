package workTestMianshi;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

    static int[] f(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            ++nums[i];
        return nums;
    }

    static void test(int... args) {
        String s = ";";
        int length = s.length();
        System.out.println(length);
        System.out.println(args.length);
        System.out.println(Arrays.toString(args) + "======");
        System.out.println();
    }

    static StringBuilder b = new StringBuilder();

    public static void main(String[] args) {
       String s="asadsa";
        System.out.println("as".length());
        System.out.println(s.substring(2,5));
    }

    public static int Test(String s, int i) {
        String[] chars = s.split("");
        if (i == 0) {
            b.append(s);
        }
        if (i != 0) {
            String[] chars1 = b.toString().split("");
            for (int n = 0; n < chars1.length; n++) {
                if (chars1[n].equals(chars[0])) {
                    String substring = b.substring(n, s.toCharArray().length + 1);
                    if (substring.equals(s)) {
                        return n;
                    } else {
                        continue;
                    }
                }
            }
            b.append(s);
        }
        return -1;
    }

    public static void test3() {
        int[] nums = {1, 2, 3};//这种语法只能在数组声明时使用
        System.out.println(Arrays.toString(f(nums)));
        System.out.println(Arrays.toString(nums));
        test(1, 2, 3);
        test(new int[]{7, 8, 9});

        System.out.println(2e+2);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        LocalDateTime of = LocalDateTime.of(12, 3, 12, 2, 3);
        System.out.println(of);
        LocalDate now = LocalDate.now();
        System.out.println(now);
        int dayOfMonth = now1.getDayOfMonth();
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = now1.getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfYear = now1.getDayOfYear();
        System.out.println(dayOfYear);

        int x = 3, y = 3;
        switch (x + 3) {
            case 6:
                y = 1;
            default:
                y += 1;
                System.out.println(y);
        }
    }

}

class Main {
    static StringBuilder b = new StringBuilder();
    static StringBuilder c = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");

        shortLength(split);
        System.out.println(c.length()+"==="+c);
    }

    public static void  shortLength(String[] s){
        for (int i = 0; i < s.length; i++) {
            int test = test(s[i], i);
        }
    }

    public static int test(String s, int i) {
        String[] chars = s.split("");
        if (i == 0) {
            b.append(s);
            c.append(s+"#");
        }
        if (i != 0) {
            String[] chars1 = b.toString().split("");
            for (int n = 0; n < chars1.length; n++) {
                if (chars1[n].equals(chars[0])) {
                    int m=s.toCharArray().length ;
                    if ((n+m)<=chars1.length+1){
                        String substring = b.substring(n,n+m);
                        if (substring.equals(s)) {
                            return n;
                        }
                    }

                }
            }
            b.append(s);
            c.append(s+"#");
        }
        return -1;
    }
}
