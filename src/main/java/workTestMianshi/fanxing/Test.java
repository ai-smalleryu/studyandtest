package workTestMianshi.fanxing;

import java.util.*;

class A {
    public void A1() {
        System.out.println("aaaaa");
    }
}

class B extends A {
    public void B1() {
        System.out.println("bbbbbbbbbbbbbbbbbb");
    }
}

class C extends A {
    public void c() {
        System.out.println("cccccccccccccccccc");

    }
}

public class Test<T extends A> {
    public void Tr() {
        System.out.println("aaaaaaxxx");
    }
}

class sd extends Test<B> {
    public static void main(String[] args) {
        sd sd = new sd();
        sd.Tr();
      /*  HashMap<Object, Object> map = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
      Collection<Integer> c=new LinkedList<>();
        c.add(1);
        c.add(23);
        c.add(12);
        Object[] objects = c.toArray();

        Integer[] i=new Integer[c.size()];
        Integer[] integers = c.toArray(i);
        Iterator<Integer> iterator1 = c.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
//           c.remove(1);
        }
        for (Integer integer : c) {
            System.out.println(integer);
            c.add(23);
        }
    }
}
