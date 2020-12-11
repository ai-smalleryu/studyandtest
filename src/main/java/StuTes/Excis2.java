package StuTes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Excis2 {
    public static void main(String[] args) {
        Student student = new Student();
        //Treesetke可以自动排序
        TreeSet<Student> treeSet=new TreeSet<Student>(((o1, o2) -> {
            if (o1.getId()>=o2.getId()){return -1;}
             return 1;

        }));
        treeSet.add(new Student(1,"tom"));
        treeSet.add(new Student(12,"jian"));
        treeSet.add(new Student(43,"marry"));
        treeSet.add(new Student(23,"dol"));
        treeSet.add(new Student(15,"so"));
        treeSet.add(new Student(7,"tea"));

        System.out.println(treeSet);
        System.out.println("----------");
        ArrayList<Integer> list=new ArrayList();
        Collections.addAll(list,1,2,3,4,5,6,7,8);
        Collections.addAll(list,12,13,4,6,3,77,89,90,124);//添加元素
        //输出遍历
        list.forEach(System.out::print);
        //lambda表达式条件下元素
        list.forEach(eles->{if(eles%2==0){
            System.out.println(eles);
        }});


        //删除集合中符合条件的元素
       Iterator li=list.iterator();
       while (li.hasNext())
       {

       }
    }

}
