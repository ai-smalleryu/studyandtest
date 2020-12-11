package ThreadTest.demo2;

public class TestBank2 {

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<20;i++){
            testvol();
        }

    }

    private static  void testvol() throws InterruptedException {
        Bank2 bank2 = new Bank2();
        for (int i = 0; i < 100; i++) {

              Runnable r = () -> {
                bank2.add();
            };
            new Thread(r).start();
        //bank2.add();
           // System.out.println(bank2.getI()+"测试");
        }

        System.out.println(bank2.getI());
    }
}
