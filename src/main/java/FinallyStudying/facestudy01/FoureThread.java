package FinallyStudying.facestudy01;


import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池的使用和七大参数（重点）
 */
public class FoureThread {
    public static void main(String[] args) {
        //threadPoolExecutor();
        // threadPool();
    }

    private static void threadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,//线程池设置常驻核心数
                5,//线程池允许容纳的最大线程数
                1L,//多于线程的存活时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(15),
                //new LinkedBlockingDeque<>(3),//队列容纳数
                Executors.defaultThreadFactory(),//默认生产线程的工厂
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        //阻塞队列
       /* SynchronousQueue:这个队列接收到任务的时候, 会直接提交给线程处理, 而不保留它, 如果所有线程都在工作怎么办？那就 * 新建一个线程来处理这个任务！
        所以为了保证不出现<线程数达到了maximumPoolSize而不能新建线程> 的错误, 使用这个类型队列的时候, maximumPoolSize 一般指定成 Integer.MAX_VALUE, 即无限大.
        LinkedBlockingQueue:这个队列接收到任务的时候, 如果当前线程数小于核心线程数, 则核心线程处理任务;如果当前线程数等于核心线程数, 则进入队列等待.由于这个队列最大值为Integer.MAX_VALUE,
        即所有超过核心线程数的任务都将被添加到队列中，这也就导致了 maximumPoolSize的设定失效, 因为总线程数永远不会超过 corePoolSize.
        ArrayBlockingQueue:可以限定队列的长度, 接收到任务的时候, 如果没有达到 corePoolSize 的值, 则核心线程执行任务, 如果达到了, 则入队等候, 如果队列已满, 则新建线程
        (非核心线程) 执行任务, 又如果总线程数到了maximumPoolSize, 并且队列也满了, 则发生错误.
         DelayQueue:队列内元素必须实现 Delayed 接口, 这就意味着你传进去的任务必须先实现Delayed接口.这个队列接收到任务时, 首先先入队, 只有达到了指定的延时时间, 才会执行任务.*/


        //拒绝策略
        /*ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常(默认).
         ThreadPoolExecutor.DiscardPolicy：直接丢弃任务, 但是不抛出异常.
         ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务, 然后重新尝试执行任务(重复此过程)
         ThreadPoolExecutor.CallerRunsPolicy：用调用者所在的线程来执行任务.*/
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

        } finally {
            fixedThreadPool.shutdown();//关闭线程池
        }
    }


    public static void testScheduled() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        // 1. 延迟一定时间执行一次
        service.schedule(() -> {
            System.out.println("schedule ==> 云栖简码-i-code.online");
        }, 2, TimeUnit.SECONDS);

        // 2. 按照固定频率周期执行
        service.scheduleAtFixedRate(() -> {
            System.out.println("scheduleAtFixedRate ==> 云栖简码-i-code.online");
        }, 2, 3, TimeUnit.SECONDS);

        //3. 按照固定频率周期执行
        service.scheduleWithFixedDelay(() -> {
            System.out.println("scheduleWithFixedDelay ==> 云栖简码-i-code.online");
        }, 2, 5, TimeUnit.SECONDS);
    }
}
