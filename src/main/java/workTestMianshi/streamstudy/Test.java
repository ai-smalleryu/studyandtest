package workTestMianshi.streamstudy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        byte a = 1;
        a += 1;
        System.out.println(a);

        test3();
        test2();
        test1();
        LongStream range = LongStream.range(1, 5);//range左闭右开
        range = LongStream.rangeClosed(1, 5);//闭区间1-5
        range.forEach(System.out::println);
        StringBuilder s = new StringBuilder("yuimao");
        String substring = s.substring(1, 4);
        System.out.println(substring);

    }

    private static void test3() {
        System.out.println("test3======================");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 12, 34, 12);
        Optional<Integer> reduce = integerStream.filter(x -> x < 13).reduce((s, y) -> s + y);
        System.out.println(reduce.get());
        integerStream = Stream.of(1, 2, 3);
        boolean parallel = integerStream.isParallel();
        System.out.println(parallel);
        integerStream = Stream.empty();
        boolean parallel1 = integerStream.isParallel();
        System.out.println(parallel1);
        System.out.println("test3======================");

    }

    //统计元素数
    private static void test2() {
        System.out.println("test2======================");
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> collect =
                availableLocales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));//获得元素数
        collect.forEach((k, v) -> System.out.println(k + "----->" + v));
        System.out.println("test2======================");

    }

    private static void test1() {
        System.out.println("test1======================");
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        // availableLocales.forEach(System.out::println);
        Map<String, List<Locale>> collect = availableLocales.collect(Collectors.groupingBy(Locale::getCountry));//按照国家分组
        collect.forEach((k, v) -> {
                    System.out.print(k + "---->");
                    v.forEach(l -> System.out.print(l + "\t"));
                    System.out.println();
                }
        );
        System.out.println("test1======================");
    }
}
