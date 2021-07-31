package FinallyStudying.facestudy01;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * list 去重
 */
public class ListAndHashList {
    public static void main(String[] args) {

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        System.out.println(numbersList);

        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numbersList);

        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);

        System.out.println(listWithoutDuplicates);
        System.out.println("--------------------stream方式去重--------------------------");
        List<Integer> listWithoutDuplicates2 = numbersList.stream().distinct().collect(Collectors.toList());

        System.out.println(listWithoutDuplicates2);
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("as1","sd1");
        hashtable.put("as2","sd2");
        hashtable.put("as3","sd3");
        hashtable.put("as4","sd4");
        boolean as = hashtable.containsKey("as");
        System.out.println(as+"ssssssssssssssssssssssssssssssssssssss");
        boolean as1 = hashtable.contains("as1");
        System.out.println(as1+"--->");
        System.out.println(hashtable.contains("sd2"));
        System.out.println(hashtable.containsValue("sd2"));

        String sa="C";
        char c = sa.charAt(0);

        System.out.println(c+"--->"+(byte)c);


    }
}