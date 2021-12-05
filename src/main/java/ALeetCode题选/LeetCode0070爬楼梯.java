package ALeetCode题选;

/**
 * @project studyandtest ALeetCode题选
 * @description:
 * @author: 玉雨钰瑜
 * @time: 6.9.21 22:48
 */
public class LeetCode0070爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static  int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
