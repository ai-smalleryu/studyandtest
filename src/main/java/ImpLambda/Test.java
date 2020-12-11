package ImpLambda;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, -1);
        System.out.println(instance.getTime());
        System.out.println(instance.getFirstDayOfWeek());
        System.out.println(instance.getMinimalDaysInFirstWeek());
        System.out.println(instance + "---------------");

        String a = "AS";
        String b = new String("AS");
        String c = "A" + "S";
        System.out.println(b == a);
        System.out.println(c == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        System.out.println(a.intern() == c.intern());
    }
}

class Test2 {
    static class Writer extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {

            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");

            try {

                Thread.sleep(5000); //以睡眠来模拟写入数据操作

                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");

                cyclicBarrier.await();

            } catch (Exception e) {

                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

    public static void main(String[] args) {

        int N = 4;

        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < 5; i++) {
            new Writer(barrier).start();
        }
    }
}

class A {
    public int hashCode() {
        return 1;
    }
/*
    public boolean equals(Object b) {
        return true;
    }*/

    public static void main(String args[]) {
        Set set = new HashSet();
        set.add(new A());
        set.add(new A());
        set.add(new A());
        System.out.println(set.size());

        System.out.println(new A().equals(new A()));
    }
}

