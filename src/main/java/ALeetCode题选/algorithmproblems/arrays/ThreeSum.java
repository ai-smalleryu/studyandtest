package ALeetCode题选.algorithmproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] inputList = {-1,0,1,2,-1,-4};
        int[] input2 = {};
        int[] input3 = {0};

        ThreeSum threeSum = new ThreeSum();

        System.out.println(threeSum.threeSum3(input3));
    }

    // 1. 暴力法，遍历所有三数可能的组合
    public List<List<Integer>> threeSum1(int[] nums){
        int n = nums.length;
        // 定义输出列表
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        // 三重for循环
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    // 判断当前三个数和是否为0，如果是，添加一组解到resultList
                    if (nums[i] + nums[j] + nums[k] == 0)
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return resultList;
    }

    // 2. 使用哈希表进行优化
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        // 定义输出列表
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        // 定义一个哈希表，应该保存数据元素的信息，以及对应匹配的另两个数的信息
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        // 遍历数组，寻找每个数对应的thatNum是否在map中
        for (int i = 0; i < n; i++){
            int thatNum = - nums[i];

            // 如果存在，那么就添加一组解
            if (hashMap.containsKey(thatNum)){
                ArrayList<Integer> tempList = new ArrayList<>(hashMap.get(thatNum));
                // 添加当前数进入数组
                tempList.add(nums[i]);
                resultList.add(tempList);
            }

            // 如果不存在，就遍历之前的所有元素，与当前数据构成二元组进行保存
            for (int j = 0; j < i; j++){
                int newKey = nums[i] + nums[j];
                // 判断是否存在这个key，如果不存在就添加
                if (!hashMap.containsKey(newKey)){
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[j]);
                    tempList.add(nums[i]);
                    hashMap.put(newKey, tempList);
                }
            }
        }
        return resultList;
    }

    // 3. 使用双指针进行优化
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        // 定义输出列表
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        // 1. 对数组进行排序
        Arrays.sort(nums);

        // 2. 遍历每一个元素，作为“核心”（最小的那个数）
        for (int i = 0; i < n; i++){
            // 排除特殊情况
            // 如果当前元素已经大于0，直接退出循环
            if (nums[i] > 0)
                break;
            // 如果当前元素跟之前的重复，直接跳过
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            // 定义左右指针
            int lp = i + 1;
            int rp = n - 1;

            // 只要左右指针不相遇，就一直循环判断，移动指针
            while ( lp < rp ){
                int sum = nums[i] + nums[lp] + nums[rp];
                // 判断当前三数之和，如果等于0，输出结果，同时移动左右指针
                if (sum == 0){
                    resultList.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp ++;
                    rp --;
                    // 针对相同的元素去重
                    while (lp < rp && nums[lp] == nums[lp - 1])
                        lp ++;
                    while (lp < rp && nums[rp] == nums[rp + 1])
                        rp --;
                }
                // 如果和为负，左指针右移
                else if (sum < 0)
                    lp ++;
                // 如果和为正，右指针左移
                else
                    rp --;
            }
        }

        return resultList;
    }
}
