package FinallyStudying.facestudy01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile的三大特性
 * 可见性
 * 不保证原子性
 * 禁止指令重排
 */
public class VolatileTest1 {
    public static void main(String[] args) {
        StuVolatile stuVolatile = new StuVolatile();
        for (int m = 0; m < 20; m++) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    stuVolatile.add1();
                    stuVolatile.addatomic();
                }
            },String.valueOf(m)).start();
        }
        if (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(stuVolatile.i+"jjjjjjjjjjjjjjjjjj"+stuVolatile.atomicInteger);

    }

}

/**
 *不保证原子性所以加载到最后不一定是想要的值
 */
class StuVolatile {
    volatile int i = 0;

    public void add1() {
        i++;
    }
    //声明原子性的整型
   AtomicInteger atomicInteger= new AtomicInteger();//不进行值的初始化默认是0
    public void addatomic(){
        atomicInteger.incrementAndGet();
    }
}
/**
 * 解决原子性
 */

