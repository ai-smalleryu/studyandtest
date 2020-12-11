package ListMap;

import java.util.*;

public class MapKey {
    static HashMap<Object, Object> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put(1, "name");
        hashMap.put("na", "tackew");
        hashMap.put("tom", "123");
        hashMap.put(1121, "12");
        hashMap.put(12, 34);
    }

    //keyset
    public static void getkey1() {
        Set<Object> objects = hashMap.keySet();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    //通过iterator的方法
    public static void getkey2() {
        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }
    }

    //推荐使用的方法 使用返回的set集合
    public static void getkey3() {
        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey());
        }
    }    //推荐使用的方法 使用返回的set集合
    public static void getkey4() {
        boolean b = hashMap.containsValue(34);
        System.out.println(b);
    }

    public static void main(String[] args) {
        getkey4();
    }
}
