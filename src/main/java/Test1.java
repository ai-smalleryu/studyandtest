import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Administrator
 * @PACKAGE_NAME PACKAGE_NAME
 * @PROJECT_NAME studyandtest
 * @Date: 2021/1/27 14:42
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
      /*  String host="test.bonc.com";
        String[] ss = host.split("\\.");


        StringBuilder newhost = new StringBuilder();
        for (int i = 1; i < ss.length; i++) {
            newhost.append(ss[i]).append(".");
        }

        newhost.setLength(newhost.length() - 1);
        int indexOf = host.indexOf(".");
        System.out.println(indexOf);
        String substring = host.substring(indexOf+1, host.length());
        System.out.println(substring);
        System.out.println(newhost.toString());*/
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                threadPoolExecutor.execute(() -> {//开启线程池  -----------------》下面就要关闭线程池
                    System.out.println(Thread.currentThread().getName() + "线程"+ finalI);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            threadPoolExecutor.shutdown();//关闭线程池
            System.out.println("--------线程结束-------------");
        }
        try {
            threadPoolExecutor.awaitTermination(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (threadPoolExecutor.isTerminated()){
            System.out.println("--------------true-------------------");
        }else {
            System.out.println("--------------false-------------------");
        }

    }
}

class T{
    static Object t1(){
        List<String> strings = new ArrayList<>();
        strings.add("as");
        strings.add("ass");
        return strings;
    }
    public static void main(String[] args) {
        Object o = t1();
        boolean b = o instanceof List;
        if (b){
          List<String>  list= (List<String >)o;
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
