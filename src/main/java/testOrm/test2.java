package testOrm;

public class test2 {

        static {
            System.out.println("父类的静态代码块");
        }
        public static  void test()
        {
            System.out.println("父类静态方法");
        }
        public  test2()
        {
            System.out.println("无参构造器父类");
        }

    /*public static void main(String[] args) {
        test2 test2 = new test2();
    }*/

}
