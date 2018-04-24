public class AddTwoNumbers {
    /**
     *
     You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     Example
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     */

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        int temp1 = 0;
        int temp2 = 0;
        while(l1!=null && l2!=null){
            temp2 = (l1.val + l2.val + temp1)%10;//先算本位再算进位
            temp1 = (l1.val + l2.val + temp1)/10;
            tmp.next = new ListNode(temp2);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
            if(l1 == null && l2 == null) break;
            if (l1 == null){
                l1 = new ListNode(0);
            }
            if (l2 == null){
                l2 = new ListNode(0);
            }
        }
        if(temp1 != 0){
            tmp.next = new ListNode(temp1);
        }
        return res.next;
    }
}
