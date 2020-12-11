package workTestMianshi.LocalDataStudy;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDate {
    public static void main(String[] args) {
        String s1="2019-12-12";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(s1, dateTimeFormatter);
        System.out.println(parse);
        String s = parse.toString();
        System.out.println(s);
        System.out.println("==============================");
        String format = String.format(s1, dateTimeFormatter);
        System.out.println(format+"sss");
    }
}
