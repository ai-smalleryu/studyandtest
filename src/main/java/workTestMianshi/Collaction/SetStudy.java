package workTestMianshi.Collaction;


import org.junit.jupiter.api.Test;

import java.util.*;

public class SetStudy {
    public static void main(String[] args) {

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();

            System.out.println(next);
        }
        Object[] objects = linkedHashSet.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        int siz = 0;
        ArrayList arrayList = new ArrayList<>(linkedHashSet);
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(siz + "数据");
            siz++;
            if (siz == 2) {
                System.out.println("---------------------" + siz);
                Object next = listIterator.next();
                System.out.println(next);
                Object previous = listIterator.previous();
                System.out.println(previous);
                System.out.println("====================");
            }
            //System.out.println(listIterator.next()+"集合信息");


        }

    }

    /*  @Test
      public void testLinklist(){
          List<Integer> list = new LinkedList();
          list.addAll(arrayList);
          Iterator<Integer> iterator1 = list.iterator();
          while (iterator1.hasNext()){
              System.out.println(iterator1.next()+"Linkedlist");
          }
      }*/
    @Test
    public void testQueue() {
        PriorityQueue<Object> objects = new PriorityQueue<>();
        objects.offer("as");
        objects.offer("aa");
        objects.offer("ba");
        objects.offer("axs");
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());

    }

    @Test
    public void testMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("1","23");
        map.put("tom","2");
        map.put("mlko","poi");
        map.put("qwe","123");
        map.put("23","12");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> key = iterator.next();
            String key1 = key.getKey();
            String value = key.getValue();

        }
        map.forEach((k,v)-> System.out.printf("<%s,%s>\n",k,v));
/*       map.put(1,2);
       map.put(2,3);
       map.put(23,12);
       map.put(123,21);
        map.forEach((k, v) -> System.out.printf("<%d, %d>\n", k, v));
       map.forEach((k,v)-> System.out.printf("<%d,%d>\n",k,v));*/

    }
}
