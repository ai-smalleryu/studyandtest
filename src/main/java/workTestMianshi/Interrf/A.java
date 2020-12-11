package workTestMianshi.Interrf;

public interface A {

    public void t();
    public static void test(){
        System.out.println("aaa");
    }
    public default void test2(){
        System.out.println("defaultAAAAA");
    }
}
