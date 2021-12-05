package ALeetCode题选.algorithmproblems.binarysearch;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {2,3,4,5,7,8,9,12,15};
        int key = 15;

        int keyIndex = binarySearch(a, key, 0, a.length - 1);

        System.out.println(keyIndex);
    }

    public static int binarySearch(int[] a, int key){
        // 双指针法，定义查找的范围
        int low = 0;
        int high = a.length - 1;

        // 排除特殊情况，加快运行速度
        if (key < a[low] || key > a[high])
            return -1;

        // 只要两个指针不相遇，那么就一直选取中间位置进行判断
        while ( low <= high ){
            int mid = (low + high) / 2;
            if (a[mid] < key)
                low = mid + 1;
            else if (a[mid] > key)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    // 递归实现
    public static int binarySearch(int[] a, int key, int fromIndex, int toIndex){
        // 排除特殊情况
        if (key < a[fromIndex] || key > a[toIndex] || fromIndex > toIndex)
            return -1;

        int mid = (fromIndex + toIndex) / 2;

        if (a[mid] < key)
            return binarySearch(a, key, mid + 1, toIndex);
        else if (a[mid] > key)
            return binarySearch(a, key, fromIndex, mid - 1);
        else
            return mid;
    }
}
