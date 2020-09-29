package leetcode_notes.simple;

/**
 * 找相交节点，双指针指向不同头节点，分别往后移，到达末尾后重新指向另一条节点的头节点
 * 比较相同后即可返回
 */
public class title160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2){
            temp1 = temp1 == null? headB : temp1.next;
            temp2 = temp2 == null? headA : temp2.next;
        }

        return temp1;

    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
