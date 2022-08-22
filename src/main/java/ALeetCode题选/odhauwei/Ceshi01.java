package ALeetCode题选.odhauwei;

import org.junit.Test;

import java.util.*;

/**
 * @project studyandtest ALeetCode题选.odhauwei
 * @description:
 * @author: 玉雨钰瑜
 * @time: 5.12.21 18:18
 */
public class Ceshi01 {
    public static void main(String[] args) {

        char a = 'a';
        System.out.println(a ^ a);
    }

    public static void t1(String s) {
        String[] split = s.split("");
        for (String s1 : split) {

        }

    }

    public static int t2(int[] nums, int n) {
        int length = nums.length;
        // 用优先队列构建一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 1.所有元素入堆
        for (int num : nums) {
            maxHeap.offer(num);
        }

        // 用优先队列构建一个小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 1.所有元素入堆
        for (int num : nums) {
            minHeap.offer(num);
        }

        //获取最大的几个元素
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer poll = maxHeap.poll();
            count += poll;
        }

        //获取小的几个元素
        for (int i = 0; i < n; i++) {
            Integer poll = minHeap.poll();
            count += poll;
        }

        if (2 * n > length) {
            return -1;
        } else {
            return count;
        }

    }


    public static String t2(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length < 1) {
            return "";
        }
        HashMap<Integer, String> integerListHashMap = new HashMap<>();
        int numlength = 0;
        // 用优先队列构建一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            //获取数字中最大的长度的数字
            numlength = Math.max(String.valueOf(nums[i]).length(), numlength);
        }

        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() < numlength) {
                StringBuilder s = new StringBuilder(String.valueOf(nums[i]));
                int length = s.length();
                int def = numlength - length;
                for (int j = 0; j < def; j++) {
                    //拼接新的元素
                    s.append("0");
                }
                Integer integer = Integer.valueOf(s.toString());

                integerListHashMap.put(integer, String.valueOf(length));

                maxHeap.offer(integer);
            } else {

                integerListHashMap.put(nums[i], String.valueOf(String.valueOf(nums[i]).length()));
                maxHeap.offer(nums[i]);
            }
        }
        StringBuilder append = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Integer poll = maxHeap.poll();
            String s = integerListHashMap.get(poll);
            Integer numSi = Integer.valueOf(s);
            String substring = String.valueOf(poll).substring(0, numSi);
            append.append(substring);
        }
        return append.toString();
    }
}
