package workTestMianshi.LocalDataStudy;

import java.time.*;
import java.util.TimeZone;

public class LocalDateToTimestamp {
    public static void main(String[] args) {
        /**
         * 因为localdate时间是精确到小时的
         */
        LocalDate localDate = LocalDate.now();
        long timestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        System.out.println(timestamp+"时间戳");
        System.out.println("LocalDate转换为时间戳");

        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp2 = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println(timestamp2);
        System.out.println("--------------------------------------------------");
        System.out.println("创建时间戳转换为时间");
        long timestamp3 = System.currentTimeMillis();
        LocalDate localDate1 = Instant.ofEpochMilli(timestamp3).atZone(ZoneOffset.ofHours(8)).toLocalDate();//因为是格林威治时间所以偏移量是八个小时
        LocalDateTime localDateTime1 = Instant.ofEpochMilli(timestamp3).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        System.out.println("LocalDate"+localDate1);
        System.out.println("LocalDateTime"+localDateTime1);
        //第二种方式
        System.out.println("++++++++++++++++++++++++++++");
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp3), TimeZone.getDefault().toZoneId());
        System.out.println(localDateTime2+"时间戳转换为时间");
        LocalDate localDate2 = localDateTime2.toLocalDate();
        System.out.println(localDate2);
        LocalTime localTime = localDateTime2.toLocalTime();
        System.out.println(localTime);

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
