package LambdaTest;

import java.util.Comparator;
/*
lambda就是匿名函数
使用lambda表达式对某些接口进行表示（不是全部）
 */
public class LambdaDay01 {
    public static void main(String[] args) {
        //
        Comparator comparator=new Mycomparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return  (int)o1-(int)o2;
            }
        };
        //lambda表达
        Comparator comparator1=(a,b)->(int)a-(int)b;

    }
}


class Mycomparator implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        return (int)o1-(int)o2;
    }
}
