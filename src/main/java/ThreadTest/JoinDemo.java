package ThreadTest;

/**
 * 合并线程，此线程执行完成后在执行其他线程，其他线程阻塞状态
 */
public class JoinDemo {
    public static void main(String[] args) {
        System.out.println("让小孩去买烟");
        new Thread(new Father()).start();

    }
}

class Father implements Runnable{
    @Override
    public void run() {
        System.out.println("没有了,让小孩u去");
        Thread thread = new Thread(new Son());
        thread.start();
        try {
            thread.join();

            System.out.println("nadao");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class Son implements Runnable{
    @Override
    public void run() {
        System.out.println("拿着钱去了");
        for(int i=1;i<10;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("买好了");
    }
}