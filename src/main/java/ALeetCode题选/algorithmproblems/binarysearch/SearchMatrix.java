package ALeetCode题选.algorithmproblems.binarysearch;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 23;

        SearchMatrix searchMatrix = new SearchMatrix();

        System.out.println(searchMatrix.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target){
        // 先定义m和n
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 定义左右指针，二分查找
        int left = 0;
        int right = m * n - 1;

        while (left <= right){
            int midIndex = (left + right) / 2;
            int midElement = matrix[midIndex/n][midIndex%n];

            if (midElement < target)
                left = midIndex + 1;
            else if(midElement > target)
                right = midIndex - 1;
            else
                return true;
        }

        return false;
    }
}
