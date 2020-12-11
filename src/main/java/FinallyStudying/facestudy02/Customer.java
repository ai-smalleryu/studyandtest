package FinallyStudying.facestudy02;


import com.google.common.util.concurrent.Monitor;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
  private  LinkedList linkedList=  new LinkedList<Integer>();
  //设置缓存区大小
  private static final int MAX=10;
  private static AtomicInteger atomicInteger=new AtomicInteger(0);
  private Monitor monitor=new Monitor();


}
