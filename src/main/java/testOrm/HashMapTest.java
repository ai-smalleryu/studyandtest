package testOrm;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();//底层是哈希码存储数据，大于一定存储时候会转换成红黑树以便于查询操作
        hashMap.put(1, 2);
        hashMap.put(11, 2);
        hashMap.put(31, 2);
        hashMap.put("s1", "namwe");
        hashMap.put("name", "2");
        System.out.println(hashMap);

        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();//底层
        objectObjectLinkedHashMap.put(1, 2);
        objectObjectLinkedHashMap.put(11, 2);
        objectObjectLinkedHashMap.put(31, 2);
        objectObjectLinkedHashMap.put("s1", "namwe");
        objectObjectLinkedHashMap.put("name", "2");

        Set<Map.Entry<Object, Object>> entries1 = objectObjectLinkedHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator11 = entries1.iterator();
        while (iterator11.hasNext())
        {
            Map.Entry<Object, Object> next = iterator11.next();
            System.out.println(next);
        }

        objectObjectLinkedHashMap.get("s1");
        Set<Map.Entry<Object, Object>> entries = objectObjectLinkedHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
    while (iterator.hasNext())
        {
            Map.Entry entry = iterator.next();
            Object o1key=entry.getKey();
            Object o1values=entry.getValue();
            System.out.println(o1key+"信息"+o1values);

        }

        while (iterator.hasNext())
        {
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next);
        }

        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        System.out.println("开始时顺序：");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = set.iterator();
        while(iterator1.hasNext()) {
            Map.Entry entry = iterator1.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");
        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

    }
}
