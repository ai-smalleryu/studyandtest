package ALeetCode题选;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Administrator
 * @PACKAGE_NAME ALeetCode题选
 * @PROJECT_NAME studyandtest
 * @Date: 2021/3/19 11:24
 * @Version 1.0
 */
public class LikeString {
    public static void main(String[] args) {
        String s1 = "sasgf jk";

        String s2 = "adsf jk";
        String[] s3 = s1.split(" ");

        String[] s4 = s2.split(" ");
        int i = s3.length - s4.length;
        if (i != 0) {

        }

        String[] split = s1.split("");
        System.out.println(Arrays.toString(split));
        System.out.println((byte) split[5].charAt(0));

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("2", "12-2");
        map1.put("21", "12-21");
        map1.put("22", "12-22");
        map1.put("1", "12-1");
        map1.put("12", "12-12");
        map1.put("13", "12-13");
        map1.put("15", "12-15");

        map2.put("2", "12-2");
        map2.put("3", "12-3");
        map2.put("21", "12-21");
        map2.put("22", "12-22");
        map2.put("1", "12-1");
        map2.put("12", "12-12");
        map2.put("13", "12-13");
        map2.put("14", "12-14");
        map2.put("aaa", "sd");
        System.out.println("---------------------------------------------------------------------");
        MapDifference<String, String> difference = Maps.difference(map2, map1);
        Map<String, String> stringStringMap = difference.entriesOnlyOnRight();
        Map<String, MapDifference.ValueDifference<String>> stringValueDifferenceMap = difference.entriesDiffering();
        stringValueDifferenceMap.forEach((k, v) -> System.out.println(k + "----llll" + v));
        stringStringMap.forEach((k, y) -> System.out.println(k + "-->" + y));

        System.out.println("=======================");
        String s = "800";
        long m = 800;
        String s5 = String.valueOf(m);
        System.out.println(s.equals(s5));
        System.out.println("-----------------------------------------");
        String sformat="tom.*.*";
        System.out.println(sformat.split("\\.").length+"--++");

        HashMap<String, String> map3 = new HashMap<>();
        map1.forEach((k,v)->{
            if (k.equals("21")){
                map3.put("qwq","as");
            }
            map3.put(k,v);
        });
        map3.forEach((k,v)->{
            System.out.println(k+"-->"+v);
        });
    }
}
