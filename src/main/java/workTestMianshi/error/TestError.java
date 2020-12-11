package workTestMianshi.error;

public class TestError {
    public static void testError(){
        int[] i=new int[Integer.MAX_VALUE];
    }
    /*Exception in thread "main" java.lang.OutOfMemoryError: Java heap space*/
    public static void testError2(){
        int[] i=new int[Integer.MAX_VALUE-2];
    }

    public static void main(String[] args) {
       //testError();
        //testError2();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,31));
    }
}
