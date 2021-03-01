package ALeetCode题选;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class LeetCode0009回文数 {
    public static void main(String[] args) {
        int i = -1;
        boolean b = T2(i);
        System.out.println(b);
    }

    public static boolean T1(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int num = chars.length / 2;
        for (int i = 0; i < num; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean T2(int x) {
        StringBuilder stringBuilder=new StringBuilder(String.valueOf(x));
        boolean equals = stringBuilder.toString().equals(stringBuilder.reverse().toString());
        return equals;
    }
}

