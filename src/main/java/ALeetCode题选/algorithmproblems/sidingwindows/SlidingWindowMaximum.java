package ALeetCode题选.algorithmproblems.sidingwindows;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        int[] result = slidingWindowMaximum.maxSlidingWindow2(nums, k);

        for (int maxNum: result)
            System.out.print(maxNum + "\t");
    }

    // 1. 暴力法，遍历每一个窗口，窗口中遍历每一个数，找最大
    public int[] maxSlidingWindow1(int[] nums, int k){
        int n = nums.length;
        // 定义一个结果数组，用于输出窗口最大值序列
        int[] result = new int[n - k + 1];

        // 遍历所有窗口，以窗口起始位置为代表
        for (int i = 0; i <= n - k; i ++ ){
            // 用一个变量保存当前窗口的最大值
            int max = nums[i];
            // 遍历窗口中所有元素，取最大
            for (int j = i + 1; j < i + k; j++){
                if (nums[j] > max)
                    max = nums[j];
            }
            result[i] = max;
        }

        return result;
    }

    // 2. 使用大顶堆
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // 定义一个结果数组，用于输出窗口最大值序列
        int[] result = new int[n - k + 1];

        // 用优先队列定义一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 初始化大顶堆，将前k个元素放入堆中
        for (int i = 0; i < k; i++){
            maxHeap.add(nums[i]);
        }

        // 当前堆顶元素就是第一个窗口的最大值
        result[0] = maxHeap.peek();

        // 遍历窗口的起始元素，删除之前窗口的元素，插入最新的一个元素，保持k个元素
        for (int i = 1; i <= n - k; i++){
            // 在堆中删除上一个元素
            maxHeap.remove(nums[i-1]);
            // 插入最新的元素
            maxHeap.add(nums[i+k-1]);
            // 输出当前堆顶的最大值
            result[i] = maxHeap.peek();
        }

        return result;
    }

    // 3. 使用双向队列
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        // 定义一个结果数组，用于输出窗口最大值序列
        int[] result = new int[n - k + 1];

        // 定义双向队列
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 初始化双向队列
        for (int i = 0; i < k; i++){
            // 删除之前的更小的元素
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();
            // 当前元素入队
            deque.addLast(i);
        }

        result[0] = nums[deque.getFirst()];    // 队首元素就是第一个窗口最大值

        // 遍历数组，依次入队
        for (int i = k; i < n; i ++){
            // 首先要删除上一个窗口中的元素，如果刚好是最大值，删除队首元素
            if (!deque.isEmpty() && deque.getFirst() == i - k)
                deque.removeFirst();

            // 然后就是插入新增元素
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();
            // 当前元素入队
            deque.addLast(i);

            // 当前队首元素就是窗口最大值
            result[i-k+1] = nums[deque.getFirst()];
        }
        return result;
    }

    // 4. 左右扫描
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 定义一个结果数组，用于输出窗口最大值序列
        int[] result = new int[n - k + 1];

        // 定义两个预处理数组
        int[] left = new int[n];
        int[] right = new int[n];

        // 遍历数组，左右扫描，计算left和right值
        for (int i = 0; i < n; i++){
            // 1. 从左到右扫描
            if (i % k == 0){
                // 块的起始位置
                left[i] = nums[i];
            }else {
                // 如果是后续位置，那么跟之前的最大进行比较
                left[i] = Math.max(left[i-1], nums[i]);
            }

            // 2. 从右到左扫描
            int j = n - i - 1;
            if (j == n - 1 || j % k == k - 1){
                // 块的起始位置
                right[j] = nums[j];
            }else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }

        // 遍历所有窗口，对起始和结束位置取对应的left、right做比较
        for (int i = 0; i < n - k + 1; i++){
            result[i] = Math.max(right[i], left[i+k-1]);
        }

        return result;
    }
}
