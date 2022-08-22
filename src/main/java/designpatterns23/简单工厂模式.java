package designpatterns23;

public class 简单工厂模式 {
    public static ListNode partition(ListNode head,int x){
        ListNode small =new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large=large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){this.val=val;this.next=next;}
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, new ListNode(2, new ListNode(8, new ListNode(4))));
        ListNode partition = partition(listNode, 5);
        System.out.println(partition.val+","+partition.next.val
                +","+partition.next.next.val+","+partition.next.next.next.val);
    }
}
