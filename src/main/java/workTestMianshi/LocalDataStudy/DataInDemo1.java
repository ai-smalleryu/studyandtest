package workTestMianshi.LocalDataStudy;


import org.apache.log4j.helpers.DateTimeDateFormat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DataInDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Date data = new Date();
        System.out.println(data);
        Instant now = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration between = Duration.between(now, end);
        System.out.println(between.toMillis());
        System.out.println(between.toDays());
        String s = "2019-03-23";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(s, dateTimeFormatter);
        System.out.println(parse);
        System.out.println("=====================");
        String s1 = "2019-03-23 20:00:00";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalTime parse1 = LocalTime.parse(s1, dateTimeFormatter1);
        System.out.println(parse1+"================================================");
        LocalDateTime parse2 = LocalDateTime.parse(s1, dateTimeFormatter1);
        LocalDate localDate = parse2.toLocalDate();
        System.out.println(localDate+"____________________");
        System.out.println("--------------");
       ZoneId z=ZoneId.systemDefault();
        Instant instant = parse2.atZone(z).toInstant();
        long l = instant.toEpochMilli();
        System.out.println(l+"时间");
        System.out.println(parse2);
        System.out.println(parse.getDayOfYear());
        System.out.println(parse.getDayOfMonth());
        System.out.println(parse.toString());
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);

        System.out.println(now);

    }
}
class Testzon{
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime utc = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(now);
        System.out.println(utc);
        ZonedDateTime utc1 = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(utc1);
    }
}
class LocalDatetoLocalDateTime{
    public static void main(String[] args) {
        System.out.println(getDateTimeFromTimestamp(System.currentTimeMillis()));
        System.out.println(getDateFromTimestamp(System.currentTimeMillis()));
    }

    public static LocalDateTime getDateTimeFromTimestamp(long timestamp) {
        if (timestamp == 0)
            return null;
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), TimeZone
                .getDefault().toZoneId());
    }

    public static LocalDate getDateFromTimestamp(long timestamp) {
        LocalDateTime date = getDateTimeFromTimestamp(timestamp);
        return date == null ? null : date.toLocalDate();
    }
}
