package FinallyStudying.facestudy01;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: Administrator
 * @PACKAGE_NAME FinallyStudying.facestudy01
 * @PROJECT_NAME studyandtest
 * @Date: 2020/12/18 9:52
 * @Version 1.0
 */
public class LockSupportDemo {

    public static final Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    //静态内部类
    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(getName()+"被中断了");
                }
                System.out.println(getName()+"继续执行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        t1.interrupt();
        System.out.println("----------->");
        Thread.sleep(3000L);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
