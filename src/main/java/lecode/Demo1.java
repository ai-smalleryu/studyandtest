package lecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 镜中湖
 * @version 1.0
 * @date 2020/6/23 11:17
 */
public class Demo1 {

}

class Solution {
    public static void main(String[] args) {

        String s1 = "1110110101";
        String s2 = "1110111011";
        String s = addBinary(s1, s2);
        System.out.println(s);
//        t();
    }

    public static String addBinary(String a, String b) {
        List<Integer> list = null;
        int i = Integer.valueOf(a) + Integer.valueOf(b);
        System.out.println(i);
        String s = String.valueOf(i);
        String[] split = s.split("");
        for (String s1 : split) {
            System.out.println(s1 + "====");
        }
        List<String> strings = Arrays.asList(split);
        System.out.println(strings.toString() + "------------------>");
        for (int j = strings.size() - 1; j >= 0; j--) {
            System.out.println(strings.get(j) + "================================>");
            if (Integer.valueOf(strings.get(j)) >= 2) {
                if ((j - 1) < 0) {
                    list = new ArrayList<>();
                    list.add(1);
                    if (Integer.valueOf(strings.get(j)) > 2) {
                        strings.set(j, 1 + "");
                    } else {
                        strings.set(j, 0 + "");
                    }
                } else {
                    System.out.println(strings.get(j - 1));
                    Integer integer = Integer.valueOf(strings.get(j - 1));
                    Integer m = integer + 1;
                    if (Integer.valueOf(strings.get(j)) > 2) {
                        strings.set(j, 1 + "");
                    } else {
                        strings.set(j, 0 + "");
                    }
                    strings.set(j - 1, m + "");
                }
            }
        }
        for (String string : strings) {
            System.out.println(string + "-----------------------++++++++");
        }
        String s1 = "";
        for (String string : strings) {
            s1 += string;
        }
        if (list != null) {
            s1 = list.get(0) + s1;
        }
        return s1;
    }

    public static String addBinary2(String a, String b) {
        List<Integer> list = null;
        int i = Integer.valueOf(a) + Integer.valueOf(b);
        String s = String.valueOf(i);
        String[] split = s.split("");

        List<String> strings = Arrays.asList(split);
        for (int j = strings.size() - 1; j >= 0; j--) {
            if (Integer.valueOf(strings.get(j)) >= 2) {
                if ((j - 1) < 0) {
                    list = new ArrayList<>();
                    list.add(1);
                    if (Integer.valueOf(strings.get(j)) > 2) {
                        strings.set(j, 1 + "");
                    } else {
                        strings.set(j, 0 + "");
                    }
                } else {
                    Integer integer = Integer.valueOf(strings.get(j - 1));
                    Integer m = integer + 1;
                    if (Integer.valueOf(strings.get(j)) > 2) {
                        strings.set(j, 1 + "");
                    } else {
                        strings.set(j, 0 + "");
                    }
                    strings.set(j - 1, m + "");
                }
            }
        }
        String s1 = "";
        for (String string : strings) {
            s1 += string;
        }
        if (list != null) {
            s1 = list.get(0) + s1;
        }
        return s1;
    }

    public static String addBinary3(String a, String b) {
        String[] split1 = a.split("");
        String[] split2 = b.split("");
        int i1 = split1.length;
        int i2 = split2.length;
        int max;
        if (i1 - i2 >= 0) {
            max = 1;
        } else {
            max = 0;
        }
        if (max==1){

        }
        List<Integer> list = null;
        int i = Integer.valueOf(a) + Integer.valueOf(b);
        String s = String.valueOf(i);
        String[] split = s.split("");

        List<String> strings = Arrays.asList(split);
        for (int j = strings.size() - 1; j >= 0; j--) {
            if (Integer.valueOf(strings.get(j)) >= 2) {
                if ((j - 1) < 0) {
                    list = new ArrayList<>();
                    list.add(1);
                    if (Integer.valueOf(strings.get(j)) > 2) {
                        strings.set(j, 1 + "");
                    } else {
                        strings.set(j, 0 + "");
                    }
                } else {
                    Integer integer = Integer.valueOf(strings.get(j - 1));
                    Integer m = integer + 1;
                    if (Integer.valueOf(strings.get(j)) > 2) {
                        strings.set(j, 1 + "");
                    } else {
                        strings.set(j, 0 + "");
                    }
                    strings.set(j - 1, m + "");
                }
            }
        }
        String s1 = "";
        for (String string : strings) {
            s1 += string;
        }
        if (list != null) {
            s1 = list.get(0) + s1;
        }
        return s1;
    }

    public static void t() {
        String s = "101020101";
        String[] split = s.split("");
        for (String s1 : split) {
            System.out.println(s1 + "====");
        }
    }

}
