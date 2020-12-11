package workTestMianshi.streamstudy;


import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//        System.out.println(integers.stream().filter(q -> q > 2).reduce(0, (x, y) -> x + y));
        integers.stream().skip(1).forEach(System.out::println);
    }
}
