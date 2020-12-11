package FinallyStudying.facestudy01;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeeakHashMapStudy {
    public static void main(String[] args) {
        testWeakHashMap();

    }

    private static void testWeakHashMap() {
        /**
         * 单独的hashmap属于强引用，这时候是不受GC影响的
         */
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        Integer integer=new Integer(1);
        integerStringHashMap.put(integer,"wer");
        System.out.println(integerStringHashMap);
        integer=null;
        System.out.println(integerStringHashMap);
        System.gc();
        System.out.println(integerStringHashMap);
        System.out.println("============================================");
        /**
         * weakHashMap属于弱引用，当发生gc时候会被回收
         * 适用于对内存敏感的开发
         */
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer integer2 = new Integer(1);
        weakHashMap.put(integer2, "wer");
        System.out.println(weakHashMap);
        integer2 = null;
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
    }
}
