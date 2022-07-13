package leetcode_notes.链表;

import common.ListNode;

public class Example {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode h = head;
                while (h != slow){
                    h = h.next;
                    slow = slow.next;
                }
                return h;
            }
        }
        return null;
    }
    //利用set
//    public class Solution {
//        public ListNode detectCycle(ListNode head) {
//            ListNode pos = head;
//            Set<ListNode> visited = new HashSet<ListNode>();
//            while (pos != null) {
//                if (visited.contains(pos)) {
//                    return pos;
//                } else {
//                    visited.add(pos);
//                }
//                pos = pos.next;
//            }
//            return null;
//        }
//    }

    //title147
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode last = head;
        //这里初始化设置多少不影响
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val >= last.val){
                last.next = cur;
                last = last.next;
            }else {
                ListNode pre = dummyHead;
                while (pre.next.val <= cur.val){
                    pre = pre.next;
                }
                //重要
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            //和上面的配合
            cur = last.next;
        }
        return dummyHead.next;
    }

    /**递归翻转链表
     * reverse 函数的意思是把从head开始后面的链表翻转后返回新链表的头节点
     * 1 -> 2 -> 3 -> 4 -> 5    1是head
     * 1 -> 2 <- 3 <- 4 <- 5    reverse(head.next)执行后， 5是last
     * 1 <=> 2 <- 3 <- 4 <- 5   head.next.next = head;
     * 1 <- 2 <- 3 <- 4 <- 5    head.next = null;
     */
    public ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        //拿到翻转后的链表头节点
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 翻转前 N 个节点
     */
    ListNode successor = null; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 翻转m-n的链表节点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) return reverseN(head, n);
        //前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }


}
