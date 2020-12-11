package ThreadTest;

public class NewThreaddemo1 implements Runnable {
    public static void main(String[] args) {
     /*   Thread t1 = new Thread(() ->{

            System.out.println("线程运行");
            try {
                //Thread.sleep(2000);计时等待
               // for (;;);RUNNABLE可运行
                //Thread.yield();Terminated被终止

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "asa");*/
        NewThreaddemo1 newThreaddemo1 = new NewThreaddemo1();
        Thread t1 = new Thread(newThreaddemo1);
        Thread thread = new Thread(new NewThreaddemo1());
        thread.start();
        t1.setPriority(2);
        t1.start();
        //t1.setName("tom");
        System.out.println("线程名" + t1.getName());
        System.out.println("线程优先级" + t1.getPriority());
        System.out.println("线程状态" + t1.isAlive());
        System.out.println("线程Id" + t1.getId());
        System.out.println("线程是否是守护线程" + t1.isDaemon());
        System.out.println("线程是否中断" + t1.isInterrupted());
        System.out.println("线程当前状态" + t1.getState());
        /*
        *
        * NEW
        至今尚未启动的线程处于这种状态。
        RUNNABLE
        正在 Java 虚拟机中执行的线程处于这种状态。
        BLOCKED
        受阻塞并等待某个监视器锁的线程处于这种状态。
        WAITING
        无限期地等待另一个线程来执行某一特定操作的线程处于这种状态。
        TIMED_WAITING
        等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态。
        TERMINATED
        已退出的线程处于这种状态
        * */
    }

    @Override
    public void run() {
        for (int i = 0; i < 188; i++) ;
        System.out.println("停止");
    }
}
