package FinallyStudying.facestudy01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AABBCC {
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private void print5() {
        lock.lock();
        try {
            //当num为1时候进入到方法打印
            while (num != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t线程打印" + i);
            }
            //调整条件唤醒其他线程
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print10() {
        lock.lock();
        try {
            while (num != 2) {//当num为1时候进入到方法打印
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t线程打印" + i);
            }
            //调整条件唤醒其他线程
            num = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print15() {
        lock.lock();
        try {
            while (num != 3) {//当num为1时候进入到方法打印
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t线程打印" + i);
            }
            //调整条件唤醒其他线程
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AABBCC aabbcc = new AABBCC();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aabbcc.print5();
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aabbcc.print10();
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aabbcc.print15();
            }
        }, "CCC").start();
    }
}
