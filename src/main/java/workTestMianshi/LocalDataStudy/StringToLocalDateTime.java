package workTestMianshi.LocalDataStudy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTime {
    public static void main(String[] args) {
        String s="2019-12-02 21:21:21";

        String s1 = "2019-03-23 20:00:00";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter1);
        System.out.println(parse);
        String replace = s.replace("-", "/");
        System.out.println(replace);
    }
}
