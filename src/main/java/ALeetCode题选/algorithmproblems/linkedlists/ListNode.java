package ALeetCode题选.algorithmproblems.linkedlists;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
