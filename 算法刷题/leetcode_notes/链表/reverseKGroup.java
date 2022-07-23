package leetcode_notes.链表;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class reverseKGroup {
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode t1 = head;
        ListNode t2 = head;
        for (int i=0; i<n; i++)
            t1 = t1.next;
        if(t1 == null){
            return t2.next;
        }
        while (t1.next != null){
            t1 = t1.next;
            t2 = t2.next;
        }
        t2.next = t2.next.next;
        return head;
    }

}
