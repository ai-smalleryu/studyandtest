package FinallyStudying.facestudy02;

import java.util.Objects;

public class EquesQustion {
    /**
     * 对于eques的使用 null的位置
     */
    public static void main(String[] args) {
        String s11=new String("asd");
        String s22=new String("asd");
        System.out.println(s11.hashCode()+"----"+s22.hashCode());
        System.out.println(s11==s22);
        System.out.println("------------------");
        String s="abs";
        //错误写法
        System.out.println(s.equals("abs"));//这里的s如果为空值会报空指针异常
        //建议写法一
        System.out.println("abs".equals(s));//建议写法一。这里不会出现空指针异常
        //
        System.out.println(Objects.equals(s,"abs"));//最好的方法
        String s1="tom";
        System.out.println(Objects.deepEquals(s1,"tom"));

        String s2="";
        s2=s+s1;//注意这个+在底层调用的是Stringbuffer 或者stringbudder的append方法
        StringBuilder stringBuilder=new StringBuilder("as");
        StringBuffer stringBuffer =new StringBuffer("tom");
    }
}
