package leetcode_notes.simple;

public class title141_AA {
    public boolean hasCycle(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = t1;
        while (t2.next != null){
            t2 = t2.next.next;
            t1 = t1.next;
            if (t1 == t2){
                return true;
            }
        }
        return false;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
