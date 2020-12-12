package ALeetCode题选;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 */
public class LeetCode007整数反转 {
    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int m = chars.length;
        int i = m / 2;
        for (int j = 0; j <= i; j++) {
            char c;
            c=chars[j];
           chars[j] = chars[m - j];
           chars[m-j]=c;
        }
        String s = String.valueOf(chars);
        System.out.println(s);
        return 0;
    }

    public static void main(String[] args) {
        reverse(23);
    }
}
