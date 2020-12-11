package ImpLambdaTestday01;

import workTestMianshi.lambda.TTestStream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;

public class FunctionImplement {
    public static void main(String[] args) {
        IntToDoubleFunction in=(i)->{
            if (i>10)return 10L;
            else return 12L;
        };
        double v = in.applyAsDouble(3);
        System.out.println(Double.toHexString(v));
        int[] i={1,2,3,4};
        Arrays.stream(i).forEach(System.out::println);

    }
}
