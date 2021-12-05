package ALeetCode题选.algorithmproblems.arrays;

import java.util.HashMap;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class TwoSum {
    public static void main(String[] args) {
        // 定义输入数据
        int[] input1 = {2,7,11,15};
        int target1 = 9;

        int[] input2 = {3,2,4};
        int target2 = 6;

        int[] input3 = {3,3};
        int target3 = 6;

        // 用大规模数据进行测试
        int[] input = new int[1000000];
        for (int i = 0; i < input.length; i++)
            input[i] = input.length - i;
        int target = 567890;

        // 创建对象，调用方法进行计算
        TwoSum twoSum = new TwoSum();

        // 保存开始和结束时间，计算运行时长
        long startTime = System.currentTimeMillis();

        int[] output = twoSum.twoSum1(input, target);

        long endTime = System.currentTimeMillis();

        System.out.println("运行时间：" + (endTime - startTime) + " ms");

        // 打印输出结果
        for (int index: output){
            System.out.print(index + "\t");
        }
    }

    // 1. 暴力法，找到所有的两数组合
    public int[] twoSum1(int[] nums, int target){
        int n = nums.length;

        // 可以先定一个数字，然后依次遍历另一个数字
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                // 判断当前两数组合，和是否为target
                if (nums[i] + nums[j] == target)
                    return new int[] {i, j};
            }
        }

        throw new IllegalArgumentException("无解！");
    }

    // 2. 使用哈希表保存数据信息，访问两遍哈希表
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;

        // 创建一个哈希表，key是数组中的元素，value是元素的索引位置
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历数组，将数据信息全部保存到哈希表
        for (int i = 0; i < n; i++){
            map.put(nums[i], i);
        }

        // 遍历数组，挨个查找每个数对应的“那个数”是否在map中
        for (int i = 0; i < n; i++){
            int thatNum = target - nums[i];

            // 如果存在，并且索引位置不是i，直接返回结果
            if (map.containsKey(thatNum) && map.get(thatNum) != i)
                return new int[] {i, map.get(thatNum)};
        }

        throw new IllegalArgumentException("无解！");
    }

    // 3. 性能优化，访问一遍哈希表
    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;

        // 创建一个哈希表，key是数组中的元素，value是元素的索引位置
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历数组，挨个查找每个数对应的“那个数”是否在map中
        for (int i = 0; i < n; i++){
            int thatNum = target - nums[i];

            // 如果存在，并且索引位置不是i，直接返回结果
            if (map.containsKey(thatNum) && map.get(thatNum) != i)
                return new int[] {map.get(thatNum), i};

            // 如果没找到，就把自己的信息填入表中，等待“那个数”
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("无解！");
    }
}
