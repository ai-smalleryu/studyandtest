package ALeetCode题选;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * 提示：
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
public class LeetCode0697数组的度 {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 1};
        findShortestSubArray(a);
    }

    public static int findShortestSubArray(int[] nums) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> index = map.getOrDefault(nums[i], new ArrayList<>());
            index.add(i);
            map.put(nums[i], index);
        }
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger i2 = new AtomicInteger(0);
        map.forEach((k, v) -> {
            if (v.size() > 1) {
                int n = v.get(v.size() - 1) - v.get(0) + 1;
                if (i.get() < v.size()) {
                    i.set(v.size());
                    i2.set(n);
                } else if (i.get() == v.size()) {
                    if (i2.get() > n) {
                        i.set(v.size());
                        i2.set(n);
                    }
                }
            }
            if (i.get()==0){
                i2.set(1);
            }
        });
        System.out.println(i2.get());
        return i2.get();
    }

    public static int findShortestSubArray2(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

}
