package FinallyStudying.facestudy01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 什么是CAS
 * compareAndSet缩写就是CAS
 * 比较并交换
 */
public class CAS {
    public static void main(String[] args) {
        AtomicInteger a=new AtomicInteger(4);//原子整型，初始值为4
        System.out.println(a.compareAndSet(4, 21));//如果主物理内存中的值是4则写出改为21
        System.out.println(a.get()+"此时主物理内存的数据");
        System.out.println(a.compareAndSet(4,23)+"主物理内存数据交换"+a.get());
    }
}
