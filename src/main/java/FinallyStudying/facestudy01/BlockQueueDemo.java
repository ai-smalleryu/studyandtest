package FinallyStudying.facestudy01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者加强
 */
public class  BlockQueueDemo {
    private volatile boolean FLAG = true;//生产者消费者开启条件
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public BlockQueueDemo(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("传入的队列是" + blockingQueue.getClass().getName());
    }

    public void myProd() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";//自增为1，代表生产一个
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
           // System.out.println(retValue+"=========================");
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入失败" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "停止生产");
    }


    public void myConsumer() throws InterruptedException {
        String resule = null;
        while (FLAG) {
            resule = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == resule || resule.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t超过时间没有取到资源消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + resule);
        }
    }
    public void stop(){
        this.FLAG=false;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueueDemo blockQueueDemo = new BlockQueueDemo(new ArrayBlockingQueue<>(10));
        //BlockQueueDemo blockQueueDemo=new BlockQueueDemo(new SynchronousQueue<>());
          new Thread(()->{
              System.out.println(Thread.currentThread().getName()+"生产启动");
              try {
                  blockQueueDemo.myProd();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          },"Pro").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "消费");
            try {
                blockQueueDemo.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consum").start();
        TimeUnit.SECONDS.sleep(5);
        blockQueueDemo.stop();
    }
}
