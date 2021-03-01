package ALeetCode题选;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/18 15:07
 * @Version 1.0
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 */
public class LeetCode0389找不同 {
    public static char findTheDifference(String s, String t) {
        String[] split = s.split("");
        String[] split1 = t.split("");
        char c = 0;
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(split1[i])) {
                c = split1[i].charAt(0);
            }
        }

        return 'a';
    }

    public static void main(String[] args) {
        String m = new String("asdasda");
        String n = new String("asdasdae");
        char defauleChar = findDefauleChar2(m, n);
        System.out.println(defauleChar);

    }

    //使用hash 的 k--V
    public static char findDefauleChar(String m, String n) {
        char c = 0;
        String[] split = m.split("");
        String[] split1 = n.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            //map集合中有这个值则value加一，没有新建，并value设为1
            Integer DEFAULE_NUM = map.getOrDefault(split[i], new Integer("0"));
            DEFAULE_NUM = DEFAULE_NUM + 1;
            map.put(split[i], DEFAULE_NUM);
        }
        for (int i = 0; i < split1.length; i++) {
            Integer DEFAULE_NUM = map.getOrDefault(split1[i], new Integer("0"));
            //对map集合中的值做减法
            DEFAULE_NUM = DEFAULE_NUM - 1;
            if (DEFAULE_NUM < 0) {
                //当值小于0的时候就是这个多的字符
                c = split1[i].charAt(0);
            }
            map.put(split1[i], DEFAULE_NUM);
        }
        return c;
    }

    //使用char转数字
    public static char findDefauleChar2(String m, String n) {
        char[] chars = m.toCharArray();
        char[] chars1 = n.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        int sum = 0;
        for (int i = 0; i < chars1.length; i++) {
            sum += chars1[i];
        }
        int dif = sum - result;

        return (char) dif;
    }

    @Test
    public void test() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        Integer orDefault = map.getOrDefault("a", new Integer("0"));
        System.out.println(orDefault);

    }
}
