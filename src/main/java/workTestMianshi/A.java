package workTestMianshi;

public class A {
    String s="父类string";
    void Aa(){
        System.out.println("Aa");
    }
    void Ab(){
        System.out.println("Ab");
    }

    public static void main(String[] args) {
        A a = new B();

    }
}
