package leetCode;

/**
 * @Author Administrator
 * @PACKAGE_NAME: leetCode
 * @PROJECT_NAME: studyandtest
 * @DESCRIPTION:
 * @USER: Administrator
 * @DATE: 2020/11/26 16:36
 */
public class TwoSum {
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode tem = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Netx = l1 == null ? 0 : l1.val;
            int l2Netx = l2 == null ? 0 : l2.val;

            int sum = l1Netx + l2Netx + carry;
            //记录留下来的数字
            int num = sum >= 10 ? sum - 10 : sum;
            //记录是否进一
            carry = sum >= 10 ? 1 : 0;

            tem.next = new ListNode(num);
            tem = tem.next;
            if (carry == 1) {
                tem.next = new ListNode(carry);
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3, new ListNode(7));
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(6, new ListNode(3));
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        System.out.println(listNode2.val);
        System.out.println(listNode2.next.val);
        System.out.println(listNode2.next.next.val);
        System.out.println(listNode2.next.next.next.val);
    }
}

class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resulList = new ListNode(0);
        resulList.next = null;
        int total = 1;
        while (l1 != null || l2 != null) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;
            int next = 0;
            next = resulList.next != null ? resulList.next.val : 0;
            int i = l1Num + l2Num + next;

            int carry; //记录是否进1
            int nexNum;//记录留下来的数字
            if (i >= 10) {
                nexNum = i % 10;
                carry = i / 10;
                resulList.val = nexNum;
                resulList.next = new ListNode(carry);
                ListNode listNode = resulList.next;
                resulList= listNode;
            } else {
                nexNum = i;
                resulList.val = nexNum;
                resulList.next = new ListNode(0);
                ListNode listNode = resulList.next;
                resulList= listNode;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return resulList;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode resulList = new ListNode(0);
        resulList.next = new ListNode(0);
        while (l1 != null || l2 != null) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;
            int i = l1Num + l2Num + resulList.val;

            int carry; //记录是否进1
            int nexNum;//记录留下来的数字
            if (i >= 10) {
                nexNum = i % 10;
                carry = i / 10;
                int ne = resulList != null ? resulList.next.val : 0;
                resulList.val = nexNum + ne;

                resulList.next = new ListNode(carry);
            } else {
                carry = 0;
                nexNum = i;
                int ne = resulList != null ? resulList.next.val : 0;
                resulList.val = nexNum + ne;
                resulList.next = new ListNode(0);
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return resulList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3, new ListNode(7));
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(6, new ListNode(3));
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        System.out.println(listNode2.val);
        System.out.println(listNode2.next.val);
        System.out.println(listNode2.next.next.val);
    }
}


class Solution3 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3, new ListNode(7));
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(6, new ListNode(3));
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        System.out.println(listNode2.val);
        System.out.println(listNode2.next.val);
        System.out.println(listNode2.next.next.val);
        System.out.println(listNode2.next.next.next.val);
    }
}

