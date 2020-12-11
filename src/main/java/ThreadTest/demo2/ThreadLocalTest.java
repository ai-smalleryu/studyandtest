package ThreadTest.demo2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ThreadLocalTest {
    public  static final ThreadLocal<SimpleDateFormat> s=
            ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-mm-dd"));
    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> si=new ThreadLocal<>();
        si.set(new SimpleDateFormat("yyyy-mm-dd"));
        SimpleDateFormat simpleDateFormat = si.get();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
