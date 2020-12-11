package ListMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIt {
    public static void main(String[] args) {
HashMapIt.hashMapItor();
    }
    static HashMap<Object, Object> hashMap;
    static
    {
        hashMap = new HashMap<>();
        hashMap.put(1,"name");
        hashMap.put("na","tackew");
        hashMap.put("tom","123");
        hashMap.put(1121,"12");
        hashMap.put(12,34);
    }
    public static void hashMapItor()
    {
        //使用hashmap获取keyset来去取得值
        for (Object o1:hashMap.keySet()
             ) {
            System.out.println(hashMap.get(o1)+"信息1"+o1);

        }

        //转换成set集合然后进行iter遍历
        Iterator<Map.Entry<Object, Object>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next.getKey()+"map值是"+next.getValue());
        }
//和第二种类似
        for (Map.Entry<Object,Object> map:hashMap.entrySet()
             ) {
            System.out.println(map.getKey()+"信息2"+map.getValue());
        }
//如果想要获得key值依旧麻烦
        for (Object o:
             hashMap.values()) {
            System.out.println(o);
        }
    }
}
