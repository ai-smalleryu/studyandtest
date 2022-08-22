package ALeetCode题选;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @project studyandtest ALeetCode题选
 * @description:
 * @author: 玉雨钰瑜
 * @time: 16.4.22 16:21
 */
public class od {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            String[] numArr = input.split(",");

            List<String> list = Arrays.asList(numArr);
            list.sort(
                    (next, previous) -> next.length() == previous.length() ? previous.compareTo(next) : (previous + next).compareTo(next + previous));
            // 对list中字符数字进行拼接
            StringBuilder sb = new StringBuilder();
            for (String num : list) {
                sb.append(num);
            }
            System.out.println(sb);
        }
    }
}

class ds{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        String[] times = sc.nextLine().split(" ");
        int[] ints = new int[n];
        for(int i = 0; i < n; i++){
            ints[i] = Integer.parseInt(times[i]);
        }
        Arrays.sort(ints);

        int[] res = new int[m];
        for(int i = 0; i < n; i++){
            res[i % m] += ints[i];
        }
        Arrays.sort(res);
        System.out.println(res[m - 1]);
    }
}
