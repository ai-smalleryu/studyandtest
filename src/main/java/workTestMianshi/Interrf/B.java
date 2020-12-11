package workTestMianshi.Interrf;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashSet;

public class B implements A,C {
    @Override
    public void t() {

    }

    @Override
    public void test2() {

    }

    public static void main(String[] args) {
        B b = new B();
        A.test();
    }
}
