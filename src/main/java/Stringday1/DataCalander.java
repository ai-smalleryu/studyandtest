package Stringday1;

import java.util.Date;

/*
时间类
 */
public class DataCalander {
    public static void main(String[] args) {
        System.currentTimeMillis();//获取当前时刻
        Date date = new Date();
        System.out.println(date);//当前时间

        //获取毫秒数
        System.out.println(date.getTime());

    }
}
