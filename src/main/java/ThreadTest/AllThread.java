package ThreadTest;

/**
 * 线程的优先级
 */
public class AllThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());//获取到线程优先级数
        testPro testPro = new testPro();
        Thread a = new Thread(new testPro(), "线程一");
        Thread b = new Thread(testPro, "线程er");
        Thread c = new Thread(testPro, "线程3");
        Thread d = new Thread(testPro, "线程4");
        //设置优先级在启动前
        a.setPriority(2);
        b.setPriority(7);
        c.setPriority(8);
        d.setPriority(10);
        a.start();
        b.start();
        c.start();
        d.start();
        System.out.println("-----------------------------------------------------------------");
    new Thread(() -> System.out.println("------")).start();

    }
}

class testPro implements Runnable {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "++" + Thread.currentThread().getPriority());
    }
}
