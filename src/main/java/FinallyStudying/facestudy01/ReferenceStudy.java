package FinallyStudying.facestudy01;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class ReferenceStudy {
    public static void main(String[] args) {
        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch);
        String property = System.getProperty("os.arch");
        System.out.println(property);
        System.out.println(UUID.randomUUID().toString().length());
        int i=1;
        System.out.println(i++);
        softReference();

    }

    private static void weakReference() {
        Object o = new Object();
        WeakReference<Object> o1 = new WeakReference<>(o);
        //弱引用，无论内存是否充足，只要发生gc回收则回收该引用的占用对象
        System.out.println(o1.get());
        System.out.println(o);
        o = null;
        System.gc();
        System.out.println(o);
        System.out.println(o1.get());
    }

    private static void softReference() {
        Object o = new Object();
        SoftReference<Object> o1 = new SoftReference<>(o);
        //软引用，如果内存充足则不进行回收，否则回收
        System.out.println(o1.get());
        System.out.println(o);
        o = null;
        System.gc();
        System.out.println(o);
        System.out.println(o1.get());
    }
}
