package ThreadTest;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BolckSleep {
    public static void main(String[] args) throws InterruptedException {
        Date data = new Date(System.currentTimeMillis() + 1000 * 10);
        long date=data.getTime();
        System.out.println(date+"aaaaaaaaaaaaaaaaaaa");
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(data));
            Thread.sleep(1000);
            data=new Date(data.getTime()-1000);
            if (date-10000>data.getTime()){
                break;
            }
        }
    }
}
