package ListMap;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTestStudy {
    @Test
    public void twoStudyHash() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.put(2,3);
        hashMap.put(90,12);
        hashMap.put(43,12);
        hashMap.put(123,34);
        hashMap.put(45,12);
        System.out.println(hashMap.size());
        Set<Integer> integers = hashMap.keySet();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println("===============================================");
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            System.out.println(key+"ll"+hashMap.get(key));
            System.out.println(next);
        }
        Field[] declaredFields = hashMap.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Method capacity = hashMap.getClass().getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println(capacity.invoke(hashMap));

    }

    @Test
    public void testMO(){
        System.out.println(34%5);
        System.out.println(34&5);
    }
}
