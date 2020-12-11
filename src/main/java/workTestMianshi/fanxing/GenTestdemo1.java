package workTestMianshi.fanxing;

public class GenTestdemo1 {
    public static void main(String[] args) {

        //System.out.println(Arrmid.<String>getmid("1", "2", "3"));


    }
}
class com{
    public static <T extends Comparable>T main(T[] args){//进行类型限定
        if (args==null || args.length==0) return null;
        T min=args[0];
        for (int i = 1; i < args.length; i++) {
            if (min.compareTo(args[i])>0){
                min=args[i];
            }
        }
        return min;
    }
}

class Node<T, E, F> {
    private T t;
    private E e;
    private F f;
}

class No<T>{
    private  T t;
}
class Arrmid{
    public static <T>T getmid(T... a){
        return a[a.length/2];
    }
}
