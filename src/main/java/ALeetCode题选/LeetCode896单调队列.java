package ALeetCode题选;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 示例
 * 输入：[1,2,2,3]
 * 输出：true
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 */
public class LeetCode896单调队列 {
    public static void main(String[] args) {
        int[] a = new int[]{6,5,4,4};
        boolean monotonic = test(a);
        System.out.println(monotonic);
    }

    public static boolean isMonotonic(int[] A) {
        int j = 0;
        int m = 0;
        int num = 1;
        for (int i = 0; i < A.length - 1; i++) {
            num++;
            if (A[i + 1] > A[i]) {
                j++;
            } else if (A[i + 1] < A[i]) {
                m++;
            } else {
                if (m > 0) {
                    m++;
                } else if (j > 0) {
                    j++;
                } else if (m == 0 && j == 0) {
                    m = 0;
                    j = 0;
                } else {
                    return false;
                }
            }
            while (num == A.length) {
                return m == 0 || j == 0;
            }
        }
        return false;
    }

    public boolean isMonotonic2(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
    public static boolean isMonotonic3(int[] a) {
        return check(a, true) || check(a, false);
    }
    static  boolean check(int[] a, boolean flag) {
        for (int i = 0; i < a.length - 1; i++) {
            if (flag) {
                if (a[i] > a[i + 1]) {
                    return false;
                }
            } else {
                if (a[i] < a[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 统计「二次循环」的访问次数
    static int cnt;
    public static boolean isMonotonic4(int[] a) {
        cnt = 0;
        // 这里不直接写成「短路与」进行返回，确保两个循环都会被执行
        boolean t = check2(a, true), u = check(a, false);
        System.out.println(cnt);
        return t || u;
    }
    static boolean check2(int[] a, boolean flag) {
        for (int i = 0; i < a.length - 1; i++) {
            if (flag) {
                if (getVal(a, i) > getVal(a, i + 1)) {
                    return false;
                }
            } else {
                if (getVal(a, i) < getVal(a, i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
   static int getVal(int[] a, int idx) {
        cnt++;
        return a[idx];
    }
//测试中
    static boolean test(int[] A){
        int sum=1;
        for (int i = 0; i < A.length-1; i++) {
           int num= A[i+1]-A[i];
           if (num==0) {
               num=1;
           }
           sum=sum*num;
           if (sum<0) {
               return false;
           }
        }
        return true;
    }
}
