package testOrm;

import java.util.*;

/*

 */
public class MapTest {

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.put(3,2);
        hashMap.put(4,21);
        hashMap.put(5,22);
        hashMap.put(12,52);
        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        for (Map.Entry<Object,Object> map:hashMap.entrySet())
        {
            System.out.println(map.getKey()+"Values"+map.getValue());
        }
        Set<Object> objects = hashMap.keySet();
        for (Object o:hashMap.keySet()
             ) {
            System.out.println("key"+o+"Values"+hashMap.get(o));

        }

        System.out.println(hashMap.get(1));

    }
}
