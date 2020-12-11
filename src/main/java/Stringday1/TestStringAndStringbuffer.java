package Stringday1;

import org.junit.jupiter.api.Test;


public class TestStringAndStringbuffer {
    /*
    Stringbuilder stringbuffer
     */

    //string builder可变的字符序列
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("adsdasdx");//线程不安全
        System.out.println(Integer.toHexString(stringBuilder.hashCode())+"哈希码");//哈希码
        System.out.println(stringBuilder+"字符串");

        stringBuilder.setCharAt(2,'K');//换字符,下标2的位置替换成K
        System.out.println(Integer.toHexString(stringBuilder.hashCode()));//查定哈希码，判断
        System.out.println(stringBuilder);

        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i=0;i<26;i++)
        {
            char c=(char)('a'+i);
            stringBuilder1.append(c);//append拼接字符串
        }
        System.out.println(stringBuilder1);
        stringBuilder1.reverse();//字符串反转
        System.out.println(stringBuilder1);
        stringBuilder1.setCharAt(1,'L');
        System.out.println(stringBuilder1);
        stringBuilder1.insert(0,"我");
        System.out.println(stringBuilder1);
        //delete 删除
        //append拼接常用

        System.out.println("------------------");
        //字符串拼接
        //不要使用+这时是两个对象str=str+new ;
//如
        String s=new String("");
        for (int i=0;i<100;i++)
        {
            s=s+i;//总共产生了200个对象
        }

        //应当使用String Builder
        StringBuilder stringBuilder2 = new StringBuilder("");
        for (int i=0;i<100;i++)
        {
            stringBuilder2.append(i);//循环累加用String builder
        }

    }
   @Test
    public void contectString(){
        String s="aaa";
        String na="plj";
        System.out.println(s.concat(na));

    }}
