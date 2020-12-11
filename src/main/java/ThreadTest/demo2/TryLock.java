package ThreadTest.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    public static void main(String[] args) {
        Lock l=new ReentrantLock();
        boolean lock;
        try {
         l.tryLock(1000, TimeUnit.MILLISECONDS);//上锁，锁超时后不再继续上锁
         try {

         }finally {
             l.unlock();
         }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
