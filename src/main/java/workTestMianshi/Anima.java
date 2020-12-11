package workTestMianshi;

public class Anima {
    private int i;
    public Anima(int i) {
        this.i=i;
        System.out.println("父类构造器"+i);
    }
    public void say(){
        System.out.println(i+"父类");
    }
}
