package ALeetCode题选.algorithmproblems.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MyStackPro {
    // 只用一个队列实现栈
    Queue<Integer> queue;

    public MyStackPro() {
        queue = new LinkedList<>();
    }

    public void push(int x){
        // 获取当前队列长度
        int n = queue.size();

        // 1. 先把x放入队列中
        queue.offer(x);

        // 2. 队列中原来的元素依次出队，并再次入队
        for (int i = 0; i < n; i++){
            queue.offer( queue.poll() );
        }
    }

    // 出栈方法
    public int pop(){
        // queue1已经反转，可以直接出队
        return queue.poll();
    }

    // 获取栈顶元素
    public int top(){
        return queue.peek();
    }

    // 判断栈是否为空
    public boolean empty(){
        return queue.isEmpty();
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
