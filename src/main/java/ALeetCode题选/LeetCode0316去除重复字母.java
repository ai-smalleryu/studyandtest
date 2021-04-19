package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/21 10:40
 * @Version 1.0
 */


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 */
public class LeetCode0316去除重复字母 {
    Map<String, Integer> map = new LinkedHashMap<String, Integer>();

    public String removeDuplicateLetters(String s) {
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            Integer orDefault = map.getOrDefault(split[i], new Integer(-1));
            if (orDefault!=-1){

            }
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Integer>  map=new HashMap<>();
        map.put("a",122);
        map.put("saa",31);
        map.put("ad",12);
        Integer a = map.getOrDefault("a1", new Integer(0));
        System.out.println(a);
    }
}
