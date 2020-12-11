package FinallyStudying.facestudy01;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 弱引用和引用队列
 * 当发生垃圾回收后被回收的对象会进入到引用队列中进行保存
 */
public class WeakReferenceAndQueue {
    public static void main(String[] args) {
      // byte[] b=new byte[80*1024*1024];

    }

    private static void phontomReferenceQueue() {
        Object o = new Object();
        //声明引用队列
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        /**
         * 软引用，弱引用和虚引用都是有一个构造器可以放入对象和引用队列
         */
        PhantomReference<Object> weakReference=new PhantomReference<>(o,objectReferenceQueue);
        System.out.println("对象是"+o);
        System.out.println("软引用中 是"+weakReference.get());
        //这时候队列中是没有元素的
        System.out.println("队列中是"+objectReferenceQueue.poll());

        o=null;
        System.gc();
        System.out.println("====================");
        System.out.println("对象是"+o);
        System.out.println("软引用中 是"+weakReference.get());
        //当发生回收的时候会将回收对象放入到引用队列当中区
        System.out.println("队列中是"+objectReferenceQueue.poll());
    }

    private static void weakReferenceQueue() {
        Object o = new Object();
        //声明引用队列
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        /**
         * 软引用，弱引用和虚引用都是有一个构造器可以放入对象和引用队列
         */
        WeakReference<Object> weakReference=new WeakReference<>(o,objectReferenceQueue);
        System.out.println("对象是"+o);
        System.out.println("软引用中 是"+weakReference.get());
        //这时候队列中是没有元素的
        System.out.println("队列中是"+objectReferenceQueue.poll());

        o=null;
        System.gc();
        System.out.println("====================");
        System.out.println("对象是"+o);
        System.out.println("软引用中 是"+weakReference.get());
        //当发生回收的时候会将回收对象放入到引用队列当中区
        System.out.println("队列中是"+objectReferenceQueue.poll());
    }
}
