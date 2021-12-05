package ALeetCode题选.algorithmproblems.linkedlists;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1Node3 = new ListNode(4, null);
        ListNode list1Node2 = new ListNode(2, list1Node3);
        ListNode list1Node1 = new ListNode(1, list1Node2);

        ListNode.printList(list1Node1);

        ListNode list2Node3 = new ListNode(4, null);
        ListNode list2Node2 = new ListNode(3, list2Node3);
        ListNode list2Node1 = new ListNode(1, list2Node2);

        ListNode.printList(list2Node1);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode.printList(mergeTwoSortedLists.mergeTwoLists(list1Node1, list2Node1));
    }

    // 1. 迭代法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode sentinel = new ListNode(-1);

        // 定义一个指针，指向合并好的链表的当前节点
        ListNode prev = sentinel;

        // 用两个指针遍历两个链表，直到至少有一个为null
        while (l1 != null && l2 != null){
            // 比较两个链表当前节点的值，较小的那个节点接在合并好的链表后面
            if (l1.val <= l2.val){
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }

        // 循环结束，只有一个链表还没遍历完；因为已经排序，所以可以直接接在合并后的链表后面
        prev.next = (l1 == null) ? l2 : l1;

        return sentinel.next;
    }

    // 2. 递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // 基准情况，有一条链已经为null
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        // 如果都没有遍历完，接下来就比较两个链表的头节点
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
