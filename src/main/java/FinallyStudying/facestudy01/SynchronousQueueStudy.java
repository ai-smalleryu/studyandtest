package FinallyStudying.facestudy01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue阻塞队列使用
 */
public class SynchronousQueueStudy {
    public static void main(String[] args) {
        //SynchronousQueue队列是生产一个消费一个所以如果不消费或者消费时候没有资源是阻塞状态
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        //阻塞队列添加元素
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "队列添加元素1");
                blockingQueue.put("as");
                System.out.println(Thread.currentThread().getName() + "队列添加元素2");
                blockingQueue.put("asss");
                System.out.println(Thread.currentThread().getName() + "队列添加元素3");
                blockingQueue.put("aaas");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        //队列进行去元素
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "队列取出元素1");
                System.out.println(blockingQueue.take()+"消费队列");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "队列取出元素2");
                System.out.println(blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "队列取出元素3");
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
