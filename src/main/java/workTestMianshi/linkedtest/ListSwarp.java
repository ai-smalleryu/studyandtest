package workTestMianshi.linkedtest;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ListSwarp {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(21);
        integers.add(3);
        integers.add(31);
        Integer[] a = new Integer[integers.size()];
        //collection中链转数组
        Integer[] integers2 = integers.toArray(a);
        System.out.println(integers2.toString());
        Integer[] integers1 = integers.toArray(new Integer[integers.size()]);
        List<Integer> list = Arrays.asList(integers1);//数组转集合
        System.out.println("-----------------");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Collections.unmodifiableList(list);
        System.out.println(list2.get(2));

        System.out.println("==========");
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(145);
        System.out.println(set.ceiling(13));//返回大于等于i'的数
        System.out.println(set.floor(13));//大于等于
        System.out.println(set.lower(13));//小于
        System.out.println(set.higher(13));//大于
    }

}
