package leetcode_notes.medium;

import java.util.HashSet;
import java.util.Set;

//慢指针在走第一圈的时候一定会遇到快指针
public class title142_AA {
    //快慢指针
//    public ListNode detectCycle(ListNode head) {
//
//    }

    //利用set
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<ListNode>();
            while (pos != null) {
                if (visited.contains(pos)) {
                    return pos;
                } else {
                    visited.add(pos);
                }
                pos = pos.next;
            }
            return null;
        }
    }
}
