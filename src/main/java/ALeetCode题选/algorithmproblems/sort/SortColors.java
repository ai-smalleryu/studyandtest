package ALeetCode题选.algorithmproblems.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        int[] nums2 = {2,0,1};
        int[] nums3 = {0};
        int[] nums4 = {1};

        SortColors sortColors = new SortColors();

        sortColors.sortColors(nums1);
        sortColors.sortColors(nums2);
        sortColors.sortColors(nums3);
        sortColors.sortColors(nums4);

        QuickSort.printArray(nums1);
        QuickSort.printArray(nums2);
        QuickSort.printArray(nums3);
        QuickSort.printArray(nums4);
    }

    // 0. 直接调库
    public void sortColors0(int[] nums){
        Arrays.sort(nums);
    }

    // 1. 基于选择排序
    public void sortColors1(int[] nums){
        int n = nums.length;

        // 单独定义一个指针，指向当前可以填充元素的位置
        int curr = 0;

        // 1. 第一次遍历，将扫描到的所有0填入数组前部
        for (int i = 0; i < n; i ++)
            if (nums[i] == 0)
                swap(nums, curr ++, i);

        // 2. 第二次遍历，将扫描到的所有1填入数组前部
        for (int i = curr; i < n; i ++)
            if (nums[i] == 1)
                swap(nums, curr ++, i);
    }

    // 2. 基于计数排序
    public void sortColors2(int[] nums) {
        int n = nums.length;

        int count0 = 0, count1 = 0;

        // 遍历数组，统计每个key的个数
        for (int num: nums){
            if (num == 0)
                count0 ++;
            else if (num == 1)
                count1 ++;
        }

        // 按照每个key的个数依次填入数组
        for (int i = 0; i < n; i++){
            if (i < count0)
                nums[i] = 0;
            else if (i < count0 + count1)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }

    // 3. 基于快排
    public void sortColors(int[] nums) {
        int n = nums.length;
        // 定义左右指针
        int left = 0, right = n - 1;

        // 遍历整个数组元素，0填到前面，2填到后面
//        for (int i = 0; i < n; i ++){
        int i = left;
        while (left < right && i <= right){
            // 1. 首先判断2，如果换过来的末尾元素还是2，需要继续调换
            while ( i <= right && nums[i] == 2)
                swap(nums, i, right --);

            // 2. 判断是否为0，如果为0换到数组前部
            if (nums[i] == 0)
                swap(nums, left ++, i);

            i ++;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
