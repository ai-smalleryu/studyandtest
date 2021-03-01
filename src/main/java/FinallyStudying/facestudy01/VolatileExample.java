package FinallyStudying.facestudy01;

/**
 * @Author: Administrator
 * @PACKAGE_NAME FinallyStudying.facestudy01
 * @PROJECT_NAME studyandtest
 * @Date: 2021/1/9 17:58
 * @Version 1.0
 */
public class VolatileExample {
    public static volatile int count = 0; // 计数器
    public static final int size = 100000; // 循环测试次数

    public static void main(String[] args) {
        // ++ 方式 10w 次
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= size; i++) {
                count++;
            }
        });
        thread.start();
        // -- 10w 次
        for (int i = 1; i <= size; i++) {
            count--;
        }
        // 等所有线程执行完成
        while (thread.isAlive()) {}
        System.out.println(count); // 打印结果
    }
}
