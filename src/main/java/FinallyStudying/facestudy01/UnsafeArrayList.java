package FinallyStudying.facestudy01;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * arraylist多线程不安全情况
 */
public class UnsafeArrayList {
    public static void main(String[] args) {
        new HashSet<String>();
        new CopyOnWriteArraySet<String>();
        new ConcurrentHashMap<>();//线程安全的hashmap
        unSafeArrayList();
    }

    private static void unSafeArrayList() {
        //  List list=new ArrayList<String>(); //线程不安全在多线程时候是报错的
        //解决方法
        Vector<String> list = new Vector<>();
        //第二种
        List<String> list1 = Collections.synchronizedList(new ArrayList<String>());
        //第三种也是提倡的使用
        /**
         * 写实复制,注意源码思想
         */
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException这时候可能会出现的错误并发修改异常
    }
}
