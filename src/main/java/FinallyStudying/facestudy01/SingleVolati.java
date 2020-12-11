package FinallyStudying.facestudy01;

/**
 * 单列模式
 */
public class SingleVolati {
    //解决指令重排导致的数据安全多线程问题
    private volatile  static SingleVolati s = null;

    private SingleVolati() {
        System.out.println(Thread.currentThread().getName() + "单列模式无参构造器");

    }

    public static SingleVolati getSing() {
        //解决单列模式在多线程情况下的错误使用DCL双端检锁机制
        if (s == null) {
            synchronized (SingleVolati.class) {//上锁
                if (s == null) {
                    s = new SingleVolati();
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
/*        System.out.println(SingleVolati.getSing()==SingleVolati.getSing());
        System.out.println(SingleVolati.getSing()==SingleVolati.getSing());
        System.out.println(SingleVolati.getSing()==SingleVolati.getSing());
        System.out.println(SingleVolati.getSing()==SingleVolati.getSing());*/
        System.out.println("多线程下状况显示");
        /**
         * 这时候会出现多次初始化所以这时候是违背了单例模式的
         */
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                SingleVolati.getSing();
            }, String.valueOf(i)).start();
        }
    }
}
