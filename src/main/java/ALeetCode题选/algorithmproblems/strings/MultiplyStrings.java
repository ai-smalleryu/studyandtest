package ALeetCode题选.algorithmproblems.strings;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";

        MultiplyStrings multiplyStrings = new MultiplyStrings();

        System.out.println(multiplyStrings.multiplyStrings(str1, str2));
    }

    public String multiplyStrings1(String num1, String num2){
        // 首先判断特殊情况，有0的话直接返回0
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        // 定义一个String，用来保存结果
        String result = "0";

        // 遍历num2的每一位，逐个与num1相乘
        for (int i = num2.length() - 1; i >= 0; i--){
            // 用一个StringBuffer逆序保存乘积结果
            StringBuffer curResult = new StringBuffer();

            // 取当前num2的第i位数字
            int y = num2.charAt(i) - '0';
            int carry = 0;

            // 1. 结果是逆序，所以需要先补0，补 n2 - 1 - i个
            for (int j = 0; j < num2.length() - 1 - i; j ++){
                curResult.append("0");
            }

            // 2. 遍历num1的每一位数，跟y相乘
            for (int j = num1.length() - 1; j >= 0; j --){
                int x = num1.charAt(j) - '0';

                // 计算当前乘积结果
                int productResult = x * y + carry;

                // 将结果的个位保存到curResult，十位保存到carry
                curResult.append(productResult % 10);
                carry = productResult / 10;
            }

            // 3. 如果还存在进位，继续补在结果后面
            if (carry != 0)
                curResult.append(carry);

            // 4. 已经得到了当前乘积结果，在result基础上进行叠加
            AddStrings addStrings = new AddStrings();
            result = addStrings.addStrings(result, curResult.reverse().toString());
        }
        return result;
    }

    public String multiplyStrings(String num1, String num2) {
        // 首先判断特殊情况，有0的话直接返回0
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        // 用一个长度为 n1 + n2 的数组来保存计算结果
        int[] resultArr = new int[num1.length() + num2.length()];

        // 遍历num1和num2的每一位，进行相乘并叠加
        for (int i = num1.length() - 1; i >= 0; i--){
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--){
                int y = num2.charAt(j) - '0';
                // 计算乘积
                int product = x * y;

                int sum = resultArr[i+j+1] + product;
                resultArr[i+j+1] = sum % 10;
                resultArr[i+j] += sum / 10;
            }
        }

        // 将结果数组转成String输出
        StringBuffer result = new StringBuffer();
        int start = resultArr[0] == 0 ? 1 : 0;

        for (int i = start; i < resultArr.length; i++)
            result.append(resultArr[i]);

        return result.toString();
    }

}
