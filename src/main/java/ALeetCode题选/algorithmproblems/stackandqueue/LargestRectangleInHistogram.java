package ALeetCode题选.algorithmproblems.stackandqueue;

import java.util.Stack;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights1 = {2,1,5,6,2,3};
        int[] heights2 = {2, 4};

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();

        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights1));
        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights2));
    }

    // 1. 暴力法，遍历所有可能的左右边界
    public int largestRectangleArea1(int[] heights){
        int n = heights.length;

        // 用一个变量保存结果
        int largestArea = 0;

        // 循环遍历数组，以数组的索引作为左边界
        for (int left = 0; left < n; left ++){
            // 用一个变量来保存当前能取到的最大高度，就是最矮的那个柱子高度
            int currHeight = heights[left];

            // 循环遍历数组，作为右边界
            for (int right = left; right < n; right ++){
                // 更新当前的高度
                if (heights[right] < currHeight) {
                    currHeight = heights[right];
                }
//                currHeight = (heights[right] < currHeight) ? heights[right] : currHeight;
                // 计算当前面积
                int currArea = (right - left + 1) * currHeight;
                // 更新当前最大面积
                if (currArea > largestArea) {
                    largestArea = currArea;
                }
            }
        }

        return largestArea;
    }

    // 2. 双指针法（遍历所有可能的高度）
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;

        // 用一个变量保存结果
        int largestArea = 0;

        // 循环遍历所有柱子，以当前柱子作为最矮的那个，高度固定
        for (int i = 0; i < n; i++){
            // 保存当前高度
            int height = heights[i];

            // 定义左右指针
            int left = i - 1, right = i + 1;

            // 寻找左边界
            while (left >= 0 && heights[left] >= height ) {
                left --;
            }

            // 寻找右边界
            while (right < n && heights[right] >= height ) {
                right ++;
            }

            // 得到当前的宽度，计算面积
            int width = right - left - 1;
            int currArea = height * width;

            largestArea = currArea > largestArea ? currArea : largestArea;
        }

        return largestArea;
    }

    // 3. 双指针改进，跳过那些不必要的比较
    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;

        // 用一个变量保存结果
        int largestArea = 0;

        // 定义两个数组，用来保存每个元素对应的左右边界
        int[] lefts = new int[n];
        int[] rights = new int[n];

        // 循环遍历所有柱子，以当前柱子高度作为矩形最大高度
        // 首先确定左边界
        for (int i = 0; i < n; i ++){
            int height = heights[i];

            // 定义左指针
            int left = i - 1;

            // 寻找左边界
            while (left >= 0 && heights[left] >= height) {
                left = lefts[left];    // 如果左边的柱子比当前柱子高，就跳到它的左边界柱子再比较
            }

            // 将左边界保存到lefts数组
            lefts[i] = left;
        }

        // 从右到左遍历数组，确定右边界
        for (int i = n - 1; i >= 0; i --){
            int height = heights[i];

            // 定义右指针
            int right = i + 1;

            // 寻找右边界
            while (right < n && heights[right] >= height)
                right = rights[right];    // 如果右边的柱子比当前柱子高，就跳到它的右边界柱子再比较

            // 将右边界保存到rights数组
            rights[i] = right;
        }

        // 所有柱子的左右边界已经确定，遍历计算最大面积
        for (int i = 0; i < n ; i ++){
            int currArea = (rights[i] - lefts[i] - 1) * heights[i];
            if (currArea > largestArea)  largestArea = currArea;
        }

        return largestArea;
    }

    // 4. 单调栈
    public int largestRectangleArea4(int[] heights) {
        int n = heights.length;

        // 用一个变量保存结果
        int largestArea = 0;

        // 定义两个数组，用来保存每个元素对应的左右边界
        int[] lefts = new int[n];
        int[] rights = new int[n];

        // 定义一个栈，保存元素的索引信息
        Stack<Integer> stack = new Stack<>();

        // 流程类似，遍历所有柱子，寻找左右边界
        for (int i = 0; i < n; i ++){
            int height = heights[i];
            // 如果当前栈顶元素比当前高度大，就直接弹栈；一直找到比当前小的元素，就是左边界
            while (!stack.isEmpty() && heights[stack.peek()] >= height)
                stack.pop();

            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 清空栈
        stack.clear();

        for (int i = n - 1; i >= 0; i --){
            int height = heights[i];
            // 如果当前栈顶元素比当前高度大，就直接弹栈；一直找到比当前小的元素，就是左边界
            while (!stack.isEmpty() && heights[stack.peek()] >= height)
                stack.pop();

            rights[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 所有柱子的左右边界已经确定，遍历计算最大面积
        for (int i = 0; i < n ; i ++){
            int currArea = (rights[i] - lefts[i] - 1) * heights[i];
            if (currArea > largestArea)  largestArea = currArea;
        }

        return largestArea;
    }

    // 5. 单调栈优化
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // 用一个变量保存结果
        int largestArea = 0;

        // 定义两个数组，用来保存每个元素对应的左右边界
        int[] lefts = new int[n];
        int[] rights = new int[n];

        // 初始化让右边界都为n，避免不弹栈的情况
        for (int i = 0; i < n; i++) rights[i] = n;

        // 定义一个栈，保存元素的索引信息
        Stack<Integer> stack = new Stack<>();

        // 流程类似，遍历所有柱子，寻找左右边界
        for (int i = 0; i < n; i ++){
            int height = heights[i];
            // 如果当前栈顶元素比当前高度大，就直接弹栈；一直找到比当前小的元素，就是左边界
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                // 当前栈顶元素比当前柱子高，可以确定右边界就是当前柱子
                rights[stack.peek()] = i;
                stack.pop();
            }

            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 所有柱子的左右边界已经确定，遍历计算最大面积
        for (int i = 0; i < n ; i ++){
            int currArea = (rights[i] - lefts[i] - 1) * heights[i];
            if (currArea > largestArea)  largestArea = currArea;
        }

        return largestArea;
    }
}
