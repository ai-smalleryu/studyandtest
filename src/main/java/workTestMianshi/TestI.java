package workTestMianshi;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestI {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i);
        int j = i++;
        System.out.println(j);
        System.out.println("值" + i);
        int k = i + ++i * i++;
        System.out.println(k);
        System.out.println(i);

    }
    static  ArrayList<Integer> list = new ArrayList<>();

    static {

        list.add(1);
        list.add(11);
        list.add(2);
        list.add(12);
        list.add(3);
        list.add(13);
        list.add(4);
        list.add(4);
        list.add(15);
    }
    @Test
    public void test() {
        Set<Integer> integers = new HashSet<>();


        Set<Integer> collect = list.stream().collect(Collectors.toSet());
        collect.stream().filter(a -> a > 10).forEach(a -> integers.add(a));
        for (Integer integer : integers) {
            System.out.println(integer + "=====");
        }

        for (Integer integer : collect) {
            System.out.println(integer + "--->");
        }
    }

    @Test
    public void testmap() {
        HashMap<Integer, String> map  = new HashMap<>();
        map.put(1, "12");
        map.put(12, "13");
        map.put(11, "13");
        map.put(2, "13");
        map.put(4, "12");
        map.put(5, "5");
        map.forEach((k,v)-> System.out.println(k+"-:-"+v));

    }

    @Test
    public void testlist(){
        Optional<Integer> first = list.stream().findAny();
        if (first.isPresent()){
            System.out.println(first.get());
        }
    }
}
