package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/22 10:02
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class LeetCode剑指offer数组中重复数字次数 {
    //空间复杂度n 时间n
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    //空间1 时间n
    public int findRepeatNumber2(int[] nums) {
        for(int current = 0;current < nums.length;) {
            if (nums[current] == current) {
                current++;
            } else {
                // 当前index = current下标值nums[current]和 index = nums[current] 的下标值 nums[nums[current]]相等
                if(nums[current] == nums[nums[current]]) {
                    return nums[current];
                } else {
                    swapTwoNumberInArray(nums, current, nums[current]);
                }
            }
        }
        return -1; // 没找到
    }
    //进行交换
    public  void swapTwoNumberInArray(int[] nums, int current, int another) {
        int temp = nums[current];
        nums[current] = nums[another];
        nums[another] = temp;
    }

    public static int test1(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length<=1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.getOrDefault(nums[i], new Integer(-1));
            if (orDefault!=-1){
                return nums[i];
            }else {
                map.put(nums[i],i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints=new int[]{12,23,112,3,21,34,0,23,0};
        int i = test1(ints);
        System.out.println(i);
    }
}
