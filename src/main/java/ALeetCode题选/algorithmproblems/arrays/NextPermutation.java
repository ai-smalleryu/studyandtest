package ALeetCode题选.algorithmproblems.arrays;

import java.util.Arrays;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {3,2,1};
        int[] nums3 = {1,1,5};
        int[] nums4 = {1};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums1);
        nextPermutation.nextPermutation(nums2);
        nextPermutation.nextPermutation(nums3);
        nextPermutation.nextPermutation(nums4);

        printIntArray(nums1);
        printIntArray(nums2);
        printIntArray(nums3);
        printIntArray(nums4);
    }

    public static void printIntArray(int[] nums){
        for (int num: nums)
            System.out.print(num + "\t");
        System.out.println();
    }

    public void nextPermutation(int[] nums){
        int n = nums.length, i = n - 1;
        // 1. 从后往前，找到第一对升序排列的两个数
        while ( i > 0 && nums[i-1] >= nums[i] )
            i --;

//        // 2. 如果没有找到升序排列的两个数，那么已经是最大的排列，直接返回升序序列
//        if ( i <= 0 ){
//            reverse(nums, 0, n - 1);
//            return;
//        }

        // 3. 确定了要替换的数a[i-1]，寻找替换它的数

        if (i > 0){
            int j = i + 1;
            while ( j < n && nums[j] > nums[i - 1] )
                j ++;

            // 4. 交换找到的a[i-1]和a[j-1]
            swap(nums, i - 1, j - 1);
        }

        // 5. a[i]之后的子序列替换成升序排列的最小情况，定义双指针头尾调换
        reverse(nums, i, n - 1);
    }

    // 定义数组元素交换的方法
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 定义一个反转数组的方法
    private void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
}
