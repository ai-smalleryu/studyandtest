package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2021/3/23 17:00
 * @Version 1.0
 */
public class LeetCode0191位1的个数 {
    public static void main(String[] args) {
        int i = hammingWeight2(118);
        System.out.println(i);
    }

    public static int hammingWeight(int n) {
        String s1 = Integer.toBinaryString(n);
        String[] split = String.valueOf(s1).split("");
        int i = 0;
        for (String s : split) {
            if ("1".equals(s)) {
                i++;
            }
        }
        return i;
    }

    public static int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            int m=n&1;
            //ans += (n & 1);
            ans=ans+m;
            n >>>= 1;
        }
        return ans;
    }
}
