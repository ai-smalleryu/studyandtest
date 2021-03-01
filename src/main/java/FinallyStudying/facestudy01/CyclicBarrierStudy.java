package FinallyStudying.facestudy01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环阻塞  循环屏障
 */
public class CyclicBarrierStudy {
    public static void main(String[] args) {
        //这里的两个参数分别是  需要增长到的数据值，到达后要执行的任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> {
            System.out.println("数据量到达数据可以使用");
        });

        for (int i = 0; i < 6; i++) {
            int m = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "数据信息\t" + m + "++");
                try {
                    //先行到达的线程进行等待
                    cyclicBarrier.await();
                    System.out.println("等待结束运行"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

/*class Solver {
    final int N;
    final float[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;
        Worker(int row) { myRow = row; }
        public void run() {
            while (!done()) {
                processRow(myRow);

                try {
                    barrier.await();
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }
    }

    public Solver(float[][] matrix) {
        data = matrix;
        N = matrix.length;
        Runnable barrierAction =
                new Runnable() { public void run() { mergeRows(...); }};
        barrier = new CyclicBarrier(N, barrierAction);

        List<Thread> threads = new ArrayList<Thread>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }

        // wait until done
        for (Thread thread : threads)
            thread.join();
    }
}*/
