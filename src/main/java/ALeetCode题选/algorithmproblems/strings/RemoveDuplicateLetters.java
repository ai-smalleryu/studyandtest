package ALeetCode题选.algorithmproblems.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s1 = "bcabc";
        String s2 = "cbacdcbc";

        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();

        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s1));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s2));
    }

    // 1. 贪心策略，每个字符逐个处理
    public String removeDuplicateLetters1(String s){
        // 递归的基准情形
        if (s.length() == 0) return "";

        // 用一个变量，表示当前已找到的能够放到最左端的最小字母的索引位置
        int curMinLetterPosition = 0;

        // 遍历字符串，寻找最左侧的字母
        for (int i = 0; i < s.length(); i++){
            // 两个条件：首先需要当前字母比已经找到的左端字母小
            if (s.charAt(i) < s.charAt(curMinLetterPosition)){
                // 接着需要判断i之前的所有字母，都会在i位置之后重复出现

                // 引入一个布尔变量，用来表示i位置的字母是否可以替换之前找到的p
                boolean isReplaceable = true;
                for (int j = curMinLetterPosition; j < i; j++){
                    // 引入一个布尔变量，用来表示j位置的字母是否在后面重复出现
                    boolean isDuplicated = false;
                    for(int k = i; k < s.length(); k++){
                        if (s.charAt(k) == s.charAt(j)){
                            isDuplicated = true;
                            break;    // 跳出内层循环，
                        }
                    }

                    // 循环结束，判断是否break出来的
                    if (!isDuplicated){
                        isReplaceable = false;
                        break;
                    }
                }

                // 循环结束，判断是否break出来
                if (isReplaceable)
                    curMinLetterPosition = i;
            }
        }

        // 外层循环结束，找到了当前最左端字母，递归调用
        String subStr = s.substring(curMinLetterPosition + 1).replaceAll(""+s.charAt(curMinLetterPosition), "");
        return s.charAt(curMinLetterPosition) + removeDuplicateLetters1(subStr);
    }

    // 2. 贪心策略优化
    public String removeDuplicateLetters2(String s) {
        // 递归的基准情形
        if (s.length() == 0) return "";

        // 用一个变量，表示当前已找到的能够放到最左端的最小字母的索引位置
        int curMinLetterPosition = 0;

        // 定义一个count数组，保存每个字母在s中出现的次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c - 'a'] ++;
        }

        // 遍历字符串，寻找当前能够放到最左端的最小字母
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) < s.charAt(curMinLetterPosition)){
                curMinLetterPosition = i;
            }

            count[s.charAt(i) - 'a'] --;    // 当前字母出现一次，对应次数减1
            // 如果当前字母count已经减为零，说明之后不会再重复出现，不需要继续遍历后面的字母了
            if(count[s.charAt(i) - 'a'] == 0)
                break;
        }

        // 外层循环结束，找到了当前最左端字母，递归调用
        String subStr = s.substring(curMinLetterPosition + 1).replaceAll(""+s.charAt(curMinLetterPosition), "");
        return s.charAt(curMinLetterPosition) + removeDuplicateLetters2(subStr);
    }

    // 3. 贪心策略使用栈进行优化
    public String removeDuplicateLetters(String s) {
        // 定义一个栈，用来保存结果
        Stack<Character> stack = new Stack<>();

        // 用一个HashMap保存每个字母最后出现的索引位置
        HashMap<Character, Integer> last_occur = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            last_occur.put(s.charAt(i), i);

        // 用一个HashSet保存某个字母是否在栈中出现
        HashSet<Character> seen_char = new HashSet<>();

        // 遍历字符串，依次入栈
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            // 需要保证在栈中没有出现过
            if (!seen_char.contains(c)){
                // 入栈之前，判断之前的栈顶元素是否要弹出
                while (!stack.isEmpty() && c < stack.peek() && last_occur.get(stack.peek()) > i){
                    seen_char.remove(stack.pop());
                }

                stack.push(c);
                seen_char.add(c);
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (char c: stack){
            stringBuffer.append(c);
        }

        return stringBuffer.toString();
    }
}
