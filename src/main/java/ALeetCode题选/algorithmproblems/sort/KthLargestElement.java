package ALeetCode题选.algorithmproblems.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums1 = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int k1 = 2;
        int k2 = 1;

        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(nums1, k1));
        System.out.println(kthLargestElement.findKthLargest1(nums2, k2));
    }


    // 1. 直接排序法
    public int findKthLargest0(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 2. 堆排序法
    public int findKthLargest1(int[] nums, int k){
        int n = nums.length;

        // 用优先队列构建一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 1.所有元素入堆
        for (int num: nums) {
            maxHeap.offer(num);
        }

        // 2. 删除k-1个元素
        for (int i = 0; i < k - 1; i++) {
            Integer poll = maxHeap.poll();

        }

        // 3. 获取堆顶元素返回
        return maxHeap.peek();
    }

    // 自定义实现堆排序
    public int findKthLargest2(int[] nums, int k){
        int n = nums.length;

        // 定义堆的大小
        int heapSize = n;
        // 1. 构建一个大顶堆
        buildMaxHeap(nums, heapSize);

        // 2. 删除k-1个元素，将删除的元素放到数组末尾，就是已经排好序的最大元素
        for (int i = n - 1; i > n - k; i--){
            swap(nums, 0, i);
            heapSize --;
            // 将数组调整成大顶堆（元素下沉和上浮）
            maxHeapify(nums, 0, heapSize);
        }

        // 3. 返回堆顶元素
        return nums[0];
    }

    // 构建大顶堆的方法
    public void buildMaxHeap(int[] nums, int heapSize){
        // 从后往前，对每个节点为根的堆调用maxHeapify
        for (int i = heapSize / 2 - 1; i >= 0; i --)
            maxHeapify(nums, i, heapSize);
    }

    // 以索引位置为top的节点为根调整大顶堆，核心是节点的上浮下沉，递归调用
    public void maxHeapify(int[] nums, int top, int heapSize){
        // 定义当前top的左右子节点
        int left = top * 2 + 1;
        int right = top * 2 + 2;

        // 保留当前最大的元素位置
        int largest = top;
        // 判断左右子节点，寻找最大元素
        if ( right < heapSize && nums[right] > nums[largest])
            largest = right;
        if ( left < heapSize && nums[left] > nums[largest])
            largest = left;

        // 将最大元素上浮到堆顶，原堆顶元素下沉
        if (largest != top) {
            swap(nums, top, largest);
            // 递归调用，继续堆调换之后的top位置进行调整堆操作
            maxHeapify(nums, largest, heapSize);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 3. 快速选择
    public int findKthLargest(int[] nums, int k){
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    // 快速选择方法，方便递归调用
    public int quickSelect(int[] nums, int index, int start, int end){
        // 找到基准点的索引位置
        int pivotPosition = randomPartition(nums, start, end);

        // 判断是否正好是要找的index
        if (pivotPosition == index)
            return nums[pivotPosition];
        else
            // 如果不是，递归调用某一部分
            return pivotPosition > index ? quickSelect(nums, index, start, pivotPosition - 1)
                    : quickSelect(nums, index, pivotPosition + 1, end);
    }

    // 定义一个随机分区方法
    public int randomPartition(int[] nums, int start, int end){
        Random random = new Random();
        int randomIndex = start + random.nextInt(end - start + 1);

        swap(nums, start, randomIndex);

        return QuickSort.partition(nums, start, end);
    }
}
