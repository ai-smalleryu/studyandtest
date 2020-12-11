package FinallyStudying.facestudy01;

import java.util.concurrent.CountDownLatch;

public class JUCCountDownToLower {
    public static void main(String[] args) throws InterruptedException {
        //计数减法到0后出去
        /**
         * CountDownLatch的使用时候是必须要初始化有参数，也就是等待倒数计数的值
         */
        System.out.println(StringValue.five.getId()+"\t"+StringValue.five.getName());
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"线程离开\t当前的计数"+countDownLatch.getCount());
                countDownLatch.countDown();
            },StringValue.getValue(i).getName()).start();
        }
        //让其他的代码运行等待
        countDownLatch.await();
        System.out.println("线程运行完成");
    }
}

enum  StringValue {
    //枚举就相当于一个小型的数据库信息
    one(1, "齐国"), tow(2, "楚国"), three(3, "燕国"), fore(4, "韩国"), five(5, "魏国"), six(6, "赵国");
    private Integer id;
    private String name;
    //需要get方法 和全参构造器

    StringValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static StringValue getValue(int id) {
        StringValue[] values = StringValue.values();
        for (StringValue s : values
        ) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
