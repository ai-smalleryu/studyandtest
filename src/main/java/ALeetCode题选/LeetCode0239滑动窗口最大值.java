package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/14 17:56
 * @Version 1.0
 */

import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class LeetCode0239滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k >= nums.length) {
        }

        return null;
    }

    //简单方法 使用遍历的方式
    //最简单直接的方法是遍历每个滑动窗口，找到每个窗口的最大值。一共有 N - k + 1 个滑动窗口，每个有 k 个元素，于是算法的时间复杂度为 {O}(N k)O(Nk)，表现较差。
    /*复杂度分析
    时间复杂度：{O}(N k)O(Nk)。其中 N 为数组中元素个数。
    空间复杂度：{O}(N - k + 1)O(N−k+1)，用于输出数组。*/
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        //数组长度
        int n = nums.length;
        //截取数组长度为0
        if (n * k == 0) {
            return new int[0];
        }
        //声明新的数组   长度 n-k+1  存放最大值的数组
        int[] output = new int[n - k + 1];

        //遍历获取最大值
        for (int i = 0; i < n - k + 1; i++) {
            //声明一个最大数，来存放单个数组时候的最大值
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 双向队列
     * 如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。在大小为 k 的堆中插入一个元素消耗 \log(k)log(k) 时间，因此算法的时间复杂度为 {O}(N \log(k))O(Nlog(k))。
     * 能否得到只要 {O}(N)O(N) 的算法？
     * 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
     * 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
     * 算法
     * 算法非常直截了当：
     * <p>
     * 处理前 k 个元素，初始化双向队列。
     * <p>
     * 遍历整个数组。在每一步 :
     * <p>
     * 清理双向队列 :
     * - 只保留当前滑动窗口中有的元素的索引。
     * - 移除比当前元素小的所有元素，它们不可能是最大的。
     * 将当前元素添加到双向队列中。
     * 将 deque[0] 添加到输出中。
     * 返回输出数组
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param args
     */
    //声明一个双向队列
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        //
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        //获取数组长度
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    //动态规划
    public static int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                left[i] = nums[i];  // block_start
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{12, 23, 1, 2, 14, 98, 13, 25, 57, 789, 34};
        int[] ints1 = maxSlidingWindow5(ints, 8);
        System.out.println(Arrays.toString(ints1));
    /*    int[] max = maxSlidingWindow6(ints, 20);
        System.out.println(Arrays.toString(max));*/

    }

    public static int[] maxSlidingWindow5(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        int maxIndex = -1;
        int j = 0;
        for(int i = 0; i <= nums.length - k; i++){
            if(i <= maxIndex && maxIndex < i + k){
                if(nums[maxIndex] <= nums[i+k-1]){
                    maxIndex = i+k-1;
                }
            } else {
                maxIndex = i;
                for(int m = i; m <= i + k -1; m++){
                    if(nums[maxIndex] < nums[m]) {
                        maxIndex = m;
                    }
                }
            }
            ans[j++] = nums[maxIndex];
        }
        return ans;
    }

    ///////////////////////////////////////////方法成功但是时间问题严重/////////////////////////////////////
    public static int test(int m, int n) {
        int max = Math.max(m, n);
        return max;
    }

    public static int[] maxSlidingWindow6(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }
        if (nums.length == 1||k==1) {
            return nums;
        }


        List<Integer> numList = new ArrayList<>();
        int i = nums.length - 1;
        for (int j = 0; j < i; j++) {
            numList.add(test(nums[j], nums[j + 1]));
        }
        List<Integer> numList2 =numList;
        for (int m = 0; m < k-2; m++) {
            if (numList2.size()==1){
              break;
            }
            numList2=getIntegers(numList2);
        }

        int[] s = new int[numList2.size()];
        for (int i1 = 0; i1 < s.length; i1++) {
            s[i1] = numList2.get(i1);
        }
        return s;
    }

    private static List<Integer> getIntegers(List<Integer> numList) {
        List<Integer> numList2 = new ArrayList<>();

        for (int j = 0; j < numList.size() - 1; j++) {
            numList2.add(test(numList.get(j), numList.get(j + 1)));
        }
        return numList2;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
}
