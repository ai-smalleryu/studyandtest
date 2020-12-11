package FinallyStudying.facestudy02;

public class StringAndStringBuffer {
    public static void main(String[] args) {
        byte a = 1;
        // a = 1 + a;
       a+=1;
        System.out.println(a);
    }

    static {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
