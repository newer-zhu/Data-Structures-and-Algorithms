package leetcode_notes.medium;

public class title19_AAA {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode  t1 = head;
        ListNode t2 = head;
        for (int i=0; i<n; i++)
            t1 = t1.next;
        if(t1 == null){
            t2 = t2.next;
            return t2;
        }
        while (t1.next != null){
            t1 = t1.next;
            t2 = t2.next;
        }
        t2.next = t2.next.next;
        return head;
    }
}
