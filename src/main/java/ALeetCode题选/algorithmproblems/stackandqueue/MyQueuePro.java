package ALeetCode题选.algorithmproblems.stackandqueue;

import java.util.Stack;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MyQueuePro {
    // 使用两个栈实现队列
    Stack<Integer> stack1;    // 入队时保存元素，正序
    Stack<Integer> stack2;    // 出队时保存元素，反序

    public MyQueuePro() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        // 直接将x压入stack1
        stack1.push(x);
    }

    // 出队时反转
    public int pop(){
        // 1. 判断stack2是否为空，如果为空，就将stack1中所有元素弹出，反序压入stack2
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        // 2. 直接弹出stack2的栈顶元素
        return stack2.pop();
    }

    public int peek(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueuePro myQueue = new MyQueuePro();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());

        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());

        myQueue.pop();
        System.out.println(myQueue.empty());

        myQueue.pop();
        myQueue.pop();

        System.out.println(myQueue.empty());
    }
}
