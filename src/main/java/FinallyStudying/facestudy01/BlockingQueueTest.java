package FinallyStudying.facestudy01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 队列学习
 * 阻塞队列
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);//创造一个有界队列，数量为3
      /*  System.out.println(blockingQueue.add("q"));
        System.out.println(blockingQueue.add("s"));
        System.out.println(blockingQueue.add("sa"));
        //如果添加数量大于三会抛出异常
        System.out.println(blockingQueue.element());
        //队列移除元素
        System.out.println(blockingQueue.remove());//移除队头元素，返回的是被移除的元素
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/
        /**
         * 和上面的类似也是队列的插入   检查和移除元素，但是不会抛出异常
         * 如果无法插入返回false 移除完后返回null
         */
      /*  System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("aa"));
        System.out.println(blockingQueue.offer("as"));
        //这里会返回false
        System.out.println(blockingQueue.offer("ad"));
        System.out.println(blockingQueue.peek());//返回队头元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/
      blockingQueue.put("a");
      blockingQueue.put("aas");
      blockingQueue.put("dda");
      //当队列已满的时候这里会一直处于阻塞状态直到队列有位置
     // blockingQueue.put("daa");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //如果队列中没有了会阻塞，直到队列中再次有值
        //System.out.println(blockingQueue.take());

        System.out.println("====================");
        //使用offer的好处在于可以设置阻塞时间如果超过这个时间则放弃
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("aas", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("ass", 2L, TimeUnit.SECONDS));
        //System.out.println(blockingQueue.offer("azc", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println("=====================");
    }
}
