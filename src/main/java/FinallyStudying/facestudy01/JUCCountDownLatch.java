package FinallyStudying.facestudy01;

import java.util.concurrent.CountDownLatch;

public class JUCCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        testCountDown();
    }

    private static void testCountDown() throws InterruptedException {
        //计数减法到0后出去
        /**
         * CountDownLatch的使用时候是必须要初始化有参数，也就是等待倒数计数的值
         */
        CountDownLatch countDownLatch = new CountDownLatch(0);
        for (int i = 0; i <10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"线程离开\t当前的计数"+countDownLatch.getCount());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //让其他的代码运行等待
        countDownLatch.await();
        System.out.println("线程运行完成");
    }
}
