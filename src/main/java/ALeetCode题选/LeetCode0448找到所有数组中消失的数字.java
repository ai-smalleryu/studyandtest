package ALeetCode题选;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class LeetCode0448找到所有数组中消失的数字 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers3(nums);


    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] vis = new int[n + 1];
        for (int num : nums) {
            vis[num] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set1.add(nums[i]);
            set2.add(i + 1);
        }
        Set difference = Sets.difference(set2, set1);
        List<Integer> list = new ArrayList<Integer>(difference);
        System.out.println(list);
        return list;
    }

    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set1.add(nums[i]);
            set2.add(i + 1);
        }
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            set2.remove(next);
        }
        List<Integer> list = new ArrayList<Integer>(set2);
        System.out.println(list);
        return list;
    }

    public List<Integer> findDisappearedNumbers4(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int[] fz = new int[len];
        //记录出现的数字
        for (int t : nums) {
            if (t >= 1 && t <= len) {
                if (fz[t - 1] == 0) {
                    fz[t - 1] = 1;  //不为0表示出现过，即标记
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (fz[i] == 0)  //未被标记的即未出现过
            {
                res.add(i + 1);
            }
        }
        return res;
    }
}
