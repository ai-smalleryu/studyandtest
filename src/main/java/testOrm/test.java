package testOrm;

import javax.sound.midi.Soundbank;

public class test extends test2 {
    static {
        System.out.println("子类静态代码块");
    }
    public test(){
        System.out.println("子类构造器");
    }
    public  static void test3()
    {
        System.out.println("子类静态方法");
    }

    public static void main(String[] args) {
        test test = new test();
        char aq='f';
       char sa='\u0012';
        System.out.println(sa);

        int[] a=new int[12];
        System.out.println(a.length);
        String s="aaaa";
        String s1=s+"asd";
        System.err.println(s1==s);
    }
}




