package ALeetCode题选.leetCodePrimary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @project studyandtest ALeetCode题选.leetCodePrimary
 * @description:
 * @author: 玉雨钰瑜
 * @time: 3.8.21 21:41
 */
public class Code004存在重复元素 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 1};
        System.out.println(containsDuplicate2(ints));
    }

    public static boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = integerHashMap.getOrDefault(nums[i], -1);
            if (orDefault == -1) {
                integerHashMap.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return false;
            }
        }
        return true;
    }
}
