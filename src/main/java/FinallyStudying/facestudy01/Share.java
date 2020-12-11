package FinallyStudying.facestudy01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者
 * 一个线程加一一个线程减一
 */
public class Share {
    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                test.increment();
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                test.decrement();
            }
        }, "BBB").start();
    }
}

class Test {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    int num = 0;

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {//使用while防止虚假唤醒
                //数量为一等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t 当前值" + num);
            //唤醒其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t 当前值" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
