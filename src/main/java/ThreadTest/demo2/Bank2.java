package ThreadTest.demo2;

import java.util.concurrent.atomic.LongAdder;

public class Bank2 {
    private int i = 0;

    public  int getI() {
        return i;
    }

    public  void add() {
        this.i = i + 1;
    }
    

}
class Test{
    public static void main(String[] args) {
        Bank2 bank2 = new Bank2();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                bank2.add();
            }
        },"线程1").start();
        if (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(bank2.getI());
    }
}
