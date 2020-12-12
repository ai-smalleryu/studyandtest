package FinallyStudying.facestudy01;


import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池的使用和七大参数（重点）
 */
public class FoureThread {
    public static void main(String[] args) {
        //threadPoolExecutor();
        threadPool();
    }

    private static void threadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,//线程池设置常驻核心数
                5,//线程池允许容纳的最大线程数
                1L,//多于线程的存活时间
                TimeUnit.SECONDS,//时间单位
                new LinkedBlockingDeque<>(3),//队列容纳数
                Executors.defaultThreadFactory(),//默认生产线程的工厂
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        //当线程任务数量大于最大线程数和队列容纳数值和时候就会报错
        try {
            for (int i = 0; i < 10; i++) {//
                executorService.execute(() -> {//开启线程池  -----------------》下面就要关闭线程池
                    System.out.println(Thread.currentThread().getName() + "线程");
                });
            }
        } finally {
            executorService.shutdown();//关闭线程池
        }
    }

    private static void threadPool() {
        /**
         * 三个线程池 的区别，固定数量的用于处理长期的任务，性能比较好
         * 一个任务一个任务执行的场景用一个固定线程的线程池
         * 随机不固定数量 的线程池适用于执行短期异步的小程序，或者负载比较轻的服务
         */

        //创建一个单线程化的线程池, 它只会用唯一的工作线程来执行任务, 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行. 如果某一个任务执行出错, 将有另一个线程来继续执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();//创建一个只有一个线程的线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);//创建固定数量的线程池

        //线程数量随机改变的线程池 创建一个可缓存线程池, 如果线程池长度超过处理需要, 可灵活回收空闲线程(60秒), 若无可回收,则新建线程.
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        //创建固定数目线程的线程池, 超出的线程会在队列中等待
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);

        //创建一个支持定时及周期性的任务执行的线程池, 多数情况下可用来替代Timer类
        ExecutorService executorService4 = Executors.newScheduledThreadPool(3);
        //推荐使用ThreadPoolExecutor创建
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        try {
            for (int i = 0; i < 10; i++) {
                executorService1.execute(() -> {//开启线程池  -----------------》下面就要关闭线程池
                    System.out.println(Thread.currentThread().getName() + "线程");
                });
            }
        } finally {
            executorService1.shutdown();//关闭线程池
        }
    }

    @Test
    public void testExecutorService() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < 10; i++) {
                final int index = i;
                fixedThreadPool.execute(() -> {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

        }finally {
            fixedThreadPool.shutdown();//关闭线程池
        }
    }
}
