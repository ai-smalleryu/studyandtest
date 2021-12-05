package ALeetCode题选.leetCodePrimary;

/**
 * @project studyandtest ALeetCode题选.leetCodePrimary
 * @description:
 * @author: 玉雨钰瑜
 * @time: 5.8.21 22:28
 */
public class LeetCode005只出现一次的数字 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int nu = 0;
        for (int num : nums) {
            nu = nu ^ num;
        }
        return nu;
    }
}
