package SortAlgorithm;

import java.util.Scanner;

/**
 * s顺序查找
 */
public class OrderSort {
    public void sortTest(String s1,String s2)
    {
        char[] chars = s1.toCharArray();

        String[] strings=new String[chars.length];
       /* System.out.println(strings.length);
        System.out.println(chars.length);*/
        for (int i=0;i<chars.length;i++)
        {
            strings[i]= String.valueOf(chars[i]);
        }
       for (int i=0;i<strings.length;i++)
       {
           if (strings[i].equals(s2))
           {
               System.out.println("第"+(i+1)+"字符");
               break;
           }
           if (i==strings.length-1)
           {
               System.out.println("无法查找到");
           }

       }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入查找对象");
        String next = scanner.next();
        System.out.println("输入查找的单位");
        String next1 = scanner.next();

        OrderSort orderSort = new OrderSort();
        orderSort.sortTest(next,next1);
    }
}
