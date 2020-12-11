package designpatterns23.bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class TwoSort {
    public static void main(String[] args) {
        int[] a = {1, 12, 32, 22, 4, 2, 3, 11, 23};
        int i = find5(a, 2);
        System.out.println(i);
    }

    /**
     * 冒泡排序 时间复杂度n^2
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findK(int[] arr, int k) {
        if (k > arr.length) return 0;
        //冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i : arr) {
            if (i % 2 == 1) k--;
            if (k == 0) return i;
        }
        return 0;
    }

    /**
     * 选择 时间复杂度n^2
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findK2(int[] arr, int k) {
        if (k > arr.length) return 0;
        //选择排序
        int minIndex; //设置最小
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;                 // 下标交换
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
            if (i % 2 == 1) k--;
            if (k == 0) return i;
        }
        return 0;
    }

    /**
     * 插入 时间复杂度n^2
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findK3(int[] arr, int k) {
        if (k > arr.length) return 0;
        //插入排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
            if (i % 2 == 1) k--;
            if (k == 0) return i;
        }
        return 0;
    }

    /**
     * 快速 时间复杂度nlog2n
     *
     * @param arr 数组
     * @param l   左
     * @param r   右 第一次时候是数组下标
     * @param k   第几个
     */
    public static int findK4(int[] arr, int l, int r, int k) {
        if (k > arr.length) return 0;
        if (l > r) {
            return 0;
        }
        // min存放第一个作为基数
        int min = arr[l];
        int i = l;
        int j = r;
        while (i != j) {
            // 右边开始往左找，找到值小的数
            while (arr[j] >= min && i < j) {
                j--;
            }

            // 左往右边找，找到值大的数
            while (arr[i] <= min && i < j) {
                i++;
            }

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[l] = arr[i];
        arr[i] = min;

        findK4(arr, l, i - 1, k);
        findK4(arr, i + 1, r, k);
        for (int m : arr) {
            if (m % 2 == 1) k--;
            if (k == 0) {
                return m;
            }
            ;
        }
        return 0;
    }


    /**
     * 快速 时间复杂度nlog2n
     *
     */
   /* public static int findK14(int[] arr, int l, int r) {
        if (l > r) {
            return 0;
        }
        // min存放第一个作为基数
        int min = arr[l];
        int i = l;
        int j = r;
        while (i != j) {
            // 右边开始往左找，找到值小的数
            while (arr[j] >= min && i < j) {
                j--;
            }

            // 左往右边找，找到值大的数
            while (arr[i] <= min && i < j) {
                i++;
            }

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[l] = arr[i];
        arr[i] = min;

        findK14(arr, l, i - 1);
        findK14(arr, i + 1, r);
    }*/

    static int find5(int[] arr, int k) {
        /*PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int i : arr) {
            integers.add(i);

        }*/
        int[] ints = HeapSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        return 0;
    }
    //声明全局变量，用于记录数组array的长度；
    static int len;
    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
