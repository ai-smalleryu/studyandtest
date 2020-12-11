package workTestMianshi.forIte;

import java.util.ArrayList;

public class TestRun extends Run {
    public String name = "mmmm";

    @Override
    public void run() {

        System.out.println("=========");
    }

    public static void main(String[] args) {
  /*      ArrayList<Object> objects = new ArrayList<>();
        int size = objects.size();
        Run testRun = new TestRun();
        System.out.println(testRun.name);
        testRun.run();*/
        assert 1 > 2;
    }
}
