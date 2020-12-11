package testOrm;

import javax.naming.spi.ObjectFactoryBuilder;
import java.util.ArrayList;

/*
自定义实现一个ArrayList了解底层原理
 */
public class SxtArrayList {
    private Object[] element;
    private int size;

    public SxtArrayList() {
        element = new Object[10];//默认长度
    }

    public SxtArrayList(int size) {
        element = new Object[size];//长度
    }

    public void add(Object o) {
        //数组扩容
        if (size == element.length) {
            Object[] objects = new Object[element.length + (element.length >> 1)];
            System.arraycopy(element, 0, objects, 0, element.length);
            element = objects;//覆盖原数组
        }
        element[size++] = o;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(element[i] + ",");
        }
        stringBuilder.append("]");//stringBUilder.setCharAt()
        return stringBuilder.toString();

    }

    //set get 方法
    //
    public Object get(int index) {
        return  element[index];
    }

    public void setElement(int index ,Object o) throws Exception {
        //索引合法判断
        if(index<0||index>size-1)
        {
            //抛出异常
            throw  new Exception("错误");
        }

        element[index]=o;
    }
//删除
    public void remove(int index)
    {
        int num=element.length-1-index;
        if (num>0) System.arraycopy(element,index+1,element,index,num);
        element[--size]=null;
    }
    public void remove (Object o)
    {
        //传入元素直接删除
        /*
        将他和所有元素对比直到找到相同的元素进行删除
         */
        for (int i = 0; i < size; i++) {
            if (o.equals(get(i)))
            {
                //将元素移除
                remove(i);
            }
        }
    }
    public static void main(String[] args) {

        SxtArrayList sxtArrayList = new SxtArrayList();
        sxtArrayList.add("a");
        sxtArrayList.add("ad");
        sxtArrayList.remove(1);
        System.out.println(sxtArrayList.toString());
    }
}
