package FinallyStudying.facestudy01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，共享锁和独享锁
 * 读取时候可以多个读取同时
 * 写锁时候只能加锁
 * 写操作  原子  + 独占
 */
public class WriterOnReadLock {
    private volatile Map map = new HashMap<String, Object>();
    private ReentrantReadWriteLock rew = new ReentrantReadWriteLock();

    private void putString(String key, Object value) throws InterruptedException {
        rew.writeLock().lock();//写锁
        try {
            System.out.println(Thread.currentThread().getName() + "线程写入信息 \t" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "数据写入完成");
        } finally {
            rew.writeLock().unlock();
        }
    }

    private void getString(String key) {
        rew.readLock().lock();//读锁
        try {
            System.out.println(Thread.currentThread().getName() + "读取信息 \t");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取到的信息是" + result);
        } finally {
            rew.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WriterOnReadLock writerOnReadLock = new WriterOnReadLock();
        for (int i = 0; i < 10; i++) {
            int m = i;
            new Thread(() -> {
                try {
                    writerOnReadLock.putString(m + "", m + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        for (int j = 0; j < 10; j++) {
            int m = j;
            new Thread(() -> {
                writerOnReadLock.getString(m + "");
            }, String.valueOf(j)).start();
        }

    }
}
