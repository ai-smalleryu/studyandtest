package LambdaTest;



import java.util.Comparator;

public class TestLambda {
   public  void test1()
   {
       Comparator<Integer> com=new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return  Integer.compare(o1,o2);
           }
       };
   }

   public void test2(){
       Comparator<Integer> com=(x,y)->Integer.compare(x,y);

   }

    public static void main(String[] args) {

    }
}
