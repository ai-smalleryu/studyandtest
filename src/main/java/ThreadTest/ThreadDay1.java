package ThreadTest;

public class ThreadDay1 extends  Thread{
    public static void main(String[] args) {
        //启动线程
        //创建子类对象，调用start方法
        ThreadDay1 threadDay1 = new ThreadDay1();
        threadDay1.start();

    }
    //创建线程


    @Override
    public void run() {

        for (int i=0;i<20;i++){
            System.out.println("===========");
        }
    }
}
