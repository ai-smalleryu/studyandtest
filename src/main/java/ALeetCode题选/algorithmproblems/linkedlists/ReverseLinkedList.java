package ALeetCode题选.algorithmproblems.linkedlists;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode.printList(listNode1);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode.printList(reverseLinkedList.reverseList(listNode1));
    }

    // 1. 迭代法
    public ListNode reverseList1(ListNode head){
        // 双指针，指向当前节点和上一个节点
        ListNode curr = head;
        ListNode prev = null;

        // 用while循环依次迭代
        while (curr != null){
            // prev -> curr -> next
            // 为了向后迭代，需要临时保存next节点
            ListNode next = curr.next;

            curr.next = prev;

            // 迭代
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 2. 递归法
    public ListNode reverseList(ListNode head){
        // 先写基准情况
        if (head == null || head.next == null)
            return head;

        // 接下来考虑当前head之后的部分已经反转的情况
        ListNode reversedHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return reversedHead;
    }
}
