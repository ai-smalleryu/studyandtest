package ALeetCode题选;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2021/2/26 19:01
 * @Version 1.0
 */
public class TwoFind {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            int minIndex = startIndex + (endIndex - startIndex) / 2;
            if (target == nums[minIndex]) {
                return minIndex;
            } else if (target < nums[minIndex]) {
                endIndex = minIndex - 1;
            } else {
                startIndex = minIndex + 1;
            }
        }
        return -1;
    }

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public int search2(int[] nums, int target) {
        return search1(nums, 0, nums.length - 1, target);
    }
    private int search1(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search1(nums, l, mid - 1, target);
        } else {
            return search1(nums, mid + 1, r, target);
        }
    }
}
class T{
    public static void main(String[] args) {
        Map<String,Object> tt= new HashMap<String,Object>();
        int a = 187117;
        tt.put("aa",a);
        try {
            Object a2=tt.get("aa");
            System.out.println(a2);
            String s=(String)a2;
            long b = (long) tt.get("aa");
//            long b = Long.valueOf(String.valueOf(tt.get("aa"))).longValue();
            System.out.println(b);
        }catch (Exception e ) {
            e.printStackTrace();
        }
        }
}