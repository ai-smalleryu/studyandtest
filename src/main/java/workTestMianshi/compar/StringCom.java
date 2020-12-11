package workTestMianshi.compar;

import java.util.Arrays;

public class StringCom {
    static String ba = "abcde";
    static String msa = "aacde";


    public static void main(String[] args) {
        String[] strings = {ba, msa};
        Arrays.sort(strings, String::compareTo);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
