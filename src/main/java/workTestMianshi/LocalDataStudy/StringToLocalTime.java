package workTestMianshi.LocalDataStudy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalTime {
    public static void main(String[] args) {
        String s="21:21:21";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime parse = LocalTime.parse(s, dateTimeFormatter);
        System.out.println(parse);
    }
}
