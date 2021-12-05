package ALeetCode题选.algorithmproblems.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};

        MergeIntervals mergeIntervals = new MergeIntervals();

        for (int[] interval: mergeIntervals.merge(intervals1))
            printInterval(interval);

        System.out.println();

        for (int[] interval: mergeIntervals.merge(intervals2))
            printInterval(interval);
    }

    public static void printInterval(int[] interval){
        System.out.print("[" + interval[0] + ", " + interval[1] + "]");
    }

    // 贪心策略，排序之后依次比较相邻的区间
    public int[][] merge(int[][] intervals){
        // 定义一个列表，用来保存合并后的结果
        ArrayList<int[]> result = new ArrayList<>();

        // 1. 对原区间数组，按照下界进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 遍历排序后的区间数组，逐个判断合并
        for (int[] interval: intervals){
            // 记录当前区间的上下界
            int left = interval[0], right = interval[1];

            // 要跟已经合并好的最后一个区间进行判断，先取结果数组的长度
            int size = result.size();

            // 判断是否可以合并，比较当前区间的左边界，和已合并结果最后一个区间的右边界
            if (  size == 0 || left > result.get(size - 1)[1] )
                // 如果是第一个区间，或者超过了最后一个区间的右边界，不能合并，直接添加
                result.add(interval);
            else {
                // 可以合并，确定合并之后的左右边界
                int mergedLeft = result.get(size - 1)[0];
                int mergedRight = Math.max(result.get(size - 1)[1], right);

                // 替换之前合并的最后一个区间
                result.set(size - 1, new int[]{mergedLeft, mergedRight});
            }
        }

        // 转换成数组返回
        return result.toArray(new int[result.size()][]);
    }
}
