package ALeetCode题选.algorithmproblems.binarysearch;

import sun.rmi.server.InactiveGroupException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {1,1};
        int[] nums4 = {1,1,2};
        int[] nums5 = {2,1,5,2,6,2,2};

        FindDuplicate findDuplicate = new FindDuplicate();

        System.out.println(findDuplicate.findDuplicate(nums1));
        System.out.println(findDuplicate.findDuplicate(nums2));
        System.out.println(findDuplicate.findDuplicate(nums3));
        System.out.println(findDuplicate.findDuplicate(nums4));
        System.out.println(findDuplicate.findDuplicate(nums5));
    }

    // 1. 保存元素法
    public int findDuplicate0(int[] nums){
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // 遍历所有元素，一次统计个数，保存到hash map
        for (Integer num: nums){
            if (!countMap.containsKey(num))
                countMap.put(num, 1);
            else
                return num;
        }
        return -1;
    }

    public int findDuplicate1(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for (Integer num: nums){
            if (set.contains(num))
                return num;
            else
                set.add(num);
        }
        return -1;
    }

    // 2. 二分查找
    public int findDuplicate2(int[] nums){
        int n = nums.length;

        // 定义双指针
        int left = 1;
        int right = n - 1;

        while (left <= right){
            int i = (left + right) / 2;

            // 对当前i计算count(i)
            int count = 0;
            // 遍历数组，计算count值
            for (int j = 0; j < n; j++){
                if (nums[j] <= i)
                    count ++;
            }

            // 根据count值判断继续查找哪一部分
            if ( count <= i )
                left = i + 1;
            else
                right = i;

            // 如果左右指针相遇，就找到了target
            if(left == right)
                return left;
        }

        return -1;
    }

    // 3. 排序法
    public int findDuplicate3(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            // 直接判断与前一个元素是否相等
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return -1;
    }

    // 4. 双指针法
    public int findDuplicate(int[] nums){
        // 1. 第一阶段，用Floyd判圈法寻找环内节点
        // 定义快慢指针
        int fast = 0, slow = 0;
        do{
            // 快指针一次走两步，慢指针一次走一步
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        // 当fast再次追上slow，就找到了环内节点

        // 2. 第二阶段，使用双指针寻找环的入口
        int p1 = 0, p2 = slow;
        while (p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }

        // p1和p2相遇时，就找到了入口节点，也就是要找的重复数

        return p1;
    }
}
