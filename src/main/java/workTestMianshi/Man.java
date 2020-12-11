package workTestMianshi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Man extends Persion {
    {
        System.out.println("子类代码块");
    }

    static {
        System.out.println("子类静态代码块");
    }

    public Man() {
        System.out.println("子类无参构造器");
    }

    public static void main(String[] args) {

        //Man man = new Man();
        /*
        父类静态代码块
子类静态代码块
父类普通代码块
父类无参构造器
子类代码块
子类无参构造器
         */
        System.out.println("---------------");
        Persion p = new Man();
    }
}
