package StuTes;

public class Segrega {
    public static void main(String[] args) {
        C c = new C();
        c.tes1(new B());//C通过接口去依赖B的test1方法实现
    }
}

interface Inter1 {
    void test1();

    void test2();

    void test3();

    void test4();

}

class B implements Inter1 {

    @Override
    public void test1() {
        System.out.println("B实现了test1");
    }

    @Override
    public void test2() {
        System.out.println("B实现了test2");
    }

    @Override
    public void test3() {
        System.out.println("B实现了test3");
    }

    @Override
    public void test4() {
        System.out.println("B实现了test4");
    }

}

class A implements Inter1 {

    @Override
    public void test1() {
        System.out.println("A实现了test1");
    }

    @Override
    public void test2() {
        System.out.println("A实现了test2");
    }

    @Override
    public void test3() {
        System.out.println("A实现了test3");
    }

    @Override
    public void test4() {
        System.out.println("A实现了test4");
    }
}

class C {
    public void tes1(Inter1 i) { i.test1(); }
    public void tes2(Inter1 i) {
        i.test2();
    }
    public void tes3(Inter1 i){
        i.test3();
    }
}
class D {
    public void tes1(Inter1 i) {
        i.test1();
    }
    public void tes3(Inter1 i) {
        i.test3();
    }
    public void tes4(Inter1 i){
        i.test4();
    }
}
