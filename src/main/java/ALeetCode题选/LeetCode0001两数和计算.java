package ALeetCode题选;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Administrator
 * @PACKAGE_NAME: ALeetCode题选
 * @PROJECT_NAME: studyandtest
 * @USER: Administrator
 * @DATE: 2020/12/11 18:44
 */
public class LeetCode0001两数和计算 {
    public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int i1=target-nums[i];
            map.put(nums[i], i);
        }
        int a = 0;
        int b = 0;
        Set<Integer> integers = map.keySet();
        for (Integer num : integers) {
            int sum = target - (int) num;
            if (map.containsKey(sum)) {
                a = (int) map.get(num);
                b = (int) map.get(sum);
            }
        }
        return new int[]{a, b};
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int desired = target - nums[i];
            if (map.containsKey(desired)) {
                return new int[] {map.get(desired), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int desired = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (j>nums.length){
                    return null;
                }
                if (desired==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{2, 7, 11, 15};
        int[] nums2= new int[]{3,2,4};
        int target = 9;
//        int[] ints = twoSum(nums, target);
        int[] ints = twoSum1(nums2, 6);
        System.out.println(ints[0]+"-----"+ints[1]);
    }
}
