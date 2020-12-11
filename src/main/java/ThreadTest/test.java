package ThreadTest;

public abstract class test {
    final void run() {
        System.out.println("------");
    }
    void runtest(){
        System.out.println("+++++++++++");
    }

    abstract void test();
}

class test2 extends test{


    public static void main(String[] args) {
        test test2 = new test2();
        test2.run();
        test2.runtest();
    }

    @Override
    void test() {

    }
}


