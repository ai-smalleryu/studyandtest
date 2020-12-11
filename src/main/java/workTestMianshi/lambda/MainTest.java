package workTestMianshi.lambda;

public abstract  class MainTest {
    public static int t(int n){
        if (n<=1)return 1;

        return t(n-1)+n;

    }

    public static void main(String[] args) {
       String s="asas".substring(0,2);
        System.out.println(s);
       String b="as";
        System.out.println(s.equals(b));
        System.out.println(s==b);
        System.out.println(t(5));
    }
}
