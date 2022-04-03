package 剑指Offer;

import common.ListNode;

import java.util.List;

public class Offer52 {
    /**
     * 分别是L1+c长和L2+c长，第一条走完L1+c后再走L2，第二条走完L2+c后再走L1，总共都是走了L1+L2+c步
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2){
            l1 = l1 == null? headB : l1.next;
            l2 = l2 == null? headA : l2.next;
        }
        return l1;
    }
}
