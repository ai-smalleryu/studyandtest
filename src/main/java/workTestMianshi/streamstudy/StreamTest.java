package workTestMianshi.streamstudy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        test1();
         test2();
//         Stream<String> stringStream = string.filter(w -> w.length() > 4);//filter会产生新的流
//         long count = string.filter(w -> w.length() > 4).count();//过滤
  /*      Stream<String> stringStream = string.map(w -> w + "nkmml");//对流里的元素操作在后拼接字符
        stringStream.forEach(System.out::println);
        System.out.println();


        Stream<Integer> integerStream=Arrays.stream(new Integer[]{1,2,3,4,5,12});
        Stream<String> echos = Stream.generate(() -> "Echo"); //创建无限流

        Stream<BigInteger> integerStream2
                = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));*/
         test4();
        random();
        content();
        stringCount();

        collectTest();

    }

    private static void stringCount() {
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        System.out.println(song.count());
        System.out.println(song.max(String::compareTo));
        System.out.println(song.findFirst());
        System.out.println(song.parallel().findAny());
    }

    private static void collectTest() {
        Stream<String> stream1 = Stream.of("aa", "bb");
        String string = stream1.collect(Collectors.joining());//拼接字符
        System.out.println(string);
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        List<Integer> collect = integerStream.collect(Collectors.toList());//转换为list集合

    }

    public static void random() {
        Random random = new Random();
        int i = random.nextInt(10) + 1;
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        Object[] objects1 = objects.toArray();
        for (Object o : objects1) {
            System.out.println(o);
        }
    }

    //拼接
    public static void content() {
        Stream<String> scon = Stream.concat(letter("tom"), letter("opop"));
        System.out.println(scon);
        scon.forEach(System.out::print);
    }

    public static Stream<String> letter(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, i + 1));
        }
        return list.stream();
    }

    public static void test4() {
        Stream<Double> doubleStream = Stream.generate(() -> Math.random() * 1000).limit(5);
        doubleStream.forEach(System.out::println);
        Stream<Double> doubleStream1 = Stream.generate(Math::random).limit(5);
        doubleStream1.forEach(System.out::println);
    }

    private static void test2() {
        System.out.println("test2+...................");
        Stream<String> string = Stream.of("opop", "lklk", "mkmk", "as", "zxd", "swqwq");
        Stream<String> stringStream = string.flatMap(w -> {
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < w.length(); i++) {
                strings.add(w.substring(i, i + 1));
            }
            return strings.stream();
        });
        //stringStream.forEach(System.out::println);
        stringStream.forEach(c -> System.out.printf("%-2s", c));
    }

    public static void test3() throws InterruptedException {

        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        System.out.println(song.count());//数量
        System.out.println(song.max(String::compareTo));//排序
        System.out.println(song.findFirst());//第一个
        System.out.println(song.parallel().findAny());//任意一个

    }

    private static void test1() throws IOException {
        String s = new String(Files.readAllBytes(Paths.get("alice30.txt")));
        List<String> list = Arrays.asList(s.split("\\PL"));
        long count = 0;
        for (String s1 : list) {
            if (s1.length() > 12) {
                count++;
            }
        }
        System.out.println(count + "-------------------------------");
        long count1 = list.stream().filter(w -> w.length() > 12).count();
        System.out.println(count1 + "+++++++++++++++++");
    }
}
