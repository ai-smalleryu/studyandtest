package ALeetCode题选.algorithmproblems.trees;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(factorial(5));

        System.out.println(factorialWithTailRecursion(5, 1));
    }

    // 用递归实现求阶乘
    public static int factorial(int n){
        if (n == 0) return 1;
        return factorial(n - 1) * n;
    }

    // 尾递归实现计算阶乘
    public static int factorialWithTailRecursion(int n, int acc){
        if (n == 0) return acc;
        return factorialWithTailRecursion(n - 1, acc * n);
    }
}
