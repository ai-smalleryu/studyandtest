package ThreadTest;

public class Web123 implements Runnable {
    //票数
    private volatile int num = 99;

    @Override
    public void run() {
        while (true) {
            if (num < 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->" + num--);
        }
        System.out.println("没了");
    }

    public static void main(String[] args) {
        Web123 web123 = new Web123();
        //多个代理对象，创建Thread可以设置名称
        new Thread(web123, "a").start();
        new Thread(web123, "b").start();
        new Thread(web123, "c").start();
    }
}
