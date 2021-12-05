package ALeetCode题选.algorithmproblems.stackandqueue;

import java.util.Stack;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MyQueue {
    // 使用两个栈实现队列
    Stack<Integer> stack1;    // 保存反转之后的所有元素
    Stack<Integer> stack2;    // 辅助反转

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 实现入队操作
    public void push(int x){
        // 1. 将stack1中所有元素弹出，压入stack2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        // 2. 将新元素x压入stack1
        stack1.push(x);

        // 3. 将stack2中所有元素反向弹出压回到stack1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    // 出队操作
    public int pop(){
        return stack1.pop();
    }

    public int peek(){
        return stack1.peek();
    }

    public boolean empty(){
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());

        myQueue.pop();
        System.out.println(myQueue.empty());
    }
}
