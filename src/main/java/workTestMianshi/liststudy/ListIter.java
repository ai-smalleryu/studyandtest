package workTestMianshi.liststudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIter {
    public static void test1() {
        List<Integer> obj = new ArrayList<>();
        obj.add(1);
        obj.add(12);
        obj.add(13);
        obj.add(111);
        obj.add(14);
        obj.add(16);
        Iterator<Integer> iterator = obj.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
