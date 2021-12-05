package ALeetCode题选.algorithmproblems.linkedlists;

import java.util.Stack;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode.printList(listNode1);

        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();

        ListNode.printList(removeNthNodeFromEnd.removeNthFromEnd(listNode1, 2));

        ListNode list2 = new ListNode(1, null);

        ListNode.printList(removeNthNodeFromEnd.removeNthFromEnd(list2, 1));
    }

    // 1. 顺序遍历，找到第l-n个节点
    public ListNode removeNthFromEnd1(ListNode head, int n){
        // 需要计算出链表长度
        int l = getListLength(head);

        // 定义一个哨兵节点，next指向头节点，方便处理边界情况
        ListNode sentinel = new ListNode(-1, head);


        ListNode curr = sentinel;
        // 顺序遍历，寻找第l-n个节点
        for (int i = 0; i < l - n; i++)
            curr = curr.next;

        // 跳过要删除的节点
        curr.next = curr.next.next;

        return sentinel.next;
    }

    // 定义一个计算链表长度的静态方法
    public static int getListLength(ListNode head){
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        return length;
    }

    // 2. 利用栈
    public ListNode removeNthFromEnd2(ListNode head, int n){
        // 定义一个哨兵节点，next指向头节点，方便处理边界情况
        ListNode sentinel = new ListNode(-1, head);

        // 定义一个栈
        Stack<ListNode> stack = new Stack<>();

        // 遍历整个链表，将节点全部入栈（包括哨兵）
        ListNode curr = sentinel;
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }

        // 依次弹出n个节点
        for (int i = 0; i < n; i++)
            stack.pop();

        // 剩余栈顶元素，就是要删除的上一个节点
        stack.peek().next = stack.peek().next.next;

        return sentinel.next;
    }

    // 3. 双指针
    public ListNode removeNthFromEnd(ListNode head, int n){
        // 定义一个哨兵节点，next指向头节点，方便处理边界情况
        ListNode sentinel = new ListNode(-1, head);

        // 定义双指针，初始的时候都指向哨兵
        ListNode first = sentinel, second = sentinel;

        // 首先移动first，向前走n+1步
        for (int i = 0; i < n + 1; i++)
            first = first.next;

        // 双指针同时移动，滑动窗口
        while (first != null){
            first = first.next;
            second = second.next;
        }

        // first指向null，此时second就指向了倒数第n+1个节点
        second.next = second.next.next;

        return sentinel.next;
    }
}
