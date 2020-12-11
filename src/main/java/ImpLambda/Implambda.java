package ImpLambda;

import Interlambda.IntLam1;
import Interlambda.IntLama2;
import org.w3c.dom.ls.LSOutput;

public class Implambda {
    public static void main(String[] args) {
        IntLam1 iml = () ->
        {
            System.out.println("hello ");
        };
        iml.test();
        System.out.println("--------------");
        IntLama2 in2 = (int a) ->
        {
            System.out.println("输入信息" + a);
        };
        in2.test2(67);
        System.out.println("++++++++++++++");


        //方法引用

    }
}
