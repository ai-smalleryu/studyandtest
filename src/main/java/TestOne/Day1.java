package TestOne;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

/*
runnable接口就是一个函数式接口
假设有一个start Thread方法使用该接口作为参数，那么加可以使用lambda进行传参
这样做和Thread类的构造方法传参使用函数式接口没有本质区别
 */
public class Day1 {
    public static void main(String[] args) {
        //开启多线程

        //调用startThread方法，方法的参数是一个接口
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.printf(Thread.currentThread().getName() + "线程启动");
            }
        });
//调用startThread方法方法参数是一个函数式接口可以传递lambda表达式
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程启动2");
        });

        //优化使用lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "启动"));
    }

    public static void startThread(Runnable run) {
        new Thread(run).start();
    }
}


class Day2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello sasd");
            }
        }).start();
        //lambda表达式简化
        new Thread(() -> System.out.println("hello sasd")).start();

    }

    //Function将String转换成Integer
    public static Integer test1(Function<String, Integer> function, String args) {
        return function.apply(args);

    }

}
