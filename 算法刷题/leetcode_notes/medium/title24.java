package leetcode_notes.medium;


public class title24 {
    //title24.=====递归解法
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next== null)
            return head;
        ListNode next = head.next;
        head.next= swapPairs(next.next);
        next.next = head;
        return next;
    }
}

class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
