package ALeetCode题选.leetCodePrimary;

import java.util.HashMap;

/**
 * @project studyandtest ALeetCode题选.leetCodePrimary
 * @description:
 * @author: 玉雨钰瑜
 * @time: 2021/7/31 下午10:07
 */
public class Code001删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 3, 5, 6, 6};
        System.out.println(removeDuplicates(ints));
    }

    public static int removeDuplicates(int[] nums) {
        int cout = 0;
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = integerIntegerHashMap.getOrDefault(nums[i], -1);
            if (orDefault == -1) {
                integerIntegerHashMap.put(nums[i], i);
            } else {
                cout++;
            }
        }
        return nums.length-cout;
    }
}
