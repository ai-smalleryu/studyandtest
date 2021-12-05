package ALeetCode题选.algorithmproblems.stackandqueue;

import java.util.LinkedList;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid(s1));
        System.out.println(validParentheses.isValid(s2));
        System.out.println(validParentheses.isValid(s3));
        System.out.println(validParentheses.isValid(s4));
        System.out.println(validParentheses.isValid(s5));
    }

    public boolean isValid(String s){
        // 使用一个栈来保存所有出现的左括号
        LinkedList<Character> stack = new LinkedList<>();

        // 遍历字符串中所有字符，如果是左括号就入栈，如果是右括号就出栈（也可能直接返回false）
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            if (c == '(')
                stack.push(')');    // 为了方便比较，直接将匹配的右括号入栈
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else {
                // 如果不是左括号，只能是右括号
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                // 如果不匹配，直接返回false
                if (c != top) return false;
//                else if(stack.isEmpty() || c != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}
