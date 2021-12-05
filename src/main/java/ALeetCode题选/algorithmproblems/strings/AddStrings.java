package ALeetCode题选.algorithmproblems.strings;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class AddStrings {
    public static void main(String[] args) {
        String str1 = "4567892345537989904325";
        String str2 = "774554686456";

        AddStrings addStrings = new AddStrings();

        System.out.println(addStrings.addStrings(str1, str2));
    }

    public String addStrings(String num1, String num2){
        // 定义一个StringBuffer来保存计算结果
        StringBuffer result = new StringBuffer();

        // 定义指针，初始指向两个字符串的末尾
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 定义一个变量，用于保存进位的数
        int carry = 0;

        // 只要还有数字没有遍历完，就继续叠加
        while (i >= 0 || j >= 0 || carry != 0){
            // 取出当前两数对应位的数字
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;

            // 就和之后的结果，个位就保存到当前位置
            result.append(sum % 10);
            carry = sum / 10;    // 十位保存到进位变量

            // 移动指针，继续遍历下一位
            i --;
            j --;
        }

        return result.reverse().toString();
    }
}
