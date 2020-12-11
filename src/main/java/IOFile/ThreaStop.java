package IOFile;

/**
 * 终止线程的两种方式
 * 1.正常执行完毕
 */
public class ThreaStop implements Runnable {
    private  static boolean bo = true;

    public static void main(String[] args) {
        ThreaStop threaStop = new ThreaStop();
        new Thread(threaStop, "线程一").start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + i+"bo"+bo);
            if (i == 500) {
                threaStop.test();
            }
        }
    }

    public void test() {
        this.bo = false;

    }

    @Override
    public void run() {
        while (bo) {
            System.out.println(Thread.currentThread().getName() + "执行"+bo);
        }
    }
}
