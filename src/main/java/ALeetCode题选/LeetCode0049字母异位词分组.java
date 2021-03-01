package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/14 16:20
 * @Version 1.0
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class LeetCode0049字母异位词分组 {
    public static void main(String[] args) {
        char[] c = new char[]{'a', 'c'};
        char[] c2 = new char[]{'a', 'c'};
        System.out.println(Arrays.equals(c, c2));
        System.out.println("-------------------------------------------------------------------------------------------");
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(strings);
        List<List<String>> lists = groupAnagrams(strings);
        lists.forEach(stringList -> {
            stringList.forEach(System.out::println);
        });

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //集合遍历
        for (String str : strs) {
            //转换为char数据
            char[] array = str.toCharArray();
            //对其进行排序
            Arrays.sort(array);
            //把排序好的数据作为key值放入map集合
            String key = new String(array);

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            System.out.println(list);
            //将已经有key的数据拿出来，然后增加新的list值
            list.add(str);
            //从新存储map集合  这时候每一个value对应的就是一个完整list集合
            map.put(key, list);
        }
        //只需要返回一个value值，每一个
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // str -> intstream -> sort -> collect by StringBuilder
        return new ArrayList<>(
                Arrays.stream(strs).
                        collect(
                                Collectors.groupingBy(
                                        str -> str.chars().
                                                sorted().
                                                collect(
                                                        StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append
                                                ).toString()
                                )
                        ).
                        values());
    }


}
