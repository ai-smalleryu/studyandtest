package workTestMianshi;


import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.*;

public class TestString {
    public static void main(String[] args) {
        Integer a = 221;
        Integer b = 221;
        System.out.println(a == b);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    private static void weiyu() {
        String a = "asas";
        String b = "asaszcd";
        int i = 0;
        System.out.println(i++);
        String s = a.concat(b);
        System.out.println(s);
        String as = "jk";
        String ba = "JK";

        System.out.println(as.compareTo(ba) + "++aa");
        System.out.println(as.compareToIgnoreCase(ba) + "++aa");
        System.out.println(as.equals(ba) + "++aa");
        System.out.println(as.equalsIgnoreCase(ba) + "++aa");
        System.out.println(sqrt(pow(2, 3) + pow(4, 3)));
        // 位运算符，只能针对整形进行计算
        // &按位与运算符： 两个位中有0就是0，其余都是1
        // |按位或运算符： 两个位中有1就是1，其余都是0
        // ^按位异或运算符： 两个位相同结果就是0，不同就是1
        // ~按位求反运算符：
        // >>带符号右移运算符：向右移动1位等于对这个数除2，正数移动时高位补0，负数补1
        // <<左移运算符：向左移动1位等于对这个数乘2，地位永远补0
        // >>>无符号右移运算符：与>>的区别就是高位永远补0
        System.out.println(2 & 7); //2=10, 7=111
        System.out.println(2 | 7);
        System.out.println(3 ^ 7);
        System.out.println(~3);
        System.out.println(16 >> 2);
        System.out.println(2 << 3);
        System.out.println(-16 >>> 2);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        String k = "lkl|lklkaa";
        String[] s1 = k.split("[|]");
        for (String string :
                s1) {
            System.out.println(string);
        }
        System.out.println(s1);
    }

}
