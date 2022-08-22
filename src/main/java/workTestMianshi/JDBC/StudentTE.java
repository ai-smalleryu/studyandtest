package workTestMianshi.JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @project studyandtest workTestMianshi.JDBC
 * @description:
 * @author: 玉雨钰瑜
 * @time: 8.1.22 14:35
 */

public class StudentTE {
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", passWords='" + passWord + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private String passWord;

    public static void main(String[] args) throws ParseException {
        String dStr = "2001.12.12-08:23:21";
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");
        try {
            d = sdf.parse(dStr);
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }
        System.out.println(d);
        System.out.println(d.getTime());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(1627663739000L);
        System.out.println(simpleDateFormat.format(date));

        StringBuffer stringBuffer = new StringBuffer("as'");
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        System.out.println(stringBuffer);
    }
}