package ALeetCode题选.algorithmproblems.strings;

/**
 * @project studyandtest ALeetCode题选.algorithmproblems.strings
 * @description:
 * @author: 玉雨钰瑜
 * @time: 8.12.21 20:27
 */
public class Tres {
    public static void main(String[] args) {
        char s = ' ';
        System.out.println(String.valueOf(s).equals(" "));
    }

    public static void test(String s) {
        int start = 0, end = s.length() - 1;

        while (start <= end) {
            char c = s.charAt(start);
            char c1 = c;
            c = s.charAt(end);
            char c2 = s.charAt(end);
            c2 = c1;
            start++;
            end++;
        }
    }
}
