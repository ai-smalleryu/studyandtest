package ALeetCode题选.algorithmproblems.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};

        SingleNumber singleNumber = new SingleNumber();

        System.out.println(singleNumber.singleNumber(nums1));
        System.out.println(singleNumber.singleNumber(nums2));
    }

    // 1. 暴力法，统计每个数字出现的次数
    public int singleNumber1(int[] nums){
        // 用一个HashMap保存出现的次数
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // 遍历数组，统计次数
        for (int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 在HashMap里查找次数为1的key
        for (int num: countMap.keySet()){
            if (countMap.get(num) == 1)
                return num;
        }

        return -1;
    }

    // 2. 只保存单个元素
    // 用列表保存（时间复杂度高，不能接受）
    public int singleNumber21(int[] nums){
        ArrayList<Integer> singleList = new ArrayList<>();

        for (Integer num: nums){
            // 如果已经有了，就直接删除；如果没有就添加
            if (singleList.contains(num))
                singleList.remove(num);
            else
                singleList.add(num);
        }

        // 最后只剩一个元素，就是落单的那个
        return singleList.get(0);
    }
    // 用哈希表保存
    public int singleNumber2(int[] nums){
//        HashMap<Integer, Integer> singleNumMap = new HashMap<>();
        HashSet<Integer> singleNumSet = new HashSet<>();

        for (Integer num: nums){
            // 如果已经有了，就直接删除；如果没有就添加
            if (singleNumSet.contains(num))
                singleNumSet.remove(num);
            else
                singleNumSet.add(num);
        }

        // 最后只剩一个元素，就是落单的那个
        return singleNumSet.iterator().next();
    }

    // 3. 数学方法：求和
    public int singleNumber3(int[] nums){
        // 利用Set去重保存所有元素
        HashSet<Integer> set = new HashSet<>();

        // 求set中所有去重元素的和，以及原数组所有元素的和
        int arraySum = 0, setSum = 0;
        for (int num: nums){
            arraySum += num;
            set.add(num);
        }
        for (int num: set)
            setSum += num;

        return setSum * 2 - arraySum;
    }

    // 4. 数学方法：异或
    public int singleNumber(int[] nums){
        int result = 0;
        for (int num: nums)
            result ^= num;
        return result;
    }
}
