package workTestMianshi;

public class Persion {

    static {
        System.out.println("父类静态代码块");
    }

    public Persion() {
        System.out.println("父类无参构造器");
    }
    {
        System.out.println("父类普通代码块");
    }
}
