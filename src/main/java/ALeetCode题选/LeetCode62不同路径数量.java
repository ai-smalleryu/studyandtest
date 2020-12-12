package ALeetCode题选;

import java.util.concurrent.Callable;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class LeetCode62不同路径数量 {

    ///////////////方法问题，数字过大使用int还是double都会超出数字的索引
    public static int num(int i) {
        int n = 0;
        if (i == 1) {
            return 1;
        } else {
            return i * num(i - 1);
        }
    }


    public static void main(String[] args) {
  /*      int num = num(5);
        System.out.println(num);
        System.out.println("-------------------------");
        int c = C1(15, 15);
        System.out.println(c);

        System.out.println("--------------------------->");
        int i = uniquePaths(15, 15);
        System.out.println(i);*/
        System.out.println(Integer.MAX_VALUE);
        System.out.println(CN(18, 9));
    }

    //阶乘计算

    /**
     * 数学阶乘 注意m一定是大于n的
     * @param m 数学C的下标
     * @param n 数学C的上标
     * @return
     */
    public static int C1(int m ,int n){
        m=m+n-2;
        n=n-1;
        if (n==0) {
            return 1;
        }
        return CN(m,n)/num(n);
    }

    /**
     *
     * @param m 数学C的下标
     * @param n 数学C的上标 这里只代表次数
     * @return
     */
    public static int CN(int m ,int n){
        double result=m;
        if (n==1) {
            return (int) result;
        }
        while ((--n)>0){
            m--;
            result=result*m;
        }
        return (int) result;
    }


    public static int uniquePaths(int m, int n) {
        int N = n + m - 2;
        double res = 1;
        for (int i = 1; i < m; i++) {
            res = res * (N - (m - 1) + i) / i;
        }
        return (int) res;
    }
    ///////////////上面的解法数字索引容易超出最大值，不建议采用///////////////////////

}
