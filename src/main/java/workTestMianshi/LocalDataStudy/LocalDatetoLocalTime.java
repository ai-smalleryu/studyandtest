package workTestMianshi.LocalDataStudy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * localdatetime转换到localdate和locatime
 */
public class LocalDatetoLocalTime {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now+"aaa");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1+"ssss");
        int dayOfYear = now1.getDayOfYear();
        System.out.println(dayOfYear);
        LocalDate of = LocalDate.of(now1.getYear(), now1.getMonth(), now1.getDayOfMonth());
        System.out.println(of);
        System.out.println("----------------");
        LocalTime of1 = LocalTime.of(now1.getHour(), now1.getMinute(), now1.getSecond());
        System.out.println(of1);
        System.out.println("格式化，自己想要的数据类型");
        LocalDateTime of2 = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0, 0);
        System.out.println(of2);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = of2.format(dateTimeFormatter2);
        System.out.println(format+"格式化");
        System.out.println("------------------------------");
        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter2);
        System.out.println(parse);
        System.out.println("++++++++++++++++++++++++++++++++++");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = now.toString();
       // LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter);
        System.out.println(s);


    }
}
