package SortAlgorithm;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
二分查找
 */
public class BinarySearch {
    //冒泡排序
    public double[] maoPao(double[] a) {

        double temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;

                }
            }
        }
        return a;
    }

    //选择排序
    public void xuanZe(double[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            double tp = 0;
            int temp = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[temp]) {
                    temp = j;
                }
            }
            System.out.println(a[i] + "======" + a[temp]);
            if (a[temp] != a[i]) {
                tp = a[i];
                a[i] = a[temp];
                a[temp] = tp;
            }
        }
        for (double d : a
        ) {
            System.out.println(d);
        }
    }

    public static void test(double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            double t = 0;
            int temp = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[temp]) {
                    temp = j;
                }
            }
            if (a[temp] != a[i]) {
                t = a[i];
                a[i] = a[temp];
                a[temp] = t;

            }
        }
    }

    //插入排序
    public void chaRu(double[] a) {

        double min = 0;
        for (int i = 1; i < a.length; i++) {
            double min1 = a[i];
            if (a[i] < a[i - 1]) {
                for (int j = i - 1; j >= 0 && j >= 0; j--) {
                    a[j + 1] = a[j];
                }
            }
        }

    }

    //对于数字的查找方式
    @Test
    public void midSort(String s1) {
        s1 = "123323";
        List<Double> lDou = new ArrayList<>();
        char[] chars = s1.toCharArray();
        double[] doubles = new double[chars.length];
        for (int i = 0; i < chars.length; i++) {
            doubles[i] = Double.valueOf(String.valueOf(chars[i]));
            lDou.add(doubles[i]);
        }
        for (Double d : doubles
        ) {
            System.out.println(d + "数据信息");
        }
    }

    public static void main(String[] args) {
        double[] as = {12, 334, 23, 56, 78, 23};
        BinarySearch binarySearch1 = new BinarySearch();
        binarySearch1.xuanZe(as);

/*
        System.out.println("输入查找数据信息");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.midSort(next);*/

    }
}
