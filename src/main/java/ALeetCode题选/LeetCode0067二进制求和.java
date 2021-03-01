package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/21 14:42
 * @Version 1.0
 */

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class LeetCode0067二进制求和 {
    //问题，类型最大值问题
    public static String addBinary(String a, String b) {
        long num1 = Integer.parseInt(a);
        long num2 = Integer.parseInt(b);
        long sum = num1 + num2;
        String s = String.valueOf(sum);
        String[] split = s.split("");
        String tag = "0";
        for (int i = split.length - 1; i >= 0; i--) {
            if ("1".equals(tag)) {
                split[i] = String.valueOf(Long.parseLong((split[i])) + 1);
                tag = "0";
            }
            if ("2".equals(split[i])) {
                split[i] = "0";
                tag = "1";
            }
            if ("3".equals(split[i])) {
                split[i] = "1";
                tag = "1";
            }
        }

        String sa = "0".equals(tag) ? "" : "1";
        for (String value : split) {
            sa += value;
        }
        return sa;
    }

    //优化
    public static String addBinary2(String a, String b) {
        int length = a.length();
        int length1 = b.length();
        String sun = "";
        if (length > length1) {
            int i = length - length1;
            for (int j = 0; j < i; j++) {
                sun += "0";
            }
            b=sun+b;
        }
        if (length1 > length) {
            int i = length1 - length;
            for (int j = 0; j < i; j++) {
                sun += "0";
            }
            a=sun+a;
        }
        String[] split1 = a.split("");
        String[] split2 = b.split("");
        int tag = 0;
        for (int i = split1.length-1; i >= 0; i--) {
            int i1 = Integer.parseInt(split1[i]);
            int i2 = Integer.parseInt(split2[i]);
            int num;
            if (tag==1){
                num = i1 + i2 + tag;
                tag=0;
            }else {
                num=i1+i2;
            }

            split1[i]=String.valueOf(num);
            if (num == 2) {
                split1[i] = "0";
                tag = 1;
            }
            if (num == 3) {
                split1[i] = "1";
                tag = 1;
            }
        }

        String sa = tag==0 ? "" : "1";
        System.out.println(sa);
        for (String value : split1) {
            System.out.println("value"+value);
            sa += value;
        }
        return sa;
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";

        String s = addBinary2(a, b);
        System.out.println(s);
    }
}
