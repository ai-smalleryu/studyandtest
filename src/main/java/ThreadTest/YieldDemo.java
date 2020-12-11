package ThreadTest;

/**
 * yield礼让线程。是直接进入就绪状态不是阻塞状态 这时会在就绪状态从新竞争，不一定礼让成功
 */
public class YieldDemo implements Runnable {
    public static void main(String[] args) {
        YieldDemo yieldDemo = new YieldDemo();
        new Thread(yieldDemo,"线程一").start();
        new Thread(yieldDemo,"线程二").start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"end");
    }
}
