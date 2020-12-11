package FinallyStudying.facestudy01;

class DeadTest implements Runnable {
    private String lockAA;

    public DeadTest(String lockAA, String lockBB) {
        this.lockAA = lockAA;
        this.lockBB = lockBB;
    }

    private String lockBB;

    @Override
    public void run() {
        synchronized (lockAA) {
            System.out.println(Thread.currentThread().getName() + "当前自己的锁是" + lockAA + "还要去获得锁" + lockBB);
            synchronized (lockBB) {
                System.out.println(Thread.currentThread().getName() + "当前自己的锁是" + lockBB + "还要去获得锁" + lockAA);
            }
        }
    }
}

/**
 * 死锁
 * 死锁原因时两个或者两个以上的线程在执行过程中，因抢夺资源造成的互相等待的现象
 * 若无外力干涉，那么他们将无法推进下去
 */
public class DeadLock {
    public static void main(String[] args) {
        String lockA = "lockAA";
        String lockB = "lockBB";
        new Thread(new DeadTest(lockA, lockB), "lockAAAA").start();
        new Thread(new DeadTest(lockB, lockA), "lockBBBB").start();
    }
}


