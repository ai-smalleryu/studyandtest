package workTestMianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1);
        Circle circle2 = new Circle(2);
        System.out.println(circle1 + "---------" + circle2);
        swap1(circle1, circle2);
        System.out.println(circle1 + "---------" + circle2);
        System.out.println("After swap1: circle1 = " +
                circle1.radius + " circle2 = " + circle2.radius);
        swap2(circle1, circle2);
        System.out.println(circle1 + "---------" + circle2);
        System.out.println("After swap1: circle1 = " +
                circle1.radius + " circle2 = " + circle2.radius);
    }

    public static void swap1(Circle x, Circle y) {
        Circle temp = x;
        x = y;
        y = temp;
    }

    public static void swap2(Circle x, Circle y) {
        double temp = x.radius;
        x.radius = y.radius;
        y.radius = temp;
    }
}

class Circle {
    double radius;

    public Circle(double newRadius) {
        this.radius = newRadius;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(12);
        list.add(1312);
        list.add(221);
        list.add(122);
        list.add(10);
        list.add(11);
        for (Integer integer : list) {

            System.out.println(integer);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        System.out.println("-------------------------------------------");
        list.remove(1);
        System.out.println(list);
    }
}

class inary二进制 {
    static int MAXIMUM_CAPACITY = 1 << 30;

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static int testCap(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        int cap = ((initialCapacity >= (MAXIMUM_CAPACITY >>> 1)) ?
                MAXIMUM_CAPACITY :
                tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
        return cap;
    }

    public static void main(String[] args) {
        int i1 = testCap(11);

        int i = tableSizeFor(i1);
        System.out.println(i);


    }
}
