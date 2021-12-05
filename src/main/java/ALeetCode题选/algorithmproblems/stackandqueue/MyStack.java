package ALeetCode题选.algorithmproblems.stackandqueue;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MyStack {
    // 使用两个队列来实现一个栈，queue1用来保存反序的所有栈元素，queue2用来辅助反转
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 入栈方法
    public void push(int x){
        // 1. 先把x放入空辅助队列queue2中
        queue2.offer(x);

        // 2. 将queue1中的所有元素，依次出队，添加到queue2中，跟在x后面
        while (!queue1.isEmpty()){
            queue2.offer( queue1.poll() );
        }

        // 3. 交换两队列指针
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // 出栈方法
    public int pop(){
        // queue1已经反转，可以直接出队
        return queue1.poll();
    }

    // 获取栈顶元素
    public int top(){
        return queue1.peek();
    }

    // 判断栈是否为空
    public boolean empty(){
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.empty());

        myStack.push(123);
        myStack.push(456);
        myStack.push(656);

        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

        myStack.pop();
        myStack.pop();

        System.out.println(myStack.empty());
    }
}
