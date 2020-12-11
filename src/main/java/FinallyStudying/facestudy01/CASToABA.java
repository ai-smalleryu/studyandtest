package FinallyStudying.facestudy01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题解决的方法时间戳原子引用
 */
public class CASToABA {
    static AtomicReference<Integer> integerAtomicReference = new AtomicReference<>(100);//普通的原子引用默认初始值为100
    //时间戳原子引用
    /**
     * 两个参数分别是初始化值
     * 初始版本号
     */
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("=====ABA问题的产生======");
        new Thread(() -> {
            //t1线程将数据改为101后又改回100
            integerAtomicReference.compareAndSet(100, 101);
            integerAtomicReference.compareAndSet(101, 100);
        }, "t1").start();
        new Thread(() -> {
            //先保证上面的数据计算完后
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //读取数据并进行数据更改
            System.out.println(integerAtomicReference.compareAndSet(100, 2019)
                    + "\t 数据从新更改后" + integerAtomicReference.get());
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("==============解决ABA问题===============");

        new Thread(() -> {
            //获取版本号（时间戳原子引用）
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次的版本号" + stamp);
            //进行数据修改
            /*
            四个参数分别是期望数据
            修改后数据
            版本号
            修改后版本号
             */
            System.out.println(
                    stampedReference.compareAndSet(100, 101, stamp, stamp + 1)
                            + "\t 当前版本号" + stampedReference.getStamp() + "\t当前数据信息" + stampedReference.getReference());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stampedReference.compareAndSet(101, 100,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1) + "\t 当前版本号" + stampedReference.getStamp() + "\t当前数据信息" + stampedReference.getReference());
        }, "t3").start();
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "当前版本号" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stampedReference.compareAndSet(100, 103, stamp, stamp + 1) + "\t 当前实际版本号" + stampedReference.getStamp() + "\t当前实际值" + stampedReference.getReference());

        }, "t4").start();


    }
}
