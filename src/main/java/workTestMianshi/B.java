package workTestMianshi;

public class B extends A {
    String s = "子类String";

    @Override
    void Aa() {
        System.out.println("BAa");
    }
    public void as(){
        System.out.println("ssa");
    }

    public static void main(String[] args) {
        A a = new B();
        if (a instanceof B){
            System.out.println("true");
        }
        System.out.println(a.s);
        a.Aa();
      /*  B b = new B();
        b.as();*/
    }
}
