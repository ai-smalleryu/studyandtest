package ImpLambda;

import Interlambda.*;

public class ImpLambda1 {
    public static void main(String[] args) {

        //语法精简
        //在接口中已经定义了参数的类型和数量所以参数类型可以省略
        IntLama3 intLamaReal3=( a,  b)->
        {
            System.out.println(a+"as"+b);
        };

        //精简小括号，如果列表中参数只有一个小括号可以省略
        IntLama2 intLama2=a -> {
            System.out.println(a);
        };

        //方法大括号，方法体中只有一句时候可以省略
        IntLam1 im=()-> System.out.println("a");

        //如果方法体中唯一的语句是返回语句，在省略掉大括号同时必须去掉return
        IntLamaReal1 intLamaReal1 =()-> 15;

        //多参数有返回值
        IntLamaReal3 intLamaReal31=(a,b)->a+b;

    }

}
