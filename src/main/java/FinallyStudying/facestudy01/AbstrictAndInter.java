package FinallyStudying.facestudy01;

import java.util.ArrayList;

public abstract class AbstrictAndInter {
    static void say() {
        System.out.println("===");
    }

    public void say2() {
        System.out.println("++++++++");
    }
  /*  public static void main(String[] args) {
        say();
    }*/
}

/*
class T extends AbstrictAndInter{
    @Override
    void say2() {
        super.say2();
        System.out.println("llllllll");
    }

    public static void main(String[] args) {
        //T.say();
        T t = new T();
        t.say2();
    }
}*/
