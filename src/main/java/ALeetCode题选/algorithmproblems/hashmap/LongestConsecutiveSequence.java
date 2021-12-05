package ALeetCode题选.algorithmproblems.hashmap;

import java.util.HashSet;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums1 = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

        System.out.println(longestConsecutiveSequence.longestConsecutive(nums1));
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums2));
    }

    // 1. 暴力法
    public int longestConsecutive1(int[] nums){
        // 定义变量保存当前找到的最大长度
        int maxLength = 0;

        // 遍历数组，以当前元素作为起始找一个序列
        for (int i = 0; i < nums.length; i ++){
            int currNum = nums[i];
            int currLength = 1;    // 序列至少包括自己，长度为1

            // 不停地寻找“后继”数字
            while (contains(nums, currNum + 1)){
                currLength ++;
                currNum ++;
            }

            // 判断是否可以替换最大长度
            if (currLength > maxLength)
                maxLength = currLength;
        }

        return maxLength;
    }

    // 实现一个contains方法，判断某个元素x是否在nums数组中
    public static boolean contains(int[] nums, int x){
        for (int num: nums){
            if (num == x)
                return true;
        }
        return false;
    }

    // 2. 使用哈希表改进
    public int longestConsecutive2(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();

        // 定义变量保存当前找到的最大长度
        int maxLength = 0;

        // 遍历数组，将每个数保存到哈希表
        for (int num: nums)
            hashSet.add(num);

        // 再次遍历数组，依次寻找每个数的后继
        for (int i = 0; i < nums.length; i ++){
            int currNum = nums[i];
            int currLength = 1;    // 序列至少包括自己，长度为1

            // 不停地寻找“后继”数字
            while (hashSet.contains(currNum + 1)){
                currLength ++;
                currNum ++;
            }

            // 判断是否可以替换最大长度
            if (currLength > maxLength)
                maxLength = currLength;
        }

        return maxLength;
    }

    // 3. 使用哈希表进一步改进
    public int longestConsecutive(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();

        // 定义变量保存当前找到的最大长度
        int maxLength = 0;

        // 遍历数组，将每个数保存到哈希表
        for (int num: nums)
            hashSet.add(num);

        // 再次遍历数组，依次寻找每个数的后继
        for (int i = 0; i < nums.length; i ++){
            int currNum = nums[i];
            int currLength = 1;    // 序列至少包括自己，长度为1

            // 再寻找后继之前，先判断“前驱”是否存在
            if (!hashSet.contains(currNum - 1)){
                // 不停地寻找“后继”数字
                while (hashSet.contains(currNum + 1)){
                    currLength ++;
                    currNum ++;
                }

                // 判断是否可以替换最大长度
                if (currLength > maxLength)
                    maxLength = currLength;
            }
        }

        return maxLength;
    }
}
