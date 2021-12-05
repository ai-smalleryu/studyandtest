package ALeetCode题选.algorithmproblems.sort;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 45, 67, 62, 55, 98, 11, 19, 11, 45};

        printArray(nums);

        quickSort(nums, 0, nums.length - 1);

        printArray(nums);
    }

    public static void printArray(int[] nums){
        for (int num: nums)
            System.out.print(num + "\t");
        System.out.println();
    }

    public static void quickSort(int[] nums, int start, int end){
        // 基准情况
        if (start >= end) return;

        // 找到一个基准点的位置，然后划分成两个区域进行递归
        int pivotPosition = partition(nums, start, end);

        quickSort(nums, start, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
    }

    // 定义一个分区方法
    public static int partition1(int[] nums, int start, int end){
        // 找一个基准点，这里默认数组输入是随机的，直接取第一个值
        int pivot = nums[start];

        // 定义左右指针
        int left = start, right = end;

        while (left < right){
            // 左指针一直右移，直到找到一个更大的数
            while (left < right && nums[left] <= pivot)
                left ++;
            // 右指针一直左移，直到找到一个更小的数
            while (left < right && nums[right] >= pivot)
                right --;

            // 交换两数
            swap(nums, left, right);
        }

        // 左右指针相遇，填入pivot，返回索引
        if (nums[left] <= pivot) {
            swap(nums, start, left);
            return left;
        } else {
            swap(nums, start, left - 1);
            return left - 1;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int[] nums, int start, int end){
        int pivot = nums[start];

        int left = start, right = end;

        while (left < right){
            while (left < right && nums[right] >= pivot)
                right --;

            // 将找到的更小的数，填入left指向的位置
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot)
                left ++;

            nums[right] = nums[left];
        }

        // 左右指针相遇，直接就是pivot所在位置
        nums[left] = pivot;
        return left;
    }
}
