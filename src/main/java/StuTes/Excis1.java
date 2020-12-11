package StuTes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Excis1 {
    //集合排序
    public static void main(String[] args) {
        //已知在一个Array List中Student集合按年龄进行降序排序
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "tom"));
        list.add(new Student(12, "jian"));
        list.add(new Student(43, "marry"));
        list.add(new Student(23, "dol"));
        list.add(new Student(15, "so"));
        list.add(new Student(7, "tea"));

        list.sort((o1, o2) -> o2.getId() - o1.getId());
        System.out.println(list);
        System.out.println("======================================");
        Iterator iterator = list.iterator();
        for (Student object : list) {
            System.out.println(object);
        }
        //   Iterable i= (Iterable) list.iterator();

    }

  @Test
    public void testSort() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "tom"));
        list.add(new Student(12, "jian"));
        list.add(new Student(43, "marry"));
        list.add(new Student(23, "dol"));
        list.add(new Student(15, "so"));
        list.add(new Student(7, "tea"));
        list.sort((o1,o2)->o1.getName().length()-o2.getName().length());
        System.out.println(list.toString());
        for (Student student : list) {
            System.out.println(student);
        }

    }
}
