package ALeetCode题选.algorithmproblems.sidingwindows;

import java.security.cert.PKIXReason;
import java.util.HashMap;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String s1 = "a";
        String t1 = "a";

        String s2 = "a";
        String t2 = "aa";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        System.out.println(minimumWindowSubstring.minWindow(s, t));
        System.out.println(minimumWindowSubstring.minWindow(s1, t1));
        System.out.println(minimumWindowSubstring.minWindow(s2, t2));
    }

    // 1. 暴力法
    public String minWindow1(String s, String t){
        // 定义一个最小字串，用于结果返回
        String minSubString = "";

        HashMap<Character, Integer> tCharFrequency = new HashMap<>();

        // 统计t中所有字母出现的频次
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            int count = tCharFrequency.getOrDefault(c, 0);
            tCharFrequency.put(c, count + 1);
        }

        // 遍历s的所有字串(以i为起始位置，以j为结束位置，不包含j)，并统计每个字母出现的频次
        for (int i = 0; i < s.length(); i++){
            for (int j = i + t.length(); j <= s.length(); j++){
                // 统计字串中所有字母出现的频次
                HashMap<Character, Integer> subStringCharFrequency = new HashMap<>();
                for (int k = i; k < j; k++){
                    char c = s.charAt(k);
                    int count = subStringCharFrequency.getOrDefault(c, 0);
                    subStringCharFrequency.put(c, count + 1);
                }

                // 对比t中频次和s字串中频次，如果满足要求（t中频次<=s字串中频次）,就是覆盖字串；再去找最小的
                if (check(tCharFrequency, subStringCharFrequency) &&
                        (minSubString.equals("") || j - i < minSubString.length() ) ){
                    minSubString = s.substring(i, j);
                }
            }
        }

        return minSubString;
    }

    // 定义一个方法，用来检查当前字串是否满足覆盖t的要求
    private boolean check(HashMap<Character, Integer> tFreq, HashMap<Character, Integer> sSubStringFreq){
        // 遍历t的hash表中所有字母，判断s字串中出现的次数是否小于它
        for (char c: tFreq.keySet()){
            if ( sSubStringFreq.getOrDefault(c, 0) < tFreq.get(c) )
                return false;
        }

        return true;
    }

    // 2. 滑动窗口
    public String minWindow2(String s, String t) {
        // 定义一个最小字串，用于结果返回
        String minSubString = "";

        HashMap<Character, Integer> tCharFrequency = new HashMap<>();

        // 统计t中所有字母出现的频次
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tCharFrequency.getOrDefault(c, 0);
            tCharFrequency.put(c, count + 1);
        }

        // 设置双指针，用来表示窗口的起始和结束位置，左闭右开
        int lp = 0, rp = t.length();
        while (rp <= s.length()){
            // 统计字串中所有字母出现的频次
            HashMap<Character, Integer> subStringCharFrequency = new HashMap<>();
            for (int k = lp; k < rp; k++){
                char c = s.charAt(k);
                int count = subStringCharFrequency.getOrDefault(c, 0);
                subStringCharFrequency.put(c, count + 1);
            }

            // 对比t中频次和s字串中频次，如果满足要求（t中频次<=s字串中频次）,就是覆盖字串；再去找最小的
            if (check(tCharFrequency, subStringCharFrequency)){
                if (minSubString.equals("") || rp - lp < minSubString.length() ){
                    minSubString = s.substring(lp, rp);
                }
                // 如果找到了覆盖字串（可行解），就移动左指针，寻找局部最优解
                lp ++;
            } else
                // 如果不满足要求，那么就移动右指针，继续寻找可行解
                rp ++;
        }

        return minSubString;
    }

    // 3. 共用HashMap的优化
    public String minWindow3(String s, String t) {
        // 定义一个最小字串，用于结果返回
        String minSubString = "";

        HashMap<Character, Integer> tCharFrequency = new HashMap<>();

        // 统计t中所有字母出现的频次
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tCharFrequency.getOrDefault(c, 0);
            tCharFrequency.put(c, count + 1);
        }

        // 统计子串中所有字母出现的频次
        HashMap<Character, Integer> subStringCharFrequency = new HashMap<>();

        // 设置双指针，用来表示窗口的起始和结束位置，左闭右开
        int lp = 0, rp = 1;
        while (rp <= s.length()){

            // 判断当前新增的字符，如果在t中，那么就在字串的HashMap中频次加1
            char newChar = s.charAt(rp - 1);
            if (tCharFrequency.containsKey(newChar)){
                subStringCharFrequency.put(newChar, subStringCharFrequency.getOrDefault(newChar, 0) + 1);
            }

            // 对比t中频次和s字串中频次，如果满足要求（t中频次<=s字串中频次）,就是覆盖字串；再去找最小的
            while ( lp < rp && check(tCharFrequency, subStringCharFrequency)){
                if (minSubString.equals("") || rp - lp < minSubString.length() ){
                    minSubString = s.substring(lp, rp);
                }

                // 删除的字母如果出现在t中，频次减1
                char removedChar = s.charAt(lp);
                if (tCharFrequency.containsKey(removedChar)){
                    subStringCharFrequency.put(removedChar, subStringCharFrequency.getOrDefault(removedChar, 0) - 1);
                }

                // 如果找到了覆盖字串（可行解），就移动左指针，寻找局部最优解
                lp ++;
            }
            // 如果不满足要求，那么就移动右指针，继续寻找可行解
            rp ++;
        }

        return minSubString;
    }

    // 4. 利用汉明距离做进一步优化
    public String minWindow(String s, String t) {
        // 定义一个最小字串，用于结果返回
        String minSubString = "";

        HashMap<Character, Integer> tCharFrequency = new HashMap<>();

        // 统计t中所有字母出现的频次
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tCharFrequency.getOrDefault(c, 0);
            tCharFrequency.put(c, count + 1);
        }

        // 统计子串中所有字母出现的频次
        HashMap<Character, Integer> subStringCharFrequency = new HashMap<>();

        // 借鉴汉明距离，这代表了字串中字母对于覆盖t的“贡献度”
        int charCount = 0;

        // 设置双指针，用来表示窗口的起始和结束位置，左闭右开
        int lp = 0, rp = 1;
        while (rp <= s.length()){

            // 判断当前新增的字符，如果在t中，那么就在字串的HashMap中频次加1
            char newChar = s.charAt(rp - 1);
            if (tCharFrequency.containsKey(newChar)){
                subStringCharFrequency.put(newChar, subStringCharFrequency.getOrDefault(newChar, 0) + 1);
                // 如果当前字母之前在字串中的频次不够t中的频次，说明有贡献
                if (subStringCharFrequency.get(newChar) <= tCharFrequency.get(newChar))
                    charCount ++;
            }

            // 对比t中频次和s字串中频次，如果满足要求（t中频次<=s字串中频次）,就是覆盖字串；再去找最小的
            while ( lp < rp && charCount == t.length()){
                if (minSubString.equals("") || rp - lp < minSubString.length() ){
                    minSubString = s.substring(lp, rp);
                }

                // 删除的字母如果出现在t中，频次减1
                char removedChar = s.charAt(lp);
                if (tCharFrequency.containsKey(removedChar)){
                    subStringCharFrequency.put(removedChar, subStringCharFrequency.getOrDefault(removedChar, 0) - 1);

                    // 判断删除的字母在字串中出现的频次原本已经够了，现在不够的话，说明删掉的字母有贡献
                    if (subStringCharFrequency.get(removedChar) < tCharFrequency.get(removedChar))
                        charCount --;
                }

                // 如果找到了覆盖字串（可行解），就移动左指针，寻找局部最优解
                lp ++;
            }
            // 如果不满足要求，那么就移动右指针，继续寻找可行解
            rp ++;
        }

        return minSubString;
    }
}
