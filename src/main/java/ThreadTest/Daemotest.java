package ThreadTest;

/**
 * 守护线程是为用户线程服务的，jvm停止不用等待用户线程执行完毕
 */
public class Daemotest implements Runnable {
    @Override
    public void run() {
        for (int i=1; i<10;i++ ) {
            Thread.currentThread().setName("aaaaaaaaaaaa");
            System.out.println("----------"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Daemotest daemotest = new Daemotest();
        Thread thread = new Thread(daemotest);
        Thread.currentThread().setName("aa");//设置线程名称
        System.out.println(Thread.currentThread().isAlive());//判断线程是否存活  currentThread镖师当前线程
        //thread.setDaemon(true);//将用户线程转换为守护线程
        thread.start();
    }
}
